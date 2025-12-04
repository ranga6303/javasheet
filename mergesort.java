import java.util.*;

public class Main {
    static void display(int i,int j,int[] a){
        while(i<=j)System.out.print(" "+a[i++]+" ");
    }
    static int[] arr={2 , 23 , 39 , 24 , 25 , 36 , 9 , 10 , 11 , 36 , 34 , 21 , 22 , 27 , 35 , 1 , 26 , 16 , 24 , 36},res=new int[arr.length];
    static int temp,len=arr.length,iter=1,node=1;

    static void copy(int s,int d){
        res[d]=arr[s];
    }

    static int[] merge(int i,int j){
        if(i==j){
            copy(i,0);
            return res;
        }
        int index=0,mid=(i+j)/2;
        System.arraycopy(merge(i,mid), 0, arr,i,(mid-i)+1);

        System.arraycopy(merge(mid+1,j), 0, arr,mid+1,j-mid);
         int p1=i,p2=mid+1;
        while (p1<=mid&&p2<=j){
            if(arr[p1]>arr[p2])copy(p2++,index++);
            else if(arr[p1]<arr[p2])copy(p1++,index++);
            else {
                copy(p2++, index++);
                copy(p1++, index++);
            }
        }
        while(p1<=mid){copy(p1++,index++);}
        while(p2<=j){copy(p2++,index++);}
        return res;
    }


    public static void main(String[] args) {
        System.arraycopy(merge(0,len-1),0,arr,0,len);
        System.out.println("final sort\n");
        display(0, len-1, arr);
    }
}
