package ifpi.ads.tcc.padroes;

import ifpi.ads.tcc.jdbc.dao.TccDao;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import ptstemmer.Stemmer;
import ptstemmer.exceptions.PTStemmerException;
import ptstemmer.implementations.OrengoStemmer;

public class DiagramaDeClasse {

	private Map<String, LinkedHashSet<String>> diagramaDeClasse;
	private Map<String, LinkedHashSet<String>> relacionamento;
	private Stemmer stemmer;
	private TccDao dao;
	private String ator = "";
	private Set<String> metodoAguardeProxima;
	private Set<String> atributoAguardeProxima;
	private Map<String, String> radicalDiagramaDeClasse;
	private LinkedHashSet<String> valores;
	private String classe;
	private String[] split;
	private String radical;

	public DiagramaDeClasse(String ator) throws PTStemmerException {
		this.diagramaDeClasse = new HashMap<String, LinkedHashSet<String>>();
		this.relacionamento = new HashMap<String, LinkedHashSet<String>>();
		this.dao = new TccDao();
		this.metodoAguardeProxima = new LinkedHashSet<String>();
		this.atributoAguardeProxima = new LinkedHashSet<String>();
		this.radicalDiagramaDeClasse = new HashMap<String, String>();
		this.stemmer = new OrengoStemmer();
		addAtor(ator);
	}

	public void addAtor(String ator) {

		if (!ator.equals("")) {
			if (ator.contains(" ")) {
				this.split = ator.split(" ");

				// Verifica se o ator pertence a base de sufixos
				if (dao.pertenceBaseSufixo(this.split[0])) {
					ator = "";

					ator += padronizaClasse(this.split[0]);

					for (int i = 1; i < split.length; i++) {
						ator += semAcento(padronizaClasse(split[i]));
					}

					// Insere o ator
					adicionarChaveValor("diagramaDeClasse", ator, "");
					this.ator = ator;
				}

			} else {
				// Verifica se o ator pertence a base de sufixos
				if (dao.pertenceBaseSufixo(ator)) {
					ator = padronizaClasse(ator);

					// Insere o ator
					adicionarChaveValor("diagramaDeClasse", semAcento(ator), "");
					this.ator = ator;
				}
			}
		}
	}

	public void addClasse(String classe) {
		classe = padronizaClasse(classe);

		// Insere a classe
		adicionarChaveValor("diagramaDeClasse", classe, "");

	}

	public void addAtributo(String classe, String atributo, String tipo) {
		classe = padronizaClasse(classe);

		// Verifica se o atributo passado é uma classe
		this.classe = (classePrimeiraLetraMaiuscula(semAcento(atributo)));

		if (this.diagramaDeClasse.containsKey(this.classe)) {
			atributo = this.classe + "_" + semAcento(minusculo(atributo));
		} else {
			atributo = padronizaAtributo(atributo, tipo);
		}

		// Verifica se o atributo esta esperando a proxima classe
		if (classe.equals("Proxima")) {
			this.atributoAguardeProxima.add(atributo);
		} else {

			// Testa se tem atributos antigos para cadastrar
			if (this.atributoAguardeProxima.size() != 0) {
				for (String string : this.atributoAguardeProxima) {
					adicionarChaveValor("diagramaDeClasse", classe, string);
					criaRelacionamentoAtributoClasse(classe, string);
				}
				this.atributoAguardeProxima
						.removeAll(this.atributoAguardeProxima);
			}

			// Insere o atributo atual
			adicionarChaveValor("diagramaDeClasse", classe, atributo);

			criaRelacionamentoAtributoClasse(classe, atributo);

		}
	}

	public void addMetodo(String classe, String metodo, String parametro) {
		classe = padronizaClasse(classe);
		metodo = padronizaMetodo(metodo);
		parametro = padronizaParametro(parametro);

		// Verifica se o metodo esta esperando a proxima classe
		if (classe.equals("Proxima")) {
			this.metodoAguardeProxima.add(metodo);
		} else {

			// Testa tem métodos antigos para cadastrar
			if (this.metodoAguardeProxima.size() != 0) {
				for (String string : this.metodoAguardeProxima) {
					adicionarChaveValor("diagramaDeClasse", classe, string
							+ parametro);
				}
				this.metodoAguardeProxima.removeAll(this.metodoAguardeProxima);
			}

			// Insere a atual
			if (!this.dao.desconsideraVerbo(metodo))
				adicionarChaveValor("diagramaDeClasse", classe, metodo
						+ parametro);
		}
	}

	public void addRelacionamento(String tipo, String classe1, String classe2) {

		// Verifica se a classe passada é o ator
		if (classe1.equals("ator")) {
			if (!this.ator.equals("")) {
				classe1 = this.ator;
			} else {
				// com isso não será adicionado relacionamento entre ator e a
				// classe2, pois há uma validação no adicionarChaveValor
				tipo = "";

				// faz com que não seja adicionada a classe1
				classe1 = "";
			}
		} else {
			classe1 = padronizaClasse(classe1);
		}

		classe2 = padronizaClasse(classe2);

		// Retorna a verdadeira classe, com base no radical
		classe1 = retornaVerdadeiraClasse(classe1);
		classe2 = retornaVerdadeiraClasse(classe2);

		String relacionamento = classe1 + ":" + classe2;

		// Adicina as classes - se não existir
		if (!this.diagramaDeClasse.containsKey(classe1))
			adicionarChaveValor("diagramaDeClasse", classe1, "");
		if (!this.diagramaDeClasse.containsKey(classe2))
			adicionarChaveValor("diagramaDeClasse", classe2, "");

		// Adiciona o relacionamento
		adicionarChaveValor("relacionamentos", tipo, relacionamento);

	}

