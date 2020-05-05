import java.util.Scanner;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
public class nqueenoptimizebcktrc {
   public static void printSolution(int [][] board) 
    {   int N=board.length;
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
            System.out.print(" " + board[i][j] 
                                 + " ");     
        System.out.println();}
    } 
      
    /* to check if a queen can 
    be placed on board[row][col]@Optimized function  */
    public static boolean check(int row, int col, int[][] slashCode, 
                int[][] backslashCode, boolean [] rowLookup, 
                boolean [] slashCodeLookup, boolean [] backslashCodeLookup) 
    { 
        if (slashCodeLookup[slashCode[row][col]] || 
            backslashCodeLookup[backslashCode[row][col]] || 
            rowLookup[row]) 
        return false; 
      
        return true; 
    } 
      
    /* futn solve  problem */
    public static boolean solveNQ(int[][] board, int col, 
        int [][]slashCode, int[][] backslashCode, boolean [] rowLookup, 
        boolean [] slashCodeLookup, boolean [] backslashCodeLookup) 
    {   int N=board.length;
        if (col >= N) 
            return true; 
        for (int i = 0; i < N; i++) 
        { 
            if ( check(i, col, slashCode, backslashCode, rowLookup, 
                        slashCodeLookup, backslashCodeLookup) ) 
            { 
               
                board[i][col] = 1; //place queen
                rowLookup[i] = true; 
                slashCodeLookup[slashCode[i][col]] = true; 
                backslashCodeLookup[backslashCode[i][col]] = true; 
      
                if ( solveNQ(board, col + 1, slashCode, backslashCode, 
                        rowLookup, slashCodeLookup, backslashCodeLookup) ) 
                    return true; 
      
                board[i][col] = 0; //else backtrack
                rowLookup[i] = false; 
                slashCodeLookup[slashCode[i][col]] = false; 
                backslashCodeLookup[backslashCode[i][col]] = false; 
            } 
        }
        return false; 
    }
      
    
      
    // driver program to test above function 
    public static void main(String args[]) throws ParseException
    {   Scanner input=new Scanner(System.in);
         System.out.println("enter ther no. of queen to be placed?");
        int n=input.nextInt();
        System.out.println("This is "+n+"queens problem:");
        int [][] board=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=0;
            }
        }
        // helper matrices 
        int [][] slashCode=new int[n][n];
        int [][] backslashCode=new int[n][n]; 
      
        // arrays to tell us which rows are occupied 
        boolean []rowLookup = new boolean[n];
      
        //keep two arrays to tell us which diagonals are occupied 
        boolean[] slashCodeLookup=new boolean[2*n - 1]; 
        boolean[] backslashCodeLookup=new boolean[2*n - 1];

         // initialize helper matrices 
         for (int r = 0; r < n; r++){
         for (int c = 0; c < n; c++){ 
             slashCode[r][c]= r + c; 
             backslashCode[r][c] = r - c + (n-1); }}
        long startTime = System.currentTimeMillis();
        if (solveNQ(board, 0, slashCode, backslashCode, 
        rowLookup, slashCodeLookup, backslashCodeLookup) == false ) 
        { 
          System.out.println("Solution does not exist"); 
        } 
        else
        printSolution(board); // solution found 
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);  //Total execution time in milli seconds
        System.out.println("time taken to solve:"+duration+" milisecond");
    } 
}