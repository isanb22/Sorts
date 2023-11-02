package sorts;

public class BubbleSort{
	long trocas = 0;
	long iteracao = 0;
	long tempo = 0;

	public BubbleSort() {
		
	}	
	public void sort(int lista[]) {
		int temp;
		long tempoInicio = System.nanoTime();
		for(int i = 0; i < mainSorts.tamanho(lista) - 1; i++) {
			iteracao++;
			for(int j = 0; j < mainSorts.tamanho(lista) - 1; j++) {
				iteracao++;
				if(lista[j] > lista[j + 1]) {
					temp = lista[j];
					lista[j] = lista[j+1];
					lista[j+1] = temp;
					trocas++;
				}	
			}
		}
		//mainSorts.printar(lista);
		long tempoFinal = System.nanoTime();
		tempo = (tempoFinal - tempoInicio);
	}
	public long getTrocas() {
		return trocas;
	}
	public long getIteracao() {
		return iteracao;
	}
	public long getTempo() {
		return tempo;
	}
}