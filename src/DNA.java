import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DNA {
    List<String> kmer=new ArrayList<String>();
    String seq;

    DNA(String seq){
        this.seq = seq;
        for(int i=0; i<seq.length() - 3 + 1;i++){
            kmer.add(seq.substring(i,i+3));
        }
    }

    public void shuffle(){
        Collections.shuffle(kmer);
    }

    public static void main(String[] args){
        DNA obj = new DNA("AGCTGACTCACT");
        System.out.println(obj.seq);
        System.out.println(obj.kmer);
        obj.shuffle();
        System.out.println(obj.kmer);
        int size = obj.kmer.size();
        int[][] adj = new int[size][size];
        int i = 0;
        while(i<size-1){
            int j = i+1;
            while(j<size){
                if( obj.kmer.get(i).substring(1,3).equals(obj.kmer.get(j).substring(0,2))){
                    System.out.println("Match");
                    System.out.println(obj.kmer.get(i));
                    System.out.println(obj.kmer.get(j));
                    adj[i][j] = 1;
                }

                j++;
            }
            i++;
        }
        for(i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }


    }
}
