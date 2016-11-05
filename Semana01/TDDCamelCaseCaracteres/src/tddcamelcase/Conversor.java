package tddcamelcase;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conversor {
	
    private static List<String> listaPalavras;
	
	public static List<String> converterCamelCase(String original){
		
	   Conversor converter = new Conversor();
	   if (converter.comecaComNumero(original))
		   throw new ComecaComNumerosException("A palavra possui número no seu início");
		   
	   if (converter.caracteresEspeciaisNaoPermitidos(original)) 
		    throw new CaracteresEspeciaisNaoPermitido("A palavra possu caracteres inválidos");
		   
	      
	   listaPalavras = Conversor.desfazerUmCamelCase(original);
	   
	   
	   return listaPalavras;   

	}
	
			
	public static List<String> desfazerUmCamelCase(String original){
		
		Pattern padrao = null;
		
		List<String> listaTratada;
		
		listaTratada = Arrays.asList(extrairPadrao(padrao).split(original));
		
		listaTratada = tornaListaMinuscula(listaTratada);
		
		return listaTratada;
	
	}

	
	private static List<String> tornaListaMinuscula(List<String> listaPalavras) {
		List<String> novaListaPalavras = new ArrayList<String>();
		String guardaSigla = "";
		for (int i =0; i < listaPalavras.size();i++){
			
			if (!listaPalavras.get(i).isEmpty()) { 
				
				if (possuiApenasUmaLetra(listaPalavras.get(i)))
					guardaSigla += listaPalavras.get(i);
					
				
				if (!guardaSigla.isEmpty()){
					if (!possuiApenasUmaLetra(listaPalavras.get(i))||(listaPalavras.size() - 1==i)){
						novaListaPalavras.add(guardaSigla);
						guardaSigla = "";
					}	
				}
				
				if (!possuiApenasUmaLetra(listaPalavras.get(i)))
					novaListaPalavras.add(listaPalavras.get(i).toLowerCase());
			}
	    }		
		
		return novaListaPalavras;
	}


	private static Pattern extrairPadrao(Pattern padrao) {
		padrao = Pattern.compile("(?=[A-Z])|(?<=\\D)(?=\\d)");
		return padrao;
	}
	

	private static boolean possuiApenasUmaLetra(String palavra) {
		return (palavra.length() == 1);
	}
	
	
	private boolean comecaComNumero(String original){
		return Character.isDigit(original.charAt(0));
				
	}

	
	private boolean caracteresEspeciaisNaoPermitidos(String original) {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(original);
		return m.find();
	}

	

}
