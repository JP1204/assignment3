package assignment3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vertex<T> {
    private T name;
    private Map<T, Integer> edges;

    public Vertex(T name) {
        this.name = name;
        edges = new HashMap<>();
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public Map<T, Integer> getEdges() {
        return edges;
    }

    public void setEdges(Map<T, Integer> edges) {
        this.edges = edges;
    }
}
