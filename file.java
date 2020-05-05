import java.io.*;
import java.text.ParseException; 
public class file
{ 
  public static void main(String[] args) throws Exception 
  { 
    // pass the path to the file as a parameter 
    FileReader fr =  new FileReader("C:\\Users\\SIDSAG\\Desktop\\testi\\sid.txt"); 
    String s="";
    int i; 
    i=fr.read()-48;
    int w;
    System.out.println(i);
    while ((w=fr.read()) != -1){
        s+=(int)w-48;
  }
  System.out.print(s);
}
} 