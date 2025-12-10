package Lesson_1_1;

import java.util.Arrays;

public class Lesson1_1 {
    public static void main(String[] args) {
        StartVertex[] vertexes = {
                new StartVertex("A",
                        new EndVertex[]{
                                new EndVertex("B", 1500, 90),
                                new EndVertex("C", 2000, 10),
                                new EndVertex("D", 1000, 50)
                        }),
                new StartVertex("B",
                        new EndVertex[]{
                                new EndVertex("A", 1500, 90),
                                new EndVertex("F", 1500, 60),
                        }),
                new StartVertex("C",
                        new EndVertex[]{
                                new EndVertex("A", 2000, 10),
                                new EndVertex("E", 900, 5),
                                new EndVertex("F", 500, 20),
                        }),
                new StartVertex("D",
                        new EndVertex[]{
                                new EndVertex("A", 1000, 50),
                                new EndVertex("E", 2500, 1),
                        }),
                new StartVertex("E",
                        new EndVertex[]{
                                new EndVertex("C", 900, 5),
                                new EndVertex("D", 2500, 1),
                                new EndVertex("F", 300, 85),
                        }),
                new StartVertex("F",
                        new EndVertex[]{
                                new EndVertex("B", 1500, 60),
                                new EndVertex("C", 500, 20),
                                new EndVertex("E", 300, 85),
                        }),
        };

        for (StartVertex vertex : vertexes) {
            System.out.println(vertex);
            for (EndVertex adVertex: vertex.adjacentVertexes) {
                System.out.println(adVertex);
            }
        }
    }
}

class StartVertex {
    String name;
    EndVertex[] adjacentVertexes;

    public StartVertex(String name, EndVertex[] adjacentVertexes) {
        this.name = name;
        this.adjacentVertexes = adjacentVertexes;
    }

    @Override
    public String toString() {
        return "Lesson_1_1.StartVertex{" +
                "name='" + name + '\'' +
                ", adjacentVertexes=" + Arrays.toString(adjacentVertexes) +
                '}';
    }
}

class EndVertex {
    String name;

    public EndVertex(String name, int throughput, int loss) {
        this.name = name;
        this.throughput = throughput;
        this.loss = loss;
    }

    int throughput;
    int loss;

    @Override
    public String toString() {
        return "Lesson_1_1.EndVertex{" +
                "name='" + name + '\'' +
                ", throughput=" + throughput +
                ", loss=" + loss +
                '}';
    }
}

