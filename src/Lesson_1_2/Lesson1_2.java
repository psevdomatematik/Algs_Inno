package Lesson_1_2;

public class Lesson1_2 {
    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");

        vertexA.edges = new Edge[] {
                new Edge(vertexB, 1500, 90),
                new Edge(vertexC, 2000, 10),
                new Edge(vertexD, 1000, 50)
        };

        vertexB.edges = new Edge[] {
                new Edge(vertexA, 1500, 90),
                new Edge(vertexF, 1500, 60),
        };

        vertexC.edges = new Edge[] {
                new Edge(vertexA, 2000, 10),
                new Edge(vertexE, 900, 5),
                new Edge(vertexF, 500, 20),
        };

        vertexD.edges = new Edge[] {
                new Edge(vertexA, 1000, 50),
                new Edge(vertexE, 2500, 1),
        };

        vertexE.edges = new Edge[] {
                new Edge(vertexC, 900, 5),
                new Edge(vertexD, 2500, 1),
                new Edge(vertexF, 300, 85),
        };

        vertexF.edges = new Edge[] {
                new Edge(vertexB, 1500, 60),
                new Edge(vertexC, 500, 20),
                new Edge(vertexE, 300, 85),
        };

        Vertex startVertex = vertexA;
        startVertex = startVertex.edges[0].vertex; // вершина B
        startVertex = startVertex.edges[1].vertex; // вершина F
        startVertex = startVertex.edges[2].vertex; // вершина E

        System.out.println(startVertex);

        System.out.println("Пропускная способность от E до D " + startVertex.edges[1].throughput);
        System.out.println("Процент потерянных пакетов от E до F " + startVertex.edges[2].loss);

    }
}


class Vertex {
    String name;
    Edge[] edges;

    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Edge {
    Vertex vertex;
    int throughput;
    int loss;

    public Edge(Vertex vertex, int throughput, int loss) {
        this.vertex = vertex;
        this.throughput = throughput;
        this.loss = loss;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex=" + vertex +
                ", throughput=" + throughput +
                ", loss=" + loss +
                '}';
    }
}
