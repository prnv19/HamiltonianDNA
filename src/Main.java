public class AdjMatrix {
    int vertices; //No  of vertices
    int[][] matrix; // 2d matrix

    AdjMatrix(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int source, int destination){
        matrix[source][destination] = 1;
    }

    void displayAdjMatrix(){
        for(int i=0; i < vertices ; i++){
            for(int j = 0; j < vertices; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void findNeighbour(int vertex) {
        System.out.println("The Neighbours of vertex "+ vertex +" are : ");
        boolean a = false;
        for(int j=1;j<vertices;j++) {
            if (matrix[vertex][j] == 1) {
                System.out.println(j);
                a = true;
            }
        }
        if(!a){
            System.out.println("No neighbours found");
        }
    }
    public static void main(String[] args) {
        AdjMatrix obj = new AdjMatrix(5);

        obj.addEdge(0,4);
        obj.addEdge(1,4);
        obj.addEdge(4,1);
        obj.addEdge(3,4);
        obj.addEdge(4,3);
        obj.addEdge(4,2);

        obj.displayAdjMatrix();

        obj.findNeighbour(0);
        obj.findNeighbour(1);
        obj.findNeighbour(2);
        obj.findNeighbour(3);
        obj.findNeighbour(4);
    }
}
