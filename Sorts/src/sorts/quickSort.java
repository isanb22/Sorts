package sorts;

@SuppressWarnings("unused") // Para um for(int i...) que não usou o "i".

public class quickSort {
    
    long tempo;
    long trocas = 0;
    long interacoes = 0;
        
    public quickSort() {
        
    }
    
    public void sort(int[] lista) 
    {
        long tempoInicial = System.nanoTime();
        
        int listaQuick[] = quick(lista, 0, tamanho(lista) - 1);
        
        long tempoFinal = System.nanoTime();
        tempo = tempoFinal - tempoInicial;
        
    }

    public int[] quick(int[] array, int inicio, int fim) {
        interacoes++;
        if (inicio < fim) 
        {
            int pivo = particionar(array, inicio, fim);
            
            quick(array, inicio, pivo - 1);
            quick(array, pivo + 1, fim);
        }
        return array;
    }

    public int particionar(int[] lista, int inicio, int fim) {
        int pivo = lista[fim];
        int i = (inicio - 1);
        int temp;
        
        for (int j = inicio; j < fim; j++) 
        {
            if (lista[j] <= pivo) 
            {
                trocas++;
                i++;
                temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        } 
        trocas++;
        
        i++;
        temp = lista[i];
        lista[i] = lista[fim];
        lista[fim] = temp;
        return i;
    }

    public int tamanho(int lista[])
    {
        int tamanho = 0;
        
        for ( int i : lista) {
            tamanho++;
        }
        return tamanho;
    }
    
    public long getTrocas() {
        return trocas;
    }
    public long getInteracoes() {
        return interacoes;
    }
    public long getTempo() {
        return tempo;
    }
}