	private String padronizaClasse(String classe) {

		classe = classePrimeiraLetraMaiuscula(classe);

		// Redução Plural
		if (classe.endsWith("s"))
			classe = dao.reducaoPlural(classe);

		return classe;
	}

	private String extraiRadicalClasse(String palavra) {

		if (!this.diagramaDeClasse.containsKey(semAcento(palavra))) {
			return this.stemmer.getWordStem(palavra);
		}

		return "";
	}

	private String retornaVerdadeiraClasse(String classe) {

		// Extrai o radical da classe com acento
		this.radical = extraiRadicalClasse(classe);
		if (!this.radical.equals("")) {
			// O radical não pertence ao método?
			if (this.radicalDiagramaDeClasse.containsKey(this.radical)
					&& !this.radicalDiagramaDeClasse.get(this.radical).equals(
							"")) {
				classe = this.radicalDiagramaDeClasse.get(this.radical);
			}
		}

		return semAcento(classe);
	}

	private String padronizaAtributo(String atributo, String tipo) {
		atributo = minusculo(atributo);
		atributo = semAcento(atributo);

		return tipoAtributo(tipo) + "_" + atributo;
	}

	private String padronizaMetodo(String metodo) {
		metodo = minusculo(metodo);
		metodo = semAcento(metodo);
		metodo = this.dao.baseAcoes(metodo);
		this.radicalDiagramaDeClasse.put(this.stemmer.getWordStem(metodo), "");

		return metodo;
	}

	private String padronizaParametro(String parametro) {
		parametro = retornaVerdadeiraClasse(parametro);

		return "(" + parametro + " " + minusculo(parametro) + ")";
	}

	// Insere o relacionamento caso o atributo seja do tipo da
	// classe
	private void criaRelacionamentoAtributoClasse(String classe, String atributo) {
		this.classe = atributo.split("_")[0];

		if (this.diagramaDeClasse.containsKey(this.classe)) {
			adicionarChaveValor("relacionamentos", "1:1", classe + ":"
					+ this.classe);
		}

	}

	private void adicionarChaveValor(String tipo, String chave, String valor) {

		if (!chave.equals("")) {

			this.valores = new LinkedHashSet<String>();

			switch (tipo) {
			case "diagramaDeClasse":

				// Caso o valor já esteja inserido na classe, ele não adiciona o
				// valor e sai do programa
				this.classe = semAcento(chave);
				if (this.diagramaDeClasse.containsKey(this.classe)
						&& this.diagramaDeClasse.get(this.classe).contains(
								valor)) {
					break;
				}

				// Extrai o radical da chave com acento
				this.radical = extraiRadicalClasse(chave);

				// Caso queira adicionar uma classe que pertence a base de
				// radicais, não adiciona
				if (!this.radical.equals("")) {
					if (this.radicalDiagramaDeClasse.containsKey(this.radical)) {
						// O radical pertence ao método?
						if (this.radicalDiagramaDeClasse.get(this.radical)
								.equals("")) {
							break;
						} else {
							chave = this.radicalDiagramaDeClasse
									.get(this.radical);
						}
					} else {
						// Adiciona o radical, caso não tenha adicionado
						chave = semAcento(chave);
						this.radicalDiagramaDeClasse.put(this.radical, chave);
					}
				}

				// Pega os valores antigos para a classe
				if (this.diagramaDeClasse.containsKey(chave)) {
					this.valores.addAll(this.diagramaDeClasse.get(chave));
				}

				// Adiciona o atual
				if (!valor.equals(""))
					this.valores.add(valor);

				// Insere a classe e os valores
				this.diagramaDeClasse.put(chave, this.valores);

				break;

			case "relacionamentos":
				if (this.relacionamento.containsKey(chave)) {
					this.valores.addAll(this.relacionamento.get(chave));
				}

				// Não realizar mais de um relacionamento para a mesma
				// chave:valor
				// Testa se a chave:valor ja esta no relacionameto 1:1. Caso
				// esteja remove-o
				if (chave.equals("1:n")) {
					if (this.relacionamento.containsKey("1:1")
							&& this.relacionamento.get("1:1").contains(valor)) {

						this.relacionamento.get("1:1").remove(valor);

						// Testa se para a chave ficou sem valor. Se sim,
						// remove-a
						if (this.relacionamento.get("1:1").size() == 0) {
							this.relacionamento.remove("1:1");
						}
					}
				} else if (this.relacionamento.containsKey("1:n")
						&& this.relacionamento.get("1:n").contains(valor)) {
					break;
				}

				this.valores.add(valor);

				this.relacionamento.put(chave, this.valores);

				break;
			}

		}

	}

	private String classePrimeiraLetraMaiuscula(String classe) {
		classe = minusculo(classe);
		return classe.substring(0, 1).toUpperCase() + classe.substring(1);
	}

	private String semAcento(String nome) {
		return Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll(
				"[^\\p{ASCII}]", "");
	}

	private String minusculo(String nome) {
		return nome.toLowerCase();
	}

	private String tipoAtributo(String tipo) {

		String nome = String.valueOf(tipo);

		if (nome.matches("[0-9]+"))
			return "Integer";
		if (nome.matches("true|false"))
			return "Boolean";
		if (nome.matches("[0-9]+[.][0-9]+"))
			return "Double";
		if (nome.matches("[a-zA-Z]+"))
			return "String";

		return "String";
	}

	public Map<String, LinkedHashSet<String>> getDiagramaDeClasse() {
		return diagramaDeClasse;
	}

	public Map<String, LinkedHashSet<String>> getRelacionamento() {
		return relacionamento;
	}

	public String getAtor() {
		return ator;
	}

	public Map<String, String> getRadicalDiagramaDeClasse() {
		return radicalDiagramaDeClasse;
	}

}