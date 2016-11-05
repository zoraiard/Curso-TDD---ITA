import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteTradutor {
	
	private Tradutor tradutor;

	@Before
	public void CriarTradutor(){
		tradutor = new Tradutor();	
	} 	
	
	@Test
	public void tradutorSemPalavrar() {
		
		assertTrue(tradutor.estaVazia());
	}

	@Test
	public void umaTraducao(){
		tradutor.adicionaTraducao("bom","good");
		assertFalse(tradutor.estaVazia());
		assertEquals("good", tradutor.traduzir("bom"));
		
	}	
	
	@Test
	public void duasTraducoes(){
		tradutor.adicionaTraducao("bom","good");
		tradutor.adicionaTraducao("mau","bad");
		assertEquals("good", tradutor.traduzir("bom"));
		assertEquals("bad", tradutor.traduzir("mau"));
	}
	
	@Test
	public void duasTraducoesMesmaPalavra(){
		tradutor.adicionaTraducao("bom","good");
		tradutor.adicionaTraducao("bom","nice");
		assertEquals("good, nice", tradutor.traduzir("bom"));
	
	}
	
	@Test 
	public void traduzirFrase(){
		tradutor.adicionaTraducao("guerra","war");
		tradutor.adicionaTraducao("é","is");
		tradutor.adicionaTraducao("ruim","bad");
		assertEquals("war is bad", tradutor.traduzirFrase("guerra é ruim"));
	
	}
	
	@Test
	public void traduzirFraseComDuasRraducoesDeMesmaPalavras(){
		tradutor.adicionaTraducao("paz","peace");
		tradutor.adicionaTraducao("é","is");
		tradutor.adicionaTraducao("bom","good");
		tradutor.adicionaTraducao("bom","nice");
		assertEquals("peace is good", tradutor.traduzirFrase("paz é bom"));
	
	}
}	

