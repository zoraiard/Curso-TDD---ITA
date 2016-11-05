
import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCarrinhoCompras {

	@Test
	public void testeCarrinhoCompras() {
		CarrinhosCompras cc = new CarrinhosCompras();
		cc.adicionaProduto(new Produto("farinha", 6));
		cc.adicionaProduto(new Produto("biscoito", 2));
		cc.adicionaProduto(new Produto("margarina", 4));

		assertEquals(12, cc.total());

	}

	@Test
	public void escutaAdicaoDeProduto() {
		CarrinhosCompras c = new CarrinhosCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionarObservador(mock);
		c.adicionaProduto(new Produto("farinha", 6));
		mock.verificaRecebimentoProduto("farinha", 6);
	}
	
	@Test
	public void adicionarDoisObservadores() {
		CarrinhosCompras c = new CarrinhosCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionaProduto(new Produto("farinha", 6));
		mock1.verificaRecebimentoProduto("farinha", 6);
		mock2.verificaRecebimentoProduto("farinha", 6);
	}
	
	@Test
	public void continuaNotificandoComErroEmObservador() {
		CarrinhosCompras c = new CarrinhosCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		ObservadorCarrinho mock2 = new MockObservadorComProblema();
		MockObservadorCarrinho mock3 = new MockObservadorCarrinho();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionarObservador(mock3);
		c.adicionaProduto(new Produto("farinha", 6));
		mock1.verificaRecebimentoProduto("farinha", 6);
		mock3.verificaRecebimentoProduto("farinha", 6);
	}
}
