import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        ArrayList<Node> graph = new ArrayList<>();
        for (int i = 0; i < adjList.length; i++) {
            Node tmp = new Node(i + 1);
            graph.add(tmp);
        }
        for (int i = 0; i < adjList.length; i++) {
            ArrayList<Node> tmpList = new ArrayList<>();
            for (int n : adjList[i]) {
                tmpList.add(graph.get(n - 1));
            }
            graph.get(i).neighbors = tmpList;
        }
        printGraph(graph);
        Node newNode = cloneGraph(graph.get(0));
        System.out.println(newNode + ": " + newNode.val);
        for (Node tmpNeigh : newNode.neighbors) {
            System.out.print("\t" + tmpNeigh.val);
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Integer, Node> graphMap = new HashMap<>();

        return deepClone(node, graphMap);
    }

    public static Node deepClone(Node node, HashMap<Integer, Node> graphMap) {
        if (graphMap.containsKey(node.val))
            return graphMap.get(node.val);
        Node tmp = new Node(node.val);
        graphMap.put(node.val, tmp);
        for (Node tmpNeigh : node.neighbors) {
            graphMap.get(node.val).neighbors.add(deepClone(tmpNeigh, graphMap));
        }
        return graphMap.get(node.val);
    }

    public static void printGraph(ArrayList<Node> graph) {
        for (Node tmp : graph) {
            System.out.println(tmp + ": " + tmp.val);
            for (Node tmpNeigh : tmp.neighbors) {
                System.out.print("\t" + tmpNeigh.val);
            }
            System.out.println();
        }
        System.out.println();
    }
}
