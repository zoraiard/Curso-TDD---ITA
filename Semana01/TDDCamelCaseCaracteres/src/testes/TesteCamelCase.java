package testes;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tddcamelcase.CaracteresEspeciaisNaoPermitido;
import tddcamelcase.ComecaComNumerosException;
import tddcamelcase.Conversor;

public class TesteCamelCase {
	
	/**
	 *  1� Teste
	 * Uma palavra com primeira letra min�scula
	 * 
	 * Para iniciar o projeto de Convers�o CamelCase � criado o mapeamento da classe a 
	 * partir de um  primeiro teste simples com o objetivo de montar uma estrutura dos m�todos iniciais.
	 * Teste com uma palavra que tem todas as letras min�sculas, �nome�.
	 * 
	 * 
	 **/
	
	@Test
	public void testConverterUmaPalavraComPrimeiraLetraMinuscula() {
		
		List<String> resultadoEsperado = Arrays.asList("nome");
		String camelCase = "nome";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}
	
	
	/**
	 * 2� Teste
	 * Uma palavra com primeira letra mai�scula
	 * 
	 * O segundo teste com a mesma palavra anterior, por�m com letra inicial mai�scula. 
	 * Resulta em um erro, devido ser esperado que a letras inicial fiquem na forma 
	 * min�scula. Conforme regra, dessa forma o c�digo foi refatorado para que a palavra 
	 * se tornem min�scula.
	 *   
	 *   
	 */
	 
	@Test
	 public void testConverterUmaPalavraComPrimeiraLetraMaiuscula() {
			
		List<String> resultadoEsperado = Arrays.asList("nome");
		String camelCase = "Nome";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}


	/**
	 * 3� Teste
	 * 
	 * Separar palavras compostas (todas min�sculas)
	 *   
	 * Gerado novo erro devido o c�digo n�o separar palavras compostas, apenas torna min�sculas.	 *  
	 * A palavra composta deve ser quebrada e em seguida transformada em min�sculas. 
	 */
	
	@Test
	public void testConverterDuasPalavrasCompostas() {
			
		List<String> resultadoEsperado = Arrays.asList("nome", "composto");
		String camelCase = "nomeComposto";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}

	/**
	 * 4� Teste
	 * Separar palavras compostas (primeira Mai�sculas)
	 * 
	 * Separar palavras compostas, sendo que a primeira palavra nesse teste � mai�scula.	
	 * A rotina gerou erro causando uma terceira string vazia na lista.	 *   
	 * A solu��ocriada foi um tratamento para remover strings vazias quando for quando 
	 * adicionada a lista. Nesse tratamento foi criado um m�todo de verifica��o
	 * 
	 * */
	
	@Test
	public void testConverterDuasPalavrasCompostasEmMaiusculas() {
			
		List<String> resultadoEsperado = Arrays.asList("nome", "composto");
		String camelCase = "NomeComposto";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}
	
	
	/**
	 * 5� Teste
	 * 
	 * SIGLAS
	 * 	
	 * Gerou erro separando a sigla CPF no teste abaixo,
	 * criando uma lista de Strings com apenas letras min�scula. 
	 *    
	 */
	
	@Test
	public void testConverterSiglaMaiuscula() {
			
		List<String> resultadoEsperado = Arrays.asList("CPF");
		String camelCase = "CPF";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}
	
	

	/**
	 * 6� Teste
	 * 
	 * Separar lista de palavras com SIGLA 
	 *
	 * Sigla e palavras. N�o gerou erro algum, portanto, n�o houve refatoramento. 
	 * 
	 */
	@Test
	public void testConverterSiglaCompostaComPalavra() {
			
		List<String> resultadoEsperado = Arrays.asList("numero", "CPF");
		String camelCase = "numeroCPF";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}
	
	
	/**
	 *  7� Teste
	 * 
	 * Sigla e com palavras compostas
	 *
	 * Separou, entretanto invertou as ordem, gerando erro no resultado esperado.
	 * Refatorado a classe principal Converte.
	 *    
	 */
	@Test
	public void testConverterSiglaCompostaComDuasPalavras() {
			
		List<String> resultadoEsperado = Arrays.asList("numero", "CPF", "contribuinte");
		String camelCase = "numeroCPFContribuinte";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}
	
	
	/**
	 * 8� Teste
	 * 
	 * Numera��o entre palavras 
	 *
	 * N�o gerou erro devido ter sido feito esse tratamento no in�cio da cria��o do m�todo.
	 *    
	 */
	@Test
	public void testConverterComNumeracao() {
			
		List<String> resultadoEsperado = Arrays.asList("recupera", "10", "primeiros");
		String camelCase = "recupera10Primeiros";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}

	/**
	 * 9� Teste
	 * 
	 * Criar tratamento com exce��o para evitar n�mero no inicio da String
	 * 
	 * 10Primeiros - Inv�lido - N�o deve come�ar com n�meros
	 */
	@Test(expected=ComecaComNumerosException.class)

	public void comecaComNumerosException() {
		
	    String camelCase = "10Primeiros";

	    Conversor.converterCamelCase(camelCase);
		
	}
	
	
	/**
	 * 10� Teste
	 * 
	 * Criar tratamento com exce��o para evitar caracteres inv�lidos na Strings
	 * 
	 *  Inv�lido - Caracteres especiais n�o s�o permitidos, somente letras e n�meros
	 */
	@Test(expected=CaracteresEspeciaisNaoPermitido.class)
	
	public void caracteresEspeciaisNaoPermitido() {
		
		String camelCase = "nome#Composto";

	    Conversor.converterCamelCase(camelCase);
		
	}
	
}

