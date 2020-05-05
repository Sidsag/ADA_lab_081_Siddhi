
public class mergesort {
    static  int count=0;
    public static int[] mergesort(int[] str,int low,int high){
        if(low==high){
           int[] bans={str[low]};
           return bans;
        }
        int mid =(low+high)/2;
        count++;
        int[] left=mergesort(str,low,mid);
        int [] right=mergesort(str,mid+1,high);
        int [] ans=merge(left,right);
        return ans;
    }

    public static int[] merge(int[] left,int[]  right){
        int i=0;
        int j=0;
        int k=0;
        int[] mans=new int[left.length+right.length];
        while(i<left.length && j<right.length){
        count++;
        int a=left[i];
        int b=right[j];
        if(a<b){
            mans[k]=left[i];
            i++;
            k++;
        }else{
            mans[k]=right[j];
            j++; 
            k++; 
        }
        }
        while(i<left.length){
            count++;
            mans[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            count++;
            mans[k]=right[j];
            j++;
            k++; 
        }
        return mans;
    }
    public static void main(String[] args){
        int[] arr={3,2,4,15,6};
        int [] ans=mergesort(arr,0,arr.length-1);
        System.out.print("[ ");
        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println("]");
        System.out.println("no. of itteration:"+count);
    }

}