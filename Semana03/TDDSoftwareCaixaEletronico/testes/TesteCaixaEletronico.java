package testes;

import org.junit.Test;

import src.CaixaEletronico;

public class TesteCaixaEletronico {
	
	@Test
	public void TesteCaixaEletronicoLogar(){
		
		CaixaEletronico caixaeletronico = new CaixaEletronico();
		
		Mocklogin mockLogin = new Mocklogin();
		
		caixaeletronico.adicionarLogin(mockLogin);
		
		//c.adicionaProduto(new Produto("farinha", 6));
		//mockLogin.verificaRecebimentoProduto("farinha", 6);
		
		
	}
	
}
