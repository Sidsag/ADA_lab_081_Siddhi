import java.lang.Math;
import java.util.Scanner;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
// Java code to for n Queen placement 
class nqueenittr
{ 
	static int MAX = 100; 
	static int arr[] = new int[MAX], no; 
    
	
	static void nQueens(int k, int n) 
	{ 

		for (int i = 1; i <= n; i++) 
		{ 
			if (canPlace(k, i)) 
			{ 
				arr[k] = i; 
				if (k == n) 
				{ 
					display(n); 
				} 
				else
				{ 
					nQueens(k + 1, n); 
				} 
			} 
		} 
	} 

	// Helper Function to check if queen can be placed 
	static boolean canPlace(int k, int i) 
	{ 
		for (int j = 1; j <= k - 1; j++) 
		{ 
			if (arr[j] == i || 
				(Math.abs(arr[j] - i) == Math.abs(j - k))) 
			{ 
				return false; 
			} 
		} 
		return true; 
	} 

	// Function to display placed queen 
	static void display(int n) 
	{ 
		if(no<1){
		for (int i = 1; i <= n; i++) 
		{ 
			for (int j = 1; j <= n; j++) 
			{ 
				if (arr[i] != j) 
				{ 
					System.out.print(" 0 "); 
				} 
				else
				{ 
					System.out.print(" 1 "); 
				} 
			} 
			no=no+1;
			System.out.println(""); 
		} 
		}
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		Scanner input=new Scanner(System.in);
        System.out.println("enter ther no. of queen to be placed?");
        int n=input.nextInt();
		System.out.println("This is "+n+"queens problem:");
		long startTime = System.currentTimeMillis();
		nQueens(1, n); 
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);  //Total execution time in milli seconds
		System.out.println("");
        System.out.println("time taken to solve:"+duration+" milisecond");
	} 
} 

// This code is contributed by 29AjayKumar 
