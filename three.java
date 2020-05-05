import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;
class three{
    public static char[] improvedinsertion(char[] array){
        for (int i = 1; i < array.length; i++) { 
            char x = array[i]; 
  
            // Find location to insert using binary search 
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1); 
  
            //Shifting array to one location right 
            System.arraycopy(array, j, array, j+1, i-j); 
  
            //Placing element at its correct location 
            array[j] = x;}
            return array;  
    }

    public static char[] insertion(char[] str){
        for(int i=0;i<str.length;i++){
            char key=str[i];
            int k=i;
            int j=i-1;
             while(j>=0){
                 if(str[j]>key){
                str[j+1]=str[j];
                k--;}
                 j--;
                }
               str[k]=key;
        }
        return str;
    }


public static void main(String[] args)throws IOException,ParseException{
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

    char[] mans=insertion(mques);  

   long endTime = System.currentTimeMillis(); 
   long duration = (endTime - startTime);  
 
    System.out.println("insertionsort "+duration);
    String fans="";
    for(int k=0;k<mans.length;k++){
        fans+=mans[k];
    }
    FileWriter fw=new FileWriter("output2.txt");  
    for (int j = 0; j < fans.length(); j++){ 
    fw.write(fans.charAt(j));}
    fw.close(); 
    //System.out.println(fans);
    char [] questr=new char[ques.length()];
    for(int k=0;k<questr.length;k++){
        questr[k]=ques.charAt(k);
    }
    long startTime2 = System.currentTimeMillis();

   char[] anstr= improvedinsertion(questr); 
   long endTime2 =System.currentTimeMillis(); 
   long duration2 = (endTime2 - startTime2);  
 
    System.out.println("improved insertion sort "+duration2);
    String ians="";
    for(int k=0;k<anstr.length;k++){
        ians+=anstr[k];
    }
    //System.out.println(ians);
    FileWriter fw2=new FileWriter("output2.txt");  
    for (int j = 0; j < ians.length(); j++){ 
    fw2.write(ians.charAt(j));}
    fw2.close(); 
}
}