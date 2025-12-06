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

        Edge []arrayOfEdges = {edgeAB, edgeAC, edgeAD, edgeBF, edgeCE, edgeCF, edgeDE, edgeFE};

        System.out.println(arrayOfEdges[5]);
        System.out.println(arrayOfEdges[2]);
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