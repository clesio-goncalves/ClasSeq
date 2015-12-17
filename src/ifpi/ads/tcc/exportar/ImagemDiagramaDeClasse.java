package ifpi.ads.tcc.exportar;

import ifpi.ads.tcc.padroes.DiagramaDeClasse;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class ImagemDiagramaDeClasse {

	private String caminhoImagem;
	private DiagramaDeClasse diagramaDeClasse;
	private List<String> atributos;
	private List<String> metodos;
	private String[] aux;
	private int i = 0, j = 0;

	public ImagemDiagramaDeClasse(DiagramaDeClasse diagramaDeClasse) {
		this.diagramaDeClasse = diagramaDeClasse;
		this.atributos = new ArrayList<String>();
		this.metodos = new ArrayList<String>();
	}

	public String gerarImagem() {
		String src = "";
		StringBuilder auxBuilder = new StringBuilder();
		StringBuilder builder = new StringBuilder();
		builder.append("<img src=\"http://yuml.me/diagram/scruffy/class/");

		// Classes e relacionamentos
		for (String key : this.diagramaDeClasse.getRelacionamento().keySet()) {
			for (String value : this.diagramaDeClasse.getRelacionamento().get(
					key)) {
				this.aux = value.split(":");

				builder.append("[" + this.aux[0] + "]");
				if (key.equals("1:n")) {
					builder.append("1-*");
				} else {
					builder.append("1-1");
				}

				builder.append("[" + this.aux[1] + "]");

				this.j++;

				if (this.diagramaDeClasse.getRelacionamento().get(key).size() != this.j) {
					builder.append(",");
				}
			}

			this.i++;
			this.j = 0;

			if (this.diagramaDeClasse.getRelacionamento().size() > this.i) {
				builder.append(",");
			}
		}

		// Adiciona Atributos e métodos
		for (String key : this.diagramaDeClasse.getDiagramaDeClasse().keySet()) {
			auxBuilder.append("[");
			auxBuilder.append(key);

			// Verifica todos atributos e metodos e insere em uma lista
			for (String value : this.diagramaDeClasse.getDiagramaDeClasse()
					.get(key)) {
				if (value.contains("_")) {
					value = value.replace("_", " ");
					this.atributos.add(value);
				} else {
					this.metodos.add(value);
				}
			}

			auxBuilder.append("|");

			// Adiciona todos os atributos na string
			if (this.atributos.size() != 0) {
				// Do primeiro ao penultimo
				for (int i = 0; i < this.atributos.size() - 1; i++) {
					auxBuilder.append("-" + this.atributos.get(i));
					auxBuilder.append(";");
				}

				auxBuilder.append("-"
						+ this.atributos.get(this.atributos.size() - 1));
				this.atributos.removeAll(this.atributos);

			}

			auxBuilder.append("|");

			// Adiciona todos os métodos na string
			if (this.metodos.size() != 0) {
				// Do primeiro ao penultimo
				for (int i = 0; i < this.metodos.size() - 1; i++) {
					auxBuilder.append("+" + this.metodos.get(i));
					auxBuilder.append(";");
				}

				auxBuilder.append("+"
						+ this.metodos.get(this.metodos.size() - 1));
				this.metodos.removeAll(this.metodos);

			}

			auxBuilder.append("]");

			// Verifica se a classe ja foi inserida no relacionamento
			// Caso sim, substitui. Senão insere na string
			if (builder.toString().contains("[" + key + "]")) {
				src = builder.toString().replaceAll("\\[" + key + "\\]",
						auxBuilder.toString());

				builder.delete(0, builder.length());
				builder.append(src);
			} else {
				// Só adiciona a vírgula se houver relacionamentos
				if (this.diagramaDeClasse.getRelacionamento().size() > 0) {
					builder.append(",");
				}
				builder.append(auxBuilder.toString());
			}
			auxBuilder.delete(0, auxBuilder.length());
		}

		builder.append("\" >");

		this.caminhoImagem = builder.toString();

		return this.caminhoImagem;
	}

	public void downloadImagem(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			// realiza o download do arquivo quando clica em download

			// monta o endereço da imagem
			String[] enderecoImagem = this.caminhoImagem.split("\"");

			URL url = new URL(enderecoImagem[1]);
			InputStream inputStream = new BufferedInputStream(url.openStream());

			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition",
					"attachment; filename=imagemDiagramaDeClasse.png");
			IOUtils.copy(inputStream, response.getOutputStream());

			response.flushBuffer();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

}