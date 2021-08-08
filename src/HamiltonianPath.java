/*
 **   Java Program to Implement Hamiltonian Path Algorithm
 */

import java.util.Scanner;
import java.util.Arrays;

public class HamiltonianPath
{
    private int V, pathCount;
    public int[] path;
    private int[][] graph;


    /* Function to find cycle */
    public void findHamiltonianPath(int[][] g)
    {
        V = g.length;
        int END = 0;
        path = new int[V];

        Arrays.fill(path, -1); // fills the array with only -1
        graph = g;
        try
        {   //FINDING ROW SUM TO CALCULATE THE END
            {    int sumRow ;
                for(int i = 0; i < V; i++){
                    sumRow = 0;
                    for(int j = 0; j < V; j++){
                        sumRow = sumRow + g[i][j];
                    }
                    if (sumRow == 0)
                        END = i;
                }

            }


            //TRYING EACH TIME WITH A DIFFERENT START INDEX
            for (int start = 0 ; start<V;start = start +1) {
                path[0] = start;
                path[V-1] = END;
                pathCount = 1;
                solve(start);
                System.out.println("No solution in Attempt "+ start );
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            display();
        }
    }
    /* function to find paths recursively */
    public void solve(int vertex) throws Exception
    {
        /* solution */
        if (pathCount == V)
            throw new Exception("Solution found");
        /* all vertices selected but last vertex not linked to 0 */
        if (pathCount == V)
            return;

        for (int v = 0; v < V; v++)
        {
            /* if connected */
            if (graph[vertex][v] == 1 )
            {
                /* add to path */
                path[pathCount++] = v;
                /* remove connection */
                graph[vertex][v] = 0;


                /* if vertex not already selected  solve recursively */
                if (!isPresent(v))
                    solve(v);       // IF NOT REPEATED , IT GOES RECURSIVE  ELSE FOR LOOP 

                /* restore connection */
                graph[vertex][v] = 1;


                /* remove path */
                path[--pathCount] = -1;            // Backtracking


            }
        }
    }
    /* function to check if path is already selected */
    public boolean isPresent(int v)
    {
        for (int i = 0; i < pathCount - 1; i++) {
            if (path[i] == v) {
                return true;
            }}
        return false;
    }
    /* display solution */
    public void display()
    {
        System.out.print("\nPath : ");
        for (int i = 0; i <V; i++)
            System.out.print(path[i % V] +" ");
        System.out.println();
    }












    /* Main function */
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("HamiltonianCycle Algorithm Test\n");
        /* Make an object of HamiltonianCycle class */
        HamiltonianPath hc2 = new HamiltonianPath();

        /* Accept number of vertices */
        System.out.println("Enter number of vertices\n");
        int V = scan.nextInt();

        /* get graph */
        System.out.println("\nEnter matrix\n");
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scan.nextInt();

        hc2.findHamiltonianPath(graph);
    }
}