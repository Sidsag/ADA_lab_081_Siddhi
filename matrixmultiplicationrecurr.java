
public class matrixmultiplicationrecurr {
    
        public static int MAX = 100; 
          
        public static int i = 0, j = 0, k = 0; 
          
        static void multiplyMatrixRec(int row1, int col1, int A[][], 
                           int row2, int col2, int B[][], 
                           int C[][]) 
        { 
            if (i >= row1) 
                return; 

            if (j < col2) 
            { 
                if (k < col1) 
                { 
                    C[i][j] += A[i][k] * B[k][j]; 
                    k++; 
       
                    multiplyMatrixRec(row1, col1, A, row2, col2, B, C); 
                } 
       
                k = 0; 
                j++; 
                multiplyMatrixRec(row1, col1, A, row2, col2, B, C); 
            } 
       
            j = 0; 
            i++; 
            multiplyMatrixRec(row1, col1, A, row2, col2, B, C); 
        } 
       
        static void multiplyMatrix(int row1, int col1, int A[][], 
                        int row2, int col2, int B[][]) 
        { 
            if (row2 != col1) 
            { 
                System.out.println("Not Possible\n"); 
                return; 
            } 
       
            int[][] C = new int[MAX][MAX]; 
       
            multiplyMatrixRec(row1, col1, A, row2, col2, B, C); 
       
            for (int i = 0; i < row1; i++) 
            { 
                for (int j = 0; j < col2; j++) 
                    System.out.print(C[i][j]+"\t"); 
       
                System.out.println(); 
            } 
        } 
          
        public static void main (String[] args)  
        { 
             
            int A[][] = { {1, 2, 3}, 
                          {4, 5, 6}, 
                          {7, 8, 9}}; 
       
            int B[][] = { {1, 2, 3}, 
                          {4, 5, 6}, 
                          {7, 8, 9} }; 
            int row1=A.length;
            int row2=B.length;
            int col1=A[0].length;
            int col2=B[0].length;
       
            multiplyMatrix(row1, col1, A, row2, col2, B); 
        } 
    } 
      
   