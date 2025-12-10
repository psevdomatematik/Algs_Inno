package Lesson_1_2;

public class Lesson1_2 {
    public static void main(String[] args) {
        Edge edgeAB = new Edge(1500, 90, "A", "B");
        Edge edgeAC = new Edge(2000, 10, "A", "C");
        Edge edgeAD = new Edge(1000, 50, "A", "D");
        Edge edgeBF = new Edge(1500, 60, "B", "F");
        Edge edgeCE = new Edge(900, 5, "C", "E");
        Edge edgeCF = new Edge(500, 20, "C", "F");
        Edge edgeDE = new Edge(2500, 1, "D", "E");
        Edge edgeFE = new Edge(300, 85, "F", "E");

        EdgeNode edgeNodeAB = new EdgeNode(edgeAB);
        EdgeNode edgeNodeAC = new EdgeNode(edgeAC);
        EdgeNode edgeNodeAD = new EdgeNode(edgeAD);
        EdgeNode edgeNodeBF = new EdgeNode(edgeBF);
        EdgeNode edgeNodeCE = new EdgeNode(edgeCE);
        EdgeNode edgeNodeCF = new EdgeNode(edgeCF);
        EdgeNode edgeNodeDE = new EdgeNode(edgeDE);
        EdgeNode edgeNodeEF = new EdgeNode(edgeFE);

        edgeNodeAB.adjacentNodes = new EdgeNode[] {
                edgeNodeAC,
                edgeNodeAD,
                edgeNodeBF
        };

        edgeNodeAC.adjacentNodes = new EdgeNode[] {
                edgeNodeAB,
                edgeNodeAD,
                edgeNodeCE,
                edgeNodeCF
        };

        edgeNodeAD.adjacentNodes = new EdgeNode[] {
                edgeNodeAB,
                edgeNodeAC,
                edgeNodeDE
        };

        edgeNodeBF.adjacentNodes = new EdgeNode[] {
                edgeNodeAB,
                edgeNodeCF,
                edgeNodeEF
        };

        edgeNodeCE.adjacentNodes = new EdgeNode[] {
                edgeNodeAC,
                edgeNodeDE,
                edgeNodeEF,
                edgeNodeCF
        };

        edgeNodeCF.adjacentNodes = new EdgeNode[] {
                edgeNodeAC,
                edgeNodeCE,
                edgeNodeBF,
                edgeNodeEF
        };

        edgeNodeDE.adjacentNodes = new EdgeNode[] {
                edgeNodeAD,
                edgeNodeCE,
                edgeNodeEF
        };

        edgeNodeEF.adjacentNodes = new EdgeNode[] {
                edgeNodeBF,
                edgeNodeCF,
                edgeNodeCE,
                edgeNodeDE
        };

        System.out.println(edgeNodeAB);
        System.out.println(edgeNodeAB.adjacentNodes[2].adjacentNodes[1].adjacentNodes[0].adjacentNodes[0]);
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
    EdgeNode[] adjacentNodes;

    @Override
    public String toString() {
        return "EdgeNode{" +
                "edge=" + edge +
                '}';
    }

    public EdgeNode(Edge edge) {
        this.edge = edge;
    }
}