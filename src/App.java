import java.io.File; // Import the File class
import java.util.LinkedList;
import java.util.Scanner; // Import the Scanner class to read text files

public class App {
    public static void main(String[] args) throws Exception {

        // FUNCIONALIDADES BÁSICAS DO GRAFO:
        File entrada = new File("entrada2.txt"); // arquivo padrão pedido no enunciado do EP;
        Scanner arquivo = new Scanner(entrada);

        String dimensoes = arquivo.nextLine(); // lê a primeira linha da entrada que possui a quantidade de vértices e
                                               // arestas;
        String[] dimensoesSplit = dimensoes.split(" ", 0); // separa a primeira linha, salvando numa array;
        int vertices = Integer.parseInt(dimensoesSplit[0]);
        int arestas = Integer.parseInt(dimensoesSplit[1]);
        System.out.println(vertices);
        System.out.println(arestas);
        graph grafo = new graph(vertices); // cria o grafo com a quantidade lida de vértices;

        // Cria as arestas definidas no arquivo de entrada padrão pedido no enunciado.
        for (int i = 0; i < arestas; i++) {
            String novoVertice = arquivo.nextLine();
            String[] verticeSplit = novoVertice.split(" ", 0);
            int inicio = Integer.parseInt(verticeSplit[0]);
            int fim = Integer.parseInt(verticeSplit[1]);
            grafo.addEdge(inicio, fim);
        }

        // System.out.println("MATRIZ DE ADJACÊNCIA:");
        // grafo.getAdj(); // matriz de adjacência;
        System.out.println("----------------------------------------------------------------------------");

        // distância entre todos os vértices do grafo
        System.out.println("DISTÂNCIA ENTRE OS VÉRTICES");
        for (int j = 0; j < vertices; j++) {
            for (int i = 0; i < grafo.getDistance(j).length; i++) {
                System.out.print(grafo.getDistance(j)[i] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("DISTÂNCIA MÉDIA ENTRE OS VÉRTICES");
        System.out.println(grafo.avgDistance());
        // -----------------------------------------------------------------------------------------------------------------------
        // FUNCIONALIDADES DO WORDS LADDER
        String[] palavras = new String[211];
        File entradaPalavras = new File("palavras.txt");
        Scanner arquivoPalavras = new Scanner(entradaPalavras);

        int verticesPalavras = palavras.length; // array de vértices no caso do Words Ladder;
        graph grafoPalavras = new graph(verticesPalavras); // cria o grafo com a quantidade lida de vértices;
        // // Lê as palavras do arquivo do Words Ladder
        int i = 0;
        while (arquivoPalavras.hasNextLine()) {
            String palavra = arquivoPalavras.nextLine();
            palavras[i] = palavra;
            i++;
        }
        grafoPalavras.comparaPalavras(palavras);

        //System.out.println("MATRIZ DE ADJACÊNCIA DAS PALAVRAS:");
        // grafoPalavras.getAdj(); // matriz de adjacência;

        arquivo.close();
        arquivoPalavras.close();
    }
}
