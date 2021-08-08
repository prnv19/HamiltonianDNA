import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 **   Java Program to generate k-mers and graph from a sequence
 */

public class DNA {
    List<String> kmer= new ArrayList<>();
    String seq;
    int[][] adj;
    int vertices;
    StringBuilder genome = new StringBuilder();

    //Constructor to create k-mers and add it to a list

    DNA(String seq){
        this.seq = seq;
        for(int i=0; i<seq.length() - 3 + 1;i++){
            kmer.add(seq.substring(i,i+3));
        }
        Collections.shuffle(kmer);
        this.vertices = kmer.size();
        adj = new int[vertices][vertices];
    }

    //Function to generate the adjacency matrix by comparing the prefix and suffix of each k-mer
    public void generate_adj(){
        int i = 0;
        while(i<vertices){
            int j = 0;
            while(j<vertices){
                if( kmer.get(i).substring(1,3).equals(kmer.get(j).substring(0,2))){
                    adj[i][j] = 1;
                }
                j++;
            }
            i++;
        }
    }

    //Function that displays the adjacency matrix
    public void display_adj(){
        for(int i = 0;i<vertices;i++){
            for(int j = 0;j<vertices;j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    //Function that finds the neighbouring nodes that is connected to node 'v'
    public void find_neighbour(int v){

            boolean a = true;
            System.out.println("Node "+v+" ("+(kmer.get(v))+")"+" is connected to : ");
            for(int j = 0;j<vertices;j++){
                if(adj[v][j] == 1){
                    System.out.print("--->");
                    System.out.println("Node "+j+" ("+kmer.get(j)+")");
                    a = false;
                }
                if(a && j == vertices-1){
                    System.out.println("No outgoing edges");
                }
            }
            System.out.println();
    }

    //Function to display all the nodes and the corresponding k-mer
    public void show_nodes(){
        System.out.println("Displaying Nodes..");
        for(int i=0;i<vertices;i++){
            System.out.println("Node " + i + " contains " + kmer.get(i) );
        }
        System.out.println();
        System.out.println();
    }

    //Function to construct the genome from a given path
    public void construct_genome(int[] path){

        for(int i=0;i < path.length;i=i+2){
            if(i == path.length-1){
                genome.append(kmer.get(path[i]));
            }
            else if(i+1 == path.length-1){

                genome.append(kmer.get(path[i]).substring(0,2));
                genome.append(kmer.get(path[i+1]).substring(1,3));
            }
            else {
                genome.append(kmer.get(path[i]).substring(0,2));
            }
        }
        System.out.println("Constructed Genome : "+genome);
    }

    public static void main(String[] args){

        DNA obj = new DNA("ATGGCGTGCA");

        System.out.println(obj.seq);
        System.out.println(obj.kmer);

        obj.generate_adj();
        obj.display_adj();
        obj.show_nodes();
        obj.find_neighbour(2);
    }
}
