public class Main{
    public static void main(String[] args){
        DNA dna = new DNA("TAATGCCATGGGATGTT");
        HamiltonianPath hp = new HamiltonianPath();

        dna.generate_adj();
        dna.display_adj();
        dna.show_nodes();

        hp.findHamiltonianPath(dna.adj);
        dna.construct_genome(hp.path);

    }
}