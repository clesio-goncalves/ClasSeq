package ifpi.ads.tcc.extrator;

import ifpi.ads.tcc.etiquetador.Etiquetador;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<String>(); 
		lista.add("preenchimento");
		
		Etiquetador etiquetador = new Etiquetador(lista);
		etiquetador.etiquetar();
		
		System.out.println(Etiquetador.getLemma("preenchimento"));
	}

}
