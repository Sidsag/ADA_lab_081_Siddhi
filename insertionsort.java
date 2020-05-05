
public class insertionsort {

    public static int[] insertion(int[] str,int count){
        for(int i=0;i<str.length;i++){
            count++;
            int key=str[i];
            int j=i-1;
             while(j>=0 && key<str[j]){
                 count++;
                str[j+1]=str[j];
                 j--;
                }
               str[j+1]=key;
        }
        System.out.println("no. of itteration: "+count);
        return str;
    }
    public static void main(String[] args){
        int[] arr={3,2,4,15,6};
        int count=0;
        int [] ans=insertion(arr,count);
        System.out.print("[ ");
        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println("]");
    }
  
}