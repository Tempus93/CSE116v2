package ratings.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<N> {

    private HashMap<N, ArrayList<N>> adjacencyList;
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public HashMap<N, ArrayList<N>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addEdge(N from, N to) {
        this.addNode(from);
        this.addNode(to);
        this.adjacencyList.get(from).add(to);
    }
    private void addNode(N a) {
        if (!this.adjacencyList.containsKey(a)) {
            this.adjacencyList.put(a, new ArrayList<>());
        }
    }
    public boolean areConnect(N from, N to){
        return this.adjacencyList.containsKey(from) && this.adjacencyList.get(from).contains(to);
    }
    public boolean validPath(ArrayList<N> path) {
        for (int i = 0; i < path.size() - 1; i++) {
            if (!this.areConnect(path.get(i), path.get(i + 1))) {
                return false;
            }
        }
        return true;

    }
}
