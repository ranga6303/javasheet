import java.util.*;

public class mergesort {
    static void display(int i,int j,int[] a){
        System.out.print("[");
        while(i<=j)System.out.print(" "+a[i++]+" ");
        System.out.println("]");
    }
    static int[] arr={13,27,31,8,4},res=new int[arr.length];
    static int temp,len=arr.length,iter=1,node=1;

    static void copy(int s,int d){
        res[d]=arr[s];
        System.out.println("index"+d);
    }

    static int[] merge(int i,int j){
        System.out.println("{\niter:"+iter+++"orginal:");
        display(0, len-1, arr);
        if(i==j){
            copy(i,0);
            System.out.print("res"+(iter-1));
            display(0, 0, res);
            System.out.println("}");
            return res;
        }
        int index=0,mid=(i+j)/2;
        System.arraycopy(merge(i,mid), 0, arr,i,(mid-i)+1);
        
        System.arraycopy(merge(mid+1,j), 0, arr,mid+1,j-mid);
        System.out.println("-------"+arr[i]);
        System.out.println("-------"+arr[i+1]);
        System.out.println("-------"+arr[mid+1]);
        
        int p1=i,p2=mid+1;
        while (p1<=mid&&p2<=j){
            if(arr[p1]>arr[p2])copy(p2++,index++);
            else if(arr[p1]<arr[p2])copy(p1++,index++);
            else {
                copy(p2++, index++);
                copy(p1++, index++);
            }
        }
        System.out.println("p1 at 5: "+p1);
        if(p1<=mid){copy(p1++,index++);}
        if(p2<=j){copy(p2++,index++);}
        System.out.print("res"+(iter-1));
        display(i, j, res);
        System.out.println("}");
        return res;
    }

    
    public static void main(String[] args) {
        merge(0,len-1);
        System.out.println("final sort");
        display(0, len-1, arr);
    }
}
