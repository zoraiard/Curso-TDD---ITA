import java.util.HashMap;
import java.util.Map;

public class Tradutor {
	
	private Map<String, String> traducoes = new HashMap<>();
	
	public boolean estaVazia() {
	   return traducoes.isEmpty();
	}

	public void adicionaTraducao(String palavra, String traducao) {
		if (traducoes.containsKey(palavra)){	
			traducao = traduzir(palavra)+", "+traducao;
		}
		this.traducoes.put(palavra, traducao);
	}

	public String traduzir(String palavra) {
		
		return traducoes.get(palavra);
	}

	public String traduzirFrase(String frase) {
		String[] palavras = frase.split(" ");
		String  fraseTradizida="";
		for(String palavra: palavras){
			String traducao = primeiraTraducao(palavra);
			fraseTradizida += " "+traducao;
		}
		
		return fraseTradizida.trim();
	}

	private String primeiraTraducao(String palavra) {
		String traducao = traduzir(palavra);
		if (traducao.contains(","))
			traducao = traducao.substring(0, traducao.indexOf(","));
		return traducao;
	}

}
