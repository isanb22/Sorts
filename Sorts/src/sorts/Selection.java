package sorts;

public class Selection {
	long trocas = 0;
	long iteracao = 0;
	long tempo = 0;
	
	public Selection(){
		
	}
	public void sort(int lista[]) {
		int menor;
		int temp;
		long tempoInicio = System.nanoTime();
		for(int i = 0; i < mainSorts.tamanho(lista) - 1; i++) {
			iteracao++;
			menor = i;
			for(int j = i + 1; j < mainSorts.tamanho(lista); j++) {
				iteracao++;
				if (lista[j] < lista[menor]){
					menor = j;
				}
			}
			temp = lista[menor];
			lista[menor] = lista[i];
			lista[i] = temp;
			trocas++;
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
