package templates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node {

    int index;
    Map<Integer, Edge> edges;
    Boolean value; // this can be used to represent anything

    public Node(int index) {
        this.index = index;
        this.edges = new HashMap<>();
        this.value = null;
    }

    public Node(int index, Boolean value) {
        this.index = index;
        this.edges = new HashMap<>();
        this.value = value;
    }

    public int numEdges() {
        return this.edges.size();
    }

    public Edge getEdge(int neighbor) {
        return this.edges.get(neighbor);
    }

    public void addEdge(int neighbor, double weight) {
        this.edges.put(neighbor, new Edge(this.index, neighbor, weight));
    }

    public void removeEdge(int neighbor) {
        this.edges.remove(neighbor);
    }

    public List<Edge> getEdges() {
        return new ArrayList<>(this.edges.values());
    }

    public List<Edge> getSortedEdges() {
        List<Integer> neighbors = new ArrayList<>(this.edges.keySet());
        Collections.sort(neighbors);

        List<Edge> result = new ArrayList<>();
        for (int n : neighbors) {
            result.add(this.edges.get(n));
        }

        return result;
    }

    public List<Integer> getNeighbors() {
        Set<Integer> result = new HashSet<>();

        for (Edge e : this.edges.values()) {
            result.add(e.toNode);
        }

        return new ArrayList<>(result);
    }
}

class Edge {

    int fromNode;
    int toNode;
    double weight;

    public Edge(int fromNode, int toNode, double weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }
}

class Graph {

    int numNodes;
    List<Node> nodes;
    boolean undirected;

    public Graph(int numNodes, boolean undirected) {
        this.numNodes = numNodes;
        this.nodes = new ArrayList<>();
        this.undirected = undirected;

        for (int i = 0; i < numNodes; i++) {
            this.nodes.add(new Node(i));
        }
    }

    public Node addNode() {
        Node node = new Node(this.numNodes);

        this.nodes.add(node);
        this.numNodes += 1;

        return node;
    }

    public Edge getEdge(int fromNode, int toNode) {
        checkInput(fromNode, toNode);

        return this.nodes.get(fromNode).getEdge(toNode);
    }

    public boolean isEdge(int fromNode, int toNode) {
        return getEdge(fromNode, toNode) != null;
    }

    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();

        for (Node n : this.nodes) {
            for (Edge e : n.getEdges()) {
                edges.add(e);
            }
        }

        return edges;
    }

    public void addEdge(int fromNode, int toNode, double weight) {
        this.checkInput(fromNode, toNode);

        this.nodes.get(fromNode).addEdge(toNode, weight);

        if (this.undirected) {
            this.nodes.get(toNode).addEdge(fromNode, weight);
        }
    }

    public void removeEdge(int fromNode, int toNode) {
        this.checkInput(fromNode, toNode);

        this.nodes.get(fromNode).removeEdge(toNode);

        if (this.undirected) {
            this.nodes.get(toNode).removeEdge(fromNode);
        }
    }

    public Graph copy() {
        Graph g2 = new Graph(this.numNodes, this.undirected);

        for (Node n : this.nodes) {
            g2.nodes.get(n.index).value = n.value;
            for (Edge e : n.edges.values()) {
                g2.addEdge(e.fromNode, e.toNode, e.weight);
            }
        }

        return g2;
    }

    private void checkInput(int fromNode, int toNode) {
        if (fromNode < 0 || fromNode >= this.nodes.size()) {
            throw new Error("Invalid 'from' Node");
        }

        if (toNode < 0 || toNode >= this.nodes.size()) {
            throw new Error("Invalid 'to' Node");
        }
    }

    public void print() {
        for (Node n : this.nodes) {
            if (n.edges.size() == 0) {
                System.out.printf("(%s)\n", n.index);
            } else {
                for (Edge e : n.edges.values()) {
                    System.out.printf("(%s) - %.1f -> (%s)\n", e.fromNode, e.weight, e.toNode);
                }
            }
        }
    }
}

public class TGraph {

    public static void main(String[] args) {
        Graph g = new Graph(5, false);
        g.addEdge(0, 1, 1.0);
        g.addEdge(0, 3, 1.0);
        g.addEdge(0, 4, 3.0);
        g.addEdge(1, 2, 2.0);
        g.addEdge(1, 4, 1.0);
        g.addEdge(3, 4, 3.0);
        g.addEdge(4, 2, 3.0);
        g.addEdge(4, 3, 3.0);
        g.print();

        Graph g2 = g.copy();
        g2.print();
    }
}
