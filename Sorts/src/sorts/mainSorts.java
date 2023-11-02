package sorts;
import java.util.Random;


public class mainSorts {
    public static void main(String[] args) 
    {
        int size[] = {50, 500, 1000, 5000, 10000};
        int lista[] = null;
        
        BubbleSort bubble = new BubbleSort();
        Selection Select = new Selection();
        mergeSort merge = new mergeSort();
        quickSort quick = new quickSort();
        
        long tempoBubble = 0;
        long trocasBubble = 0;
        long iteracaoBubble = 0;
        
        long tempoSelect = 0;
        long trocasSelect = 0;
        long iteracaoSelect = 0;
        
        long tempoMerge = 0;
        long trocasMerge = 0;
        long iteracaoMerge = 0;
        
        long tempoQuick = 0;
        long trocasQuick = 0;
        long iteracaoQuick = 0;
        
        for(int i = 0; i < tamanho(size); i++) {
            for (int j = 0; j <= 5; j++) {
                lista = criarLista(size[i]);
                //printar(lista);
                
                //Bubble Sort
                bubble.sort(lista);
                tempoBubble += bubble.getTempo();
                trocasBubble += bubble.getTrocas();
                iteracaoBubble += bubble.getIteracao();
                
                //Selection Sort
                Select.sort(lista);
                tempoSelect += Select.getTempo();
                trocasSelect += Select.getTrocas();
                iteracaoSelect += Select.getIteracao();
                
                //Merge Sort
                merge.sort(lista);
                tempoMerge += merge.getTempo();
                trocasMerge += merge.getTempo();
                iteracaoMerge += merge.getInteracoes();
                
                //Quick Sort
                quick.sort(lista);
                tempoQuick += quick.getTempo();
                trocasQuick += quick.getTrocas();
                iteracaoQuick += quick.getInteracoes();
                
            }
            System.out.println("#================================#");
            System.out.println("Lista com " + size[i] + " elementos");
            relatorio("Bubble", tempoBubble, trocasBubble, iteracaoBubble);
            relatorio("Selection", tempoSelect, trocasSelect, iteracaoSelect);
            relatorio("Merge", tempoMerge, trocasMerge, iteracaoMerge);
            relatorio("Quick", tempoQuick, trocasQuick, iteracaoQuick);
            
            tempoBubble = 0;
            trocasBubble = 0;
            iteracaoBubble = 0;
            
            tempoSelect = 0;
            trocasSelect = 0;
            iteracaoSelect = 0;
            
            tempoMerge = 0;
            trocasMerge = 0;
            iteracaoMerge = 0;
            
            tempoQuick = 0;
            trocasQuick = 0;
            iteracaoQuick = 0;
         }    
        
    }
        
    public static int[] criarLista(int tam) {
        int lista[] = new int[tam];

        Random random = new Random();
        
        for(int i = 0; i < tam; i++) {
            lista[i] = random.nextInt(100);
        }
        return lista;
    }
    
    public static int tamanho(int lista[]) {
        int tam = 0;
        for(@SuppressWarnings("unused") int i: lista) {
            tam++;
        }
        return tam;
    }
    
    public static void printar(int lista[]) {
        System.out.print("[");
        for (int i = 0; i < tamanho(lista); i++) {
            System.out.print( lista[i] + " ");
        }
        System.out.println("]");
    }
    
    public static void relatorio(String sort, long tempo, long trocas, long iteracao) {
        
        System.out.println("---------------------------");
        System.out.println(" => Média com " + sort + " Sort: ");
        System.out.println("Tempo: " + (tempo / 5) + " nanossegundos");
        System.out.println("Trocas: " + (trocas / 5));
        System.out.println("Iterações: " + (iteracao/5));
        System.out.println();
    }
}