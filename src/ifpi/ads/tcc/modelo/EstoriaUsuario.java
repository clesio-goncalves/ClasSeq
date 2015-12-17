package ifpi.ads.tcc.modelo;

import ifpi.ads.tcc.exportar.CodigoJava;
import ifpi.ads.tcc.exportar.ImagemDiagramaDeClasse;
import ifpi.ads.tcc.exportar.XMI;
import ifpi.ads.tcc.extrator.Extrator;
import ifpi.ads.tcc.padroes.DiagramaDeClasse;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.web.multipart.MultipartFile;

import ptstemmer.exceptions.PTStemmerException;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class EstoriaUsuario {

	private String estoriaUsuario;
	private String estoriaInicial;
	private String titulo = "";
	private String ator = "";
	private List<String> lista;
	private List<String> novaEstoria;
	private DiagramaDeClasse diagramaDeClasse;
	private Extrator extrator;
	private XMI xmi;
	private CodigoJava codigoJava;
	private ImagemDiagramaDeClasse imagemDiagramaDeClasse;
	private String estoriaFormatada;

	public EstoriaUsuario() {

	}

	public EstoriaUsuario(HttpServletRequest request,
			HttpServletResponse response, String estoriaUsuario) {
		this.estoriaUsuario = estoriaUsuario;

		this.lista = new ArrayList<String>();
		this.novaEstoria = new ArrayList<String>();

		this.estoriaFormatada = formataEstoria();

		// DiagramaDeClasse
		try {
			this.diagramaDeClasse = new DiagramaDeClasse(this.ator);
		} catch (PTStemmerException e) {
			e.printStackTrace();
		}

		// Extrator
		this.extrator = new Extrator(this.estoriaFormatada,
				this.diagramaDeClasse);
		this.diagramaDeClasse = this.extrator.extrair();
		this.extrator.devolveClasses();
		this.extrator.devolveRelacionamentos();
		this.extrator.devolveAtor();
		this.extrator.devolveRadicais();

		// XMI
		this.xmi = new XMI(this.diagramaDeClasse);
		this.xmi.gerarXMI21();
		this.xmi.gerarXMI12();

		// CodigoJava
		this.codigoJava = new CodigoJava(this.diagramaDeClasse);
		this.codigoJava.gerarCodigoJava(request, response);

		// ImagemDiagramaDeClasse
		this.imagemDiagramaDeClasse = new ImagemDiagramaDeClasse(
				diagramaDeClasse);
		this.imagemDiagramaDeClasse.gerarImagem();
		System.out.println(this.imagemDiagramaDeClasse.getCaminhoImagem());

	}

	public String formataEstoria() {

		this.estoriaInicial = this.estoriaUsuario;
		String[] estoria = this.estoriaUsuario.split("\n");

		// Remove linhas que não me interessam
		estoria = removeLinhas(estoria);

		// Se a estoria não contém titulo
		if (this.titulo.equals("")) {
			this.titulo = "Título: Estoria de usuário sem título";
		}

		// Palavras reservadas
		estoria = removePalavrasReservadas(estoria);

		// Remove Mensagem e devo|deve + verbo posterior e
		// Remove Linhas em branco e acrescenta ponto
		removeMensagemDeveVerboELinhasEmBranco(estoria);

		// Monta string novamente
		this.estoriaUsuario = "";
		for (String string : novaEstoria) {
			this.estoriaUsuario += string;
		}

		return this.estoriaUsuario;
	}

	private String[] removeLinhas(String[] estoria) {
		// Linhas que contem essas palavras devem ser removidas
		lista.add("Título:");
		lista.add("Narrativa:");
		lista.add("De modo que");
		lista.add("Cenário:");
		lista.add("Como um ");

		for (int i = 0; i < estoria.length; i++) {

			// Retorna o titulo da estoria e o ator
			if (estoria[i].contains("Título:")) {
				this.titulo = estoria[i];
			} else if (estoria[i].contains("Como um ")) {
				this.ator = estoria[i].replace("Como um ", "").trim();
			}

			for (int j = 0; j < lista.size(); j++) {
				if (estoria[i].contains(lista.get(j))) {
					estoria[i] = "";
				}
			}
		}

		return estoria;
	}

	private String[] removePalavrasReservadas(String[] estoria) {
		lista.add("Desejo ");
		lista.add("Dado que ");
		lista.add("Quando ");
		lista.add("Então ");
		lista.add("E ");

		String frase = null;

		for (int i = 0; i < estoria.length; i++) {
			for (int j = 0; j < lista.size(); j++) {
				if (estoria[i].contains(lista.get(j))) {
					frase = estoria[i].replace(lista.get(j), "");
					estoria[i] = frase;
				}
			}
		}

		return estoria;

	}

	private List<String> removeMensagemDeveVerboELinhasEmBranco(String[] estoria) {
		String frase = null;

		for (int i = 0; i < estoria.length; i++) {
			// Remove tudo que estiver entre aspas
			frase = estoria[i].replaceAll("\".+\"", "");

			// Remove o verbo deve|devo + espaço + verbo
			frase = frase.replaceAll("(deve|devo)\\s[a-zA-Z]+", "");

			estoria[i] = frase;

			// removeLinhasEmBranco
			if (!estoria[i].trim().equals("")) {
				this.novaEstoria.add(estoria[i] + ".");
			}
		}

		return this.novaEstoria;

	}

	public void lerTxtStory(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file) {

		try {
			String caminho = caminhoUpload(request, response, file);

			// Lê o arquivo para inserir o texto no TexTarea
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(caminho)));

			String s = br.readLine(); // lê a primeira linha
			String texto = "";

			while (s != null) {
				texto += s + "\n";
				s = br.readLine(); // Lê da segunda em diante
			}

			br.close();

			this.estoriaInicial = texto;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void lerPDF(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file) {

		try {
			String caminho = caminhoUpload(request, response, file);

			// Começa a leitura do PDF
			PDDocument pdfDocument = null;

			pdfDocument = PDDocument.load(caminho);
			PDFTextStripper stripper = new PDFTextStripper();
			String texto = stripper.getText(pdfDocument);

			// Fecha o documento PDF
			pdfDocument.close();

			this.estoriaInicial = texto;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lerDocWord(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file) {

		try {
			String caminho = caminhoUpload(request, response, file);

			// Começa a leitura do Documento do Word
			HWPFDocument documento = new HWPFDocument(new FileInputStream(
					new File(caminho)));
			WordExtractor extractor = new WordExtractor(documento);

			this.estoriaInicial = extractor.getText().trim();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String caminhoUpload(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file) throws Exception {

		byte[] bytes = file.getBytes();

		String caminhoArquivo = "resources/arquivos/upload";

		// retorna o caminho absoluto da aplicação
		ServletContext context = request.getServletContext();
		String caminhoAplicacao = context.getRealPath("");

		// constroi o caminho absoluto do arquivo e cria o arquivo
		String caminho = caminhoAplicacao + caminhoArquivo;

		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(caminho)));
		stream.write(bytes);
		stream.close();

		return caminho;

	}

	public void downloadEstoriaUsuarioTxtStory(HttpServletRequest request,
			HttpServletResponse response, String formato) {

		try {
			String caminho = caminhoDownload(request, response, formato);

			File arquivo = new File(caminho);

			// Escreve no arquivo
			FileOutputStream outputStream;

			outputStream = new FileOutputStream(arquivo);

			outputStream.write(this.estoriaInicial.getBytes());
			outputStream.close();

			// Realiza o download da Estoria de Usuário
			realizaDownload(response, arquivo);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void downloadEstoriaUsuarioDoc(HttpServletRequest request,
			HttpServletResponse response, String formato) {

		try {
			String caminho = caminhoDownload(request, response, formato);
			File arquivo = new File(caminho);

			XWPFDocument documento = new XWPFDocument();
			XWPFParagraph tmpParagraph = documento.createParagraph();
			XWPFRun tmpRun = tmpParagraph.createRun();
			tmpRun.setText(this.estoriaInicial);
			FileOutputStream fos = new FileOutputStream(arquivo);
			documento.write(fos);
			fos.close();

			// Realiza o download da Estoria de Usuário
			realizaDownload(response, arquivo);

		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	public void downloadEstoriaUsuarioPdf(HttpServletRequest request,
			HttpServletResponse response, String formato) {

		try {
			String caminho = caminhoDownload(request, response, formato);
			File arquivo = new File(caminho);

			// cria o documento tamanho A4, margens de 2,54cm
			Document documento = new Document();

			// cria a stream de saída
			OutputStream os = new FileOutputStream(arquivo);

			PdfWriter.getInstance(documento, os);

			// abre o documento
			documento.open();

			// adiciona o texto ao PDF
			Paragraph p = new Paragraph(this.estoriaInicial);
			documento.add(p);

			documento.close();
			os.close();

			// Realiza o download
			realizaDownload(response, arquivo);

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	private String caminhoDownload(HttpServletRequest request,
			HttpServletResponse response, String formato) {

		String caminhoArquivo = "resources/arquivos/estoria-usuario" + formato;

		// retorna o caminho absoluto da aplicação
		ServletContext context = request.getServletContext();
		String caminhoAplicacao = context.getRealPath("");

		// constroi o caminho absoluto do arquivo e cria o arquivo
		String caminho = caminhoAplicacao + caminhoArquivo;

		return caminho;
	}

	private void realizaDownload(HttpServletResponse response, File arquivo) {
		try {
			// realiza o download do arquivo quando clica em download
			InputStream inputStream = new FileInputStream(arquivo);

			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ arquivo.getName());
			IOUtils.copy(inputStream, response.getOutputStream());

			response.flushBuffer();
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getEstoriaUsuario() {
		return estoriaUsuario;
	}

	public void setEstoriaUsuario(String estoriaUsuario) {
		this.estoriaUsuario = estoriaUsuario;
	}

	public String getEstoriaInicial() {
		return estoriaInicial;
	}

	public void setEstoriaInicial(String estoriaInicial) {
		this.estoriaInicial = estoriaInicial;
	}

	public String getTitulo() {
		return titulo;
	}

	public XMI getXmi() {
		return xmi;
	}

	public CodigoJava getCodigoJava() {
		return codigoJava;
	}

	public ImagemDiagramaDeClasse getImagemDiagramaDeClasse() {
		return imagemDiagramaDeClasse;
	}

}