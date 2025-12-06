import java.lang.reflect.Array;

public class Lesson1_1 {
    public static void main(String[] args) {
        Edge edgeAB = new Edge(1500, 90, "A", "B");
        Edge edgeAC = new Edge(2000, 10, "A", "C");
        Edge edgeAD = new Edge(1000, 50, "A", "D");
        Edge edgeBF = new Edge(1500, 60, "B", "F");
        Edge edgeCE = new Edge(900, 5, "C", "E");
        Edge edgeCF = new Edge(500, 20, "C", "F");
        Edge edgeDE = new Edge(2500, 1, "D", "E");
        Edge edgeFE = new Edge(300, 85, "F", "E");

        // через массив
        Edge []arrayOfEdges = {edgeAB, edgeAC, edgeAD, edgeBF, edgeCE, edgeCF, edgeDE, edgeFE};

        System.out.println(arrayOfEdges[5]);
        System.out.println(arrayOfEdges[2]);

        // через узлы
        EdgeNode edgeNodeAB = new EdgeNode(edgeAB);
        EdgeNode edgeNodeAC = new EdgeNode(edgeAC);
        EdgeNode edgeNodeAD = new EdgeNode(edgeAD);
        EdgeNode edgeNodeBF = new EdgeNode(edgeBF);
        EdgeNode edgeNodeCE = new EdgeNode(edgeCE);
        EdgeNode edgeNodeCF = new EdgeNode(edgeCF);
        EdgeNode edgeNodeDE = new EdgeNode(edgeDE);
        EdgeNode edgeNodeEF = new EdgeNode(edgeFE);

        edgeNodeAB.adjacentEdgeOne = edgeNodeAC;
        edgeNodeAB.adjacentEdgeTwo = edgeNodeAD;
        edgeNodeAB.adjacentEdgeThree = edgeNodeBF;
        edgeNodeAB.adjacentEdgeFour = null;

        edgeNodeAC.adjacentEdgeOne = edgeNodeAB;
        edgeNodeAC.adjacentEdgeTwo = edgeNodeAD;
        edgeNodeAC.adjacentEdgeThree = edgeNodeCE;
        edgeNodeAC.adjacentEdgeFour = edgeNodeCF;

        edgeNodeAD.adjacentEdgeOne = edgeNodeAB;
        edgeNodeAD.adjacentEdgeTwo = edgeNodeAC;
        edgeNodeAD.adjacentEdgeThree = edgeNodeDE;
        edgeNodeAD.adjacentEdgeFour = null;

        edgeNodeBF.adjacentEdgeOne = edgeNodeAB;
        edgeNodeBF.adjacentEdgeTwo = edgeNodeCF;
        edgeNodeBF.adjacentEdgeThree = edgeNodeEF;
        edgeNodeBF.adjacentEdgeFour = null;

        edgeNodeCE.adjacentEdgeOne = edgeNodeAC;
        edgeNodeCE.adjacentEdgeTwo = edgeNodeDE;
        edgeNodeCE.adjacentEdgeThree = edgeNodeEF;
        edgeNodeCE.adjacentEdgeFour = edgeNodeCF;

        edgeNodeCF.adjacentEdgeOne = edgeNodeAC;
        edgeNodeCF.adjacentEdgeTwo = edgeNodeCE;
        edgeNodeCF.adjacentEdgeThree = edgeNodeBF;
        edgeNodeCF.adjacentEdgeFour = edgeNodeEF;

        edgeNodeDE.adjacentEdgeOne = edgeNodeAD;
        edgeNodeDE.adjacentEdgeTwo = edgeNodeCE;
        edgeNodeDE.adjacentEdgeThree = edgeNodeEF;
        edgeNodeDE.adjacentEdgeFour = null;

        edgeNodeEF.adjacentEdgeOne = edgeNodeBF;
        edgeNodeEF.adjacentEdgeTwo = edgeNodeCF;
        edgeNodeEF.adjacentEdgeThree = edgeNodeCE;
        edgeNodeEF.adjacentEdgeFour = edgeNodeDE;

        System.out.println(edgeNodeCE);
        System.out.println(edgeNodeAD);
    }    
}

class Edge {
    int size;
    int loss;
    String start;
    String end;

    public Edge(int size, int loss, String start, String end) {
        this.size = size;
        this.loss = loss;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "size=" + size +
                ", loss=" + loss +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}

class EdgeNode {
    Edge edge;
    EdgeNode adjacentEdgeOne;
    EdgeNode adjacentEdgeTwo;
    EdgeNode adjacentEdgeThree;
    EdgeNode adjacentEdgeFour;

    public EdgeNode(Edge edge) {
        this.edge = edge;
    }

    @Override
    public String toString() {


        String s = "EdgeNode{" +
                "edge=" + edge +
                ",\n adjacentEdgeOne=" + ((adjacentEdgeOne == null) ? "null" : adjacentEdgeOne.edge.toString()) +
                ",\n adjacentEdgeTwo=" + ((adjacentEdgeTwo == null) ? "null" : adjacentEdgeTwo.edge.toString()) +
                ",\n adjacentEdgeThree=" + ((adjacentEdgeThree == null) ? "null" : adjacentEdgeThree.edge.toString()) +
                ",\n adjacentEdgeFour=" + ((adjacentEdgeFour == null) ? "null" : adjacentEdgeFour.edge.toString()) +
                "}";
        return s;
    }
}