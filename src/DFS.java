import java.util.LinkedList;

public class DFS {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DFS(graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        depthSearch(G, s);
    }

    private void depthSearch(graph G, int v) {
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                depthSearch(G, w);
            }
        }

    }

    public boolean marked(int w) {
        return marked[w];
    }

    public boolean hasPathTo(int v)
    {
        
        return marked[v];
    }

    public LinkedList pathTo(int v)
    {
        
        if(!hasPathTo(v))
            return null;
        
        LinkedList path = new LinkedList<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
            path.add(0,x);

        path.add(0,s);
        return path;
    }

}
