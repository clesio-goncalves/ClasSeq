package ifpi.ads.tcc.controller;

import ifpi.ads.tcc.modelo.EstoriaUsuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EstoriaUsuarioController {

	private EstoriaUsuario estoria;

	@RequestMapping("novaEstoriaUsuario")
	public String nova(Model model) {
		this.estoria = null;
		return "redirect:estoriaUsuario";
	}

	@RequestMapping("estoriaUsuario")
	public String estoria(Model model) {
		model.addAttribute("estoria", this.estoria);
		return "estoria-usuario/estoria";
	}

	@RequestMapping("adicionaEstoriaUsuario")
	public String adiciona(HttpServletRequest request,
			HttpServletResponse response, EstoriaUsuario estoria) {

		long tempoInicial = System.currentTimeMillis();

		// Instancia a estoriaUsuario
		this.estoria = new EstoriaUsuario(request, response,
				estoria.getEstoriaUsuario());

		long tempoFinal = System.currentTimeMillis();
		System.out.println("Tempo de execução: " + (tempoFinal - tempoInicial));

		return "redirect:exibirEstoriaUsuario";
	}

	@RequestMapping("exibirEstoriaUsuario")
	public String exibir(Model model) {
		if (this.estoria != null) {
			model.addAttribute("imagem", this.estoria
					.getImagemDiagramaDeClasse().getCaminhoImagem());
			model.addAttribute("titulo", this.estoria.getTitulo());
			return "estoria-usuario/exibir";
		} else {
			return "redirect:estoriaUsuario";
		}
	}

	@RequestMapping("downloadXmi21")
	public void downloadXmi21(HttpServletRequest request,
			HttpServletResponse response) {
		this.estoria.getXmi().downloadXMI(request, response, 21);
	}

	@RequestMapping("downloadXmi12")
	public void downloadXmi12(HttpServletRequest request,
			HttpServletResponse response) {
		this.estoria.getXmi().downloadXMI(request, response, 12);
	}

	@RequestMapping("downloadJava")
	public void downloadJava(HttpServletRequest request,
			HttpServletResponse response) {
		this.estoria.getCodigoJava().downloadCodigoJava(request, response);
	}

	@RequestMapping("downloadImagem")
	public void downloadImagem(HttpServletRequest request,
			HttpServletResponse response) {
		this.estoria.getImagemDiagramaDeClasse().downloadImagem(request,
				response);
	}

	@RequestMapping("downloadTxt")
	public void downloadTxt(HttpServletRequest request,
			HttpServletResponse response) {
		this.estoria.downloadEstoriaUsuarioTxtStory(request, response, ".txt");
	}

	@RequestMapping("downloadDoc")
	public void downloadDoc(HttpServletRequest request,
			HttpServletResponse response) {
		this.estoria.downloadEstoriaUsuarioDoc(request, response, ".doc");
	}

	@RequestMapping("downloadStory")
	public void downloadStory(HttpServletRequest request,
			HttpServletResponse response) {
		this.estoria
				.downloadEstoriaUsuarioTxtStory(request, response, ".story");
	}

	@RequestMapping("downloadPdf")
	public void downloadPdf(HttpServletRequest request,
			HttpServletResponse response) {
		this.estoria.downloadEstoriaUsuarioPdf(request, response, ".pdf");
	}

	@RequestMapping("upload")
	public String upload(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("arquivo") MultipartFile file,
			@RequestParam("extensao") String extensao) {

		// Testa se a estoria de usuário ja foi criada
		if (this.estoria == null) {
			this.estoria = new EstoriaUsuario();
		}

		if (!file.isEmpty()) {
			if (extensao.equals(".story") | extensao.equals(".txt")) {
				this.estoria.lerTxtStory(request, response, file);
			} else if (extensao.equals(".doc")) {
				this.estoria.lerDocWord(request, response, file);
			} else if (extensao.equals(".pdf")) {
				this.estoria.lerPDF(request, response, file);
			} else {
				// Caso venha a desativar o javaScript e enviar o arquivo com a
				// extensão incorreta
				this.estoria.setEstoriaInicial("");
			}
			return "redirect:estoriaUsuario";
		}
		// Caso venha a desativar o javaScript e enviar sem arquivo
		this.estoria.setEstoriaInicial("");
		return "redirect:estoriaUsuario";
	}

}