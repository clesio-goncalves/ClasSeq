package ifpi.ads.tcc.exportar;

import ifpi.ads.tcc.padroes.DiagramaDeClasse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class CodigoJava {

	private DiagramaDeClasse diagramaDeClasse;
	private List<String> atributos;
	private String[] array_atributo;
	private StringBuilder builder;

	public CodigoJava(DiagramaDeClasse diagramaDeClasse) {
		this.diagramaDeClasse = diagramaDeClasse;
		this.atributos = new ArrayList<String>();
		this.builder = new StringBuilder();
	}

	public void gerarCodigoJava(HttpServletRequest request,
			HttpServletResponse response) {

		try {

			String caminho = retornaCaminho(request, response, "codigojava");

			for (String key : this.diagramaDeClasse.getDiagramaDeClasse()
					.keySet()) {

				BufferedWriter br = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(caminho + key + ".java")));

				// Pacote
				gerarPacote();

				// Classe
				gerarClasse(key);

				// Atributo
				for (String value : this.diagramaDeClasse.getDiagramaDeClasse()
						.get(key)) {
					if (value.contains("_")) {
						value = value.replace("_", " ");

						// Atributo
						gerarAtributo(value);
						this.atributos.add(value);

					}
				}

				// Construtor Sem Argumento
				gerarConstrutorSemArgumento(key);

				// Construtor com argumento
				if (this.atributos.size() != 0) {
					gerarConstrutorComArgumento(key, this.atributos);
					this.atributos.removeAll(this.atributos);
				}

				// Metodo
				for (String value : this.diagramaDeClasse.getDiagramaDeClasse()
						.get(key)) {
					if (value.contains(" ")) {
						// Metodo
						gerarMetodo(value);
					}
				}

				// Gerar metodos Get e Set
				for (String value : this.diagramaDeClasse.getDiagramaDeClasse()
						.get(key)) {
					if (value.contains("_")) {
						// GetSet
						gerarGetSet(value);
					}
				}

				// Fecha a classe
				this.builder.append("\n}");

				// Escreve no arquivo
				br.write(this.builder.toString());
				this.builder.delete(0, this.builder.length());

				br.close();

			}

		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public void downloadCodigoJava(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			String nomeZip = "estoria-usuario-java.zip";
			String caminhoZip = retornaCaminho(request, response, "zip")
					+ nomeZip;
			String caminhoArquivos = retornaCaminho(request, response,
					"codigojava");

			// gera o arquivo ZIP
			ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(
					caminhoZip));

			File pasta = new File(caminhoArquivos);
			for (File arquivo : pasta.listFiles()) {

				String nomeClasse = arquivo.getName().toString()
						.replace(".java", "");

				// Verifica quais os arquivos para serem baixados
				if (this.diagramaDeClasse.getDiagramaDeClasse().containsKey(
						nomeClasse)) {

					zipOut.putNextEntry(new ZipEntry(arquivo.getName()
							.toString()));

					FileInputStream fis = new FileInputStream(arquivo);

					int conteudo;
					while ((conteudo = fis.read()) != -1) {
						zipOut.write(conteudo);
					}

					zipOut.closeEntry();
				}
			}

			zipOut.close();

			// realiza o download do arquivo zip quando clica em download
			InputStream inputStream = new FileInputStream(caminhoZip);

			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ nomeZip);
			IOUtils.copy(inputStream, response.getOutputStream());

			response.flushBuffer();
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String retornaCaminho(HttpServletRequest request,
			HttpServletResponse response, String tipo) {

		String caminhoArquivo = "";

		switch (tipo) {
		case "codigojava":
			caminhoArquivo = "resources/arquivos/codigojava/";
			break;

		case "zip":
			caminhoArquivo = "resources/arquivos/";
			break;

		default:
			break;
		}

		// retorna o caminho absoluto da aplicação
		ServletContext context = request.getServletContext();
		String caminhoAplicacao = context.getRealPath("");

		// retorna o caminho absoluto do arquivo a ser criado
		return caminhoAplicacao + caminhoArquivo;

	}

	private void gerarPacote() {
		this.builder.append("package codigojava;");
	}

	private void gerarClasse(String nome) {
		this.builder.append("\n\npublic class " + nome + " {\n\n");
	}

	private void gerarAtributo(String atributo) {
		this.builder.append("\tprivate " + atributo + ";\n");
	}

	private void gerarConstrutorSemArgumento(String classe) {
		this.builder.append("\n\n\tpublic " + classe + " () {\n\n\t}");
	}

	private void gerarConstrutorComArgumento(String classe,
			List<String> atributos) {

		this.builder.append("\n\n\tpublic " + classe + " (");

		// Parâmetros do Construtor
		for (int i = 0; i < atributos.size() - 1; i++) {
			this.builder.append(atributos.get(i));
			this.builder.append(", ");
		}

		// Último Parametro
		this.builder.append(atributos.get(atributos.size() - 1));
		this.builder.append(") {");

		// Corpo do construtor
		for (String atributo : atributos) {
			this.array_atributo = atributo.split(" ");
			atributo = this.array_atributo[1];
			this.builder.append("\n\t\t" + "this." + atributo + " = "
					+ atributo + ";");
		}

		this.builder.append("\n\t}");
	}

	private void gerarMetodo(String assinaturaMetodo) {
		this.builder.append("\n\n\tprivate void " + assinaturaMetodo
				+ " {\n\n\t}");
	}

	private void gerarGetSet(String atributo) {

		this.array_atributo = atributo.split("_");
		atributo = this.array_atributo[1];

		this.builder.append("\n\n\tpublic String get"
				+ primeiraLetraMaiuscula(atributo) + "() {\n\t\treturn "
				+ atributo + ";\n\t}");

		this.builder.append("\n\n\tpublic void set"
				+ primeiraLetraMaiuscula(atributo) + "("
				+ this.array_atributo[0] + " " + atributo + ") {\n\t\tthis."
				+ atributo + " = " + atributo + ";\n\t}");
	}

	private String primeiraLetraMaiuscula(String nome) {
		return nome.substring(0, 1).toUpperCase() + nome.substring(1);
	}

}
