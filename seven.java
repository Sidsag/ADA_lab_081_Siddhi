import java.util.*; 
import java.lang.*; 
import java.io.*; 

class seven 
{ 
	
	public static void printMaxActivities(int s[], int f[],int [] aid, int n) 
	{ 
    System.out.println("Following activities are selected :"); 
    int i=0;
    System.out.print(aid[i]);
    int j;
	for (j = 1; j < n; j++) 
	{ 
		
		if (s[j] >= f[i]) 
		{ 
			System.out.print(","+aid[j]); 
			i = j; 
		} 
	} 
	} 
	
		public static void main(String[] args) 
	{ 
    int id[]= {1, 2, 3, 4, 5};
	int s[] = {1, 3, 2, 4, 5}; 
    int f[] = {5, 4, 3, 7, 8};
    int n = s.length;
    int[] fi=new int[n]; 
    int[] ns=new int[n];  
    for(int i=0;i<n;i++){
        fi[i]=f[i];
    }
    Arrays.sort(f);
    int [] nid=new int[n];
    for(int i=0;i<n;i++){
        int search=f[i];
        for(int j=0;j<n;j++){
            if(search==fi[j]){
            nid[i]=id[j];
            ns[i] =s[j];}
        }
    }	
	printMaxActivities(ns, f,nid, n); 
	} 
	
}