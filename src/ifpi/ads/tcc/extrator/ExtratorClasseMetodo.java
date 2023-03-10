package ifpi.ads.tcc.extrator;

import ifpi.ads.tcc.etiquetador.Etiquetador;
import ifpi.ads.tcc.padroes.ClasseMetodoLexer;
import ifpi.ads.tcc.padroes.ClasseMetodoParser;
import ifpi.ads.tcc.padroes.DiagramaDeClasse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

public class ExtratorClasseMetodo {

	private List<String> palavras;
	private List<String> etiquetas;
	private String estoria;
	private DiagramaDeClasse diagramaDeClasse;

	public ExtratorClasseMetodo(String estoria,
			DiagramaDeClasse diagramaDeClasse) {
		this.estoria = estoria;
		this.diagramaDeClasse = diagramaDeClasse;
	}

	public void extrairClasseMetodo() {
		System.out.println("---ClasseMetodo---");
		System.out.println(estoria);
		CommonTokenStream tokens = getTokens(estoria);

		// Tokens
		System.out.println(tokens);

		palavras = new ArrayList<String>();
		palavras = getPalavras(tokens);

		etiquetas = new ArrayList<String>();
		etiquetas = getEtiquetas(palavras);

		System.out.println(etiquetas);

		addToken(tokens, etiquetas);

		// Analisa ClasseMetodo
		analisarClasseMetodo(tokens);
	}

	public void analisarClasseMetodo(CommonTokenStream tokens) {
		ClasseMetodoParser ClasseMetodo = new ClasseMetodoParser(tokens,
				diagramaDeClasse);
		try {
			ClasseMetodo.estoria();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}

	public CommonTokenStream getTokens(String texto) {
		ClasseMetodoLexer lexer = new ClasseMetodoLexer(new ANTLRStringStream(
				texto));
		return new CommonTokenStream(lexer);
	}

	public void addToken(CommonTokenStream token, List<String> etiquetas) {
		int i = 0;
		Object object;
		Iterator<? extends Token> it = token.getTokens().iterator();

		while (it.hasNext()) {
			object = it.next();

			// fiz uma alteração aqui
			if (etiquetas.size() == i) {
				break;
			}

			switch (etiquetas.get(i).charAt(0)) {
			// ADJETIVO
			case 'A':
				((CommonToken) object).setType(ClasseMetodoLexer.ADJETIVO);
				break;

			// ADVÉRBIO
			case 'R':
				((CommonToken) object).setType(ClasseMetodoLexer.ADVERBIO);
				break;

			// ARTIGO
			case 'D':
				((CommonToken) object).setType(ClasseMetodoLexer.ARTIGO);
				break;

			// SUBSTANTIVO
			case 'N':
				((CommonToken) object).setType(ClasseMetodoLexer.SUBSTANTIVO);
				break;

			// VERBO
			case 'V':
				if (etiquetas.get(i).charAt(etiquetas.get(i).length() - 1) == 'N') {
					((CommonToken) object)
							.setType(ClasseMetodoLexer.VERBO_INFINITIVO);
				} else {
					((CommonToken) object).setType(ClasseMetodoLexer.VERBO);
				}
				break;

			// PRONOME
			case 'P':
				((CommonToken) object).setType(ClasseMetodoLexer.PRONOME);
				break;

			// CONJUNCAO
			case 'C':
				if (etiquetas.get(i).charAt(1) == 'C') {
					((CommonToken) object)
							.setType(ClasseMetodoLexer.CONJUNCAO_COORDENADA);
				} else {
					((CommonToken) object)
							.setType(ClasseMetodoLexer.CONJUNCAO_SUBORDINADA);
				}
				break;

			// INTERJEIÇÃO
			case 'I':
				((CommonToken) object).setType(ClasseMetodoLexer.INTERJEICAO);
				break;

			// PREPOSIÇÃO
			case 'S':
				((CommonToken) object).setType(ClasseMetodoLexer.PREPOSICAO);
				break;

			// NUMERAL
			case 'Z':
				((CommonToken) object).setType(ClasseMetodoLexer.NUMERAL);
				break;
			}

			i++;
		}
	}

	private static List<String> getEtiquetas(List<String> palavras) {
		Etiquetador etiquetador = new Etiquetador(palavras);
		etiquetador.etiquetar();
		return etiquetador.getEtiquetas();
	}

	public List<String> getPalavras(CommonTokenStream tokens) {
		Object object;
		Iterator<? extends Token> it = tokens.getTokens().iterator();

		while (it.hasNext()) {
			object = it.next();
			palavras.add(((CommonToken) object).getText());
		}
		return palavras;
	}

}
