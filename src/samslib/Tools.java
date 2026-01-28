package samslib;

public class Tools {
    public static void swap(int[]arr,int i,int j){
        if(arr!=null){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }
    }
}
