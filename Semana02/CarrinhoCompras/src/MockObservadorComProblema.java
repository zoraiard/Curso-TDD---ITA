
public class MockObservadorComProblema implements ObservadorCarrinho {

	@Override
	public void prudutoAdicionado(String nome, int valor) {
		throw new RuntimeException("Problema simulado pelo mock");

	}

}
