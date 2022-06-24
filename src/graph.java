import java.util.LinkedList;

public class graph {
    private final int v; // vertices
    private LinkedList[] adj; // lista de adjacência

    public graph(int v) {
        this.v = v;
        adj = new LinkedList[v]; // inicializa a lista de adjacência;

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int inicio, int fim) {
        // se inicio liga no fim, então pego a lista de adjacência no valor 'inicio' e
        // adiciono o valor do 'fim'
        adj[inicio].add(fim);
    }

    public int V() {
        return v;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public void getAdj() {
        for (int i = 0; i < v; i++) {
            System.out.println(adj[i]);
        }
    }

    public int[] getDistance(int s) {

        // recebe o vértice s e calcula a distância dele para todos os outros vértices;
        int[] distancias = new int[v];
        DFS busca = new DFS(this, s);
        for (int i = 0; i < v; i++) {
            int size = 0;
            if (busca.pathTo(i) != null) {
                size = busca.pathTo(i).size();
            }
            distancias[i] = size - 1;
        }
        return distancias;
    }

    public int avgDistance() {
        // calcula a distância média entre todos os vértices;
        int somaDist = 0;

        for (int i = 0; i < v; i++) {
            for(int j = 0; j < getDistance(i).length; j++)
            {
                somaDist += getDistance(i)[j];
            }
            
        }

        System.out.println(somaDist);
        
        return somaDist/(v*v);
    }

    public void comparaPalavras(String[] palavras) {
        for (int j = 0; j < palavras.length; j++)
            for (int k = j; k < palavras.length; k++) {
                int count = 0;
                for (int i = 0; i < 5; i++) {
                    if ((palavras[j].charAt(i) != palavras[k].charAt(i))) {
                        if (count > 1) {
                            break;
                        }
                        count++;
                    }

                }

                if (count == 1) {
                    addEdge(j, k);
                    addEdge(k, j);
                }
            }
    }
}
