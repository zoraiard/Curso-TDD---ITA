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
	 *  1º Teste
	 * Uma palavra com primeira letra minúscula
	 * 
	 * Para iniciar o projeto de Conversão CamelCase é criado o mapeamento da classe a 
	 * partir de um  primeiro teste simples com o objetivo de montar uma estrutura dos métodos iniciais.
	 * Teste com uma palavra que tem todas as letras minúsculas, “nome”.
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
	 * 2º Teste
	 * Uma palavra com primeira letra maiúscula
	 * 
	 * O segundo teste com a mesma palavra anterior, porém com letra inicial maiúscula. 
	 * Resulta em um erro, devido ser esperado que a letras inicial fiquem na forma 
	 * minúscula. Conforme regra, dessa forma o código foi refatorado para que a palavra 
	 * se tornem minúscula.
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
	 * 3º Teste
	 * 
	 * Separar palavras compostas (todas minúsculas)
	 *   
	 * Gerado novo erro devido o código não separar palavras compostas, apenas torna minúsculas.	 *  
	 * A palavra composta deve ser quebrada e em seguida transformada em minúsculas. 
	 */
	
	@Test
	public void testConverterDuasPalavrasCompostas() {
			
		List<String> resultadoEsperado = Arrays.asList("nome", "composto");
		String camelCase = "nomeComposto";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}

	/**
	 * 4º Teste
	 * Separar palavras compostas (primeira Maiúsculas)
	 * 
	 * Separar palavras compostas, sendo que a primeira palavra nesse teste é maiúscula.	
	 * A rotina gerou erro causando uma terceira string vazia na lista.	 *   
	 * A soluçãocriada foi um tratamento para remover strings vazias quando for quando 
	 * adicionada a lista. Nesse tratamento foi criado um método de verificação
	 * 
	 * */
	
	@Test
	public void testConverterDuasPalavrasCompostasEmMaiusculas() {
			
		List<String> resultadoEsperado = Arrays.asList("nome", "composto");
		String camelCase = "NomeComposto";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}
	
	
	/**
	 * 5º Teste
	 * 
	 * SIGLAS
	 * 	
	 * Gerou erro separando a sigla CPF no teste abaixo,
	 * criando uma lista de Strings com apenas letras minúscula. 
	 *    
	 */
	
	@Test
	public void testConverterSiglaMaiuscula() {
			
		List<String> resultadoEsperado = Arrays.asList("CPF");
		String camelCase = "CPF";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}
	
	

	/**
	 * 6º Teste
	 * 
	 * Separar lista de palavras com SIGLA 
	 *
	 * Sigla e palavras. Não gerou erro algum, portanto, não houve refatoramento. 
	 * 
	 */
	@Test
	public void testConverterSiglaCompostaComPalavra() {
			
		List<String> resultadoEsperado = Arrays.asList("numero", "CPF");
		String camelCase = "numeroCPF";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}
	
	
	/**
	 *  7º Teste
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
	 * 8º Teste
	 * 
	 * Numeração entre palavras 
	 *
	 * Não gerou erro devido ter sido feito esse tratamento no início da criação do método.
	 *    
	 */
	@Test
	public void testConverterComNumeracao() {
			
		List<String> resultadoEsperado = Arrays.asList("recupera", "10", "primeiros");
		String camelCase = "recupera10Primeiros";
		
		assertEquals(resultadoEsperado, Conversor.converterCamelCase(camelCase));
		
	}

	/**
	 * 9º Teste
	 * 
	 * Criar tratamento com exceção para evitar número no inicio da String
	 * 
	 * 10Primeiros - Inválido - Não deve começar com números
	 */
	@Test(expected=ComecaComNumerosException.class)

	public void comecaComNumerosException() {
		
	    String camelCase = "10Primeiros";

	    Conversor.converterCamelCase(camelCase);
		
	}
	
	
	/**
	 * 10º Teste
	 * 
	 * Criar tratamento com exceção para evitar caracteres inválidos na Strings
	 * 
	 *  Inválido - Caracteres especiais não são permitidos, somente letras e números
	 */
	@Test(expected=CaracteresEspeciaisNaoPermitido.class)
	
	public void caracteresEspeciaisNaoPermitido() {
		
		String camelCase = "nome#Composto";

	    Conversor.converterCamelCase(camelCase);
		
	}
	
}

