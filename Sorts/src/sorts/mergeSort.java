package sorts;

@SuppressWarnings("unused") // Para um for(int i...) que não usou o "i".

public class mergeSort {
    
    long tempo;
    long trocas = 0;
    long interacoes = 0;
    
    public mergeSort() {
        
    }
    
    public void sort(int lista[]) 
    {
        long tempoInicial = System.nanoTime();
        
        int listaMerge[] = merge(lista);
        
        long tempoFinal = System.nanoTime();
        tempo = tempoFinal - tempoInicial;
        
    }
    
    public int[] merge(int lista[])
    {
        interacoes++;
        int tam = tamanho(lista);
        
        if (tamanho(lista) == 1) {return lista;}
        
        int temp[] = new int[tam];
        
        /* ------------- Bora dividir em dois: ------------- */
        int meio = tam / 2;

        // Parte 1
        int[] lista1 = new int[meio];
        
        for (int i = 0; i < meio; i++) { 
            lista1[i] = lista[i]; }
        
        int parte1[] = merge(lista1);
        
        // Parte 2
        int[] lista2 = new int[tam - meio];
        
        for (int i = meio; i < tam; i++) {
            lista2[i - meio] = lista[i]; }
        
        int parte2[] = merge(lista2);
        
        /* ------------- Junção: ------------- */
        int tam1 = tamanho(parte1);
        int tam2 = tamanho(parte2);
        int i1 = 0;
        int i2 = 0;
        int iTemp = 0;
        
        while (true)
        {
            // Casos em que uma das listas estiver vazia:
            if (i1 == tam1 && i2 < tam2) {
                temp[iTemp] = parte2[i2];
                iTemp++; 
                i2++;
                trocas++;
            }
            else if (i1 < tam1 && i2 == tam2) {
                temp[iTemp] = parte1[i1];
                iTemp++; 
                i1++;    
                trocas++;            
            }
            
            // Compara qual é a menor:
            else 
            {
                if(parte1[i1] <= parte2[i2]) {
                    temp[iTemp] = parte1[i1];
                    iTemp++; 
                    i1++;
                    trocas++;
                }
                else {
                    temp[iTemp] = parte2[i2];
                    iTemp++; 
                    i2++;
                    trocas++;
                }
            }
            
            // Condição break:
            if (i1 == tam1 && i2 == tam2) {
                break;
            }
        }
        
        return temp;
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