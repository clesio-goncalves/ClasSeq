package ifpi.ads.tcc.etiquetador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.annolab.tt4j.TokenHandler;
import org.annolab.tt4j.TreeTaggerException;
import org.annolab.tt4j.TreeTaggerWrapper;

public class Etiquetador {

	private final List<String> etiquetas = new ArrayList<>();
	private List<String> palavras = new ArrayList<>();
	private TreeTaggerWrapper<String> tt;
	public static HashMap<String, String> lemma = new HashMap<>();

	public Etiquetador(List<String> palavras) {
		this.palavras = palavras;
	}

	public void etiquetar() {

		String op = System.getProperty("os.name");
		if (op.equalsIgnoreCase("Linux")) {
			System.setProperty("treetagger.home", "tree-tagger-pt/");
		} else if (op.contains("Windows")) {
			System.setProperty("treetagger.home", "windows/TreeTagger/");
		} else {
			System.setProperty("treetagger.home", "mac/");
		}

		tt = new TreeTaggerWrapper<>();
		try {
			tt.setModel("tree-tagger-pt/cmd/lib/pt.par");
			tt.setHandler(new TokenHandler<String>() {

				@Override
				public void token(String token, String pos, String lemma) {
					etiquetas.add(pos);
					Etiquetador.lemma.put(token, lemma);
				}
			});
			tt.process(palavras);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Modelo não encontrado");
		} catch (TreeTaggerException t) {
			System.out.println(t.getMessage());
			System.out.println("Erro na etiquetagem");
		} finally {
			tt.destroy();
		}
	}

	public List<String> getEtiquetas() {
		return etiquetas;
	}

	public static String getLemma(String palavra) {
		return lemma.get(palavra);
	}

	public List<String> getPalavras() {
		return palavras;
	}
}