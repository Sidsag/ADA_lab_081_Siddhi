import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;

public class four{


    public static int partition(char arr[], int low, int high) 
    { 
        char pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                char temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        
        char temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    public static void Rsort(char arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            //to choose ramdom element by swapping it with high
            Random rand= new Random(); 
            int pivot = rand.nextInt(high-low) + low; 
            char temp1=arr[pivot]; 
            arr[pivot]=arr[high]; 
            arr[high]=temp1; 
            
            int pi = partition(arr, low, high); 
            Rsort(arr, low, pi-1); 
            Rsort(arr, pi+1, high); 
        } 
    }
   
    
    public static void sort(char arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    }
        public static void main(String[] args) throws IOException, ParseException{
        FileReader fr=new FileReader("input2.txt");
        int i;
        String ques="";
        while((i=fr.read())!=-1){
          ques+=(char)i;
        }
        char [] mques=new char[ques.length()];
        for(int k=0;k<mques.length;k++){
            mques[k]=ques.charAt(k);
        }
       long startTime = System.currentTimeMillis();
    
       sort(mques,0,mques.length-1);  
    
       long endTime = System.currentTimeMillis(); 
       long duration = (endTime - startTime);  
       
        System.out.println("Quicksort "+duration);
        String fans="";
        for(int k=0;k<mques.length;k++){
            fans+=mques[k];
        }
        char [] mques2=new char[ques.length()];
        for(int k=0;k<mques.length;k++){
            mques2[k]=ques.charAt(k);
        }
        long startTimeR = System.currentTimeMillis();
    
        Rsort(mques2,0,mques.length-1);  
    
       long endTimeR = System.currentTimeMillis(); 
       long durationR = (endTimeR - startTimeR);  
       
        System.out.println("Randomised Quicksort "+durationR);
        fans+=" by randomised sort:   ";
        for(int k=0;k<mques.length;k++){
            fans+=mques2[k];
        }
        FileWriter fw=new FileWriter("output2.txt");  
        for (int j = 0; j < fans.length(); j++){ 
        fw.write(fans.charAt(j));}
        fw.close(); 
        //System.out.println(fans);
    }
}