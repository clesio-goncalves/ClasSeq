package ifpi.ads.tcc.extrator;

import ifpi.ads.tcc.padroes.DiagramaDeClasse;

import java.util.Map;
import java.util.Set;

public class Extrator {

	private String estoria;
	private DiagramaDeClasse diagramaDeClasse;

	public Extrator(String estoria, DiagramaDeClasse diagramaDeClasse) {
		this.estoria = estoria;
		this.diagramaDeClasse = diagramaDeClasse;
	}

	public DiagramaDeClasse extrair() {
		ExtratorClasseMetodo extratorClasse = new ExtratorClasseMetodo(
				this.estoria, this.diagramaDeClasse);
		ExtratorAtributoRelacionamento extratorAtributoRelacionamento = new ExtratorAtributoRelacionamento(
				this.estoria, this.diagramaDeClasse);

		// Extrair
		extratorClasse.extrairClasseMetodo();
		extratorAtributoRelacionamento.extrairAtributoRelacionamento();

		return this.diagramaDeClasse;

	}

	public void devolveClasses() {
		System.out.println("Classes");
		for (String key : this.diagramaDeClasse.getDiagramaDeClasse().keySet()) {
			Set<String> value = this.diagramaDeClasse.getDiagramaDeClasse()
					.get(key);
			System.out.println(key + " = " + value);
		}
	}

	public void devolveRelacionamentos() {
		System.out.println("Relacionamentos");
		for (String key : this.diagramaDeClasse.getRelacionamento().keySet()) {
			Set<String> value = this.diagramaDeClasse.getRelacionamento().get(
					key);
			System.out.println(key + " = " + value);
		}
	}

	public void devolveAtor() {
		System.out.println("Ator");
		System.out.println(this.diagramaDeClasse.getAtor());
	}

	public void devolveRadicais() {
		System.out.println("Radicais");
		Map<String, String> radicais = this.diagramaDeClasse
				.getRadicalDiagramaDeClasse();
		System.out.println(radicais);
	}
}