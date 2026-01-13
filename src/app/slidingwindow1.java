package app;

import java.util.HashSet;
import samslib.*;

public class slidingwindow1 {
    static HashSet<Integer> map=new HashSet<>();
    static int reqsum,temp,start;
    static int window(int[] arr,int winlen){

        for(int i=0;i<winlen;i++){
            temp+=arr[i];
            map.add(arr[i]);
        }
        reqsum=temp;
        map.remove(arr[start]);
        temp-=arr[start];

        for(int i=1;i<arr.length-winlen;i++){
            int k=i+winlen-1;
            
            if(map.contains(arr[k]))continue;

            map.add(arr[k]);
            temp+=arr[k];
            
            if(reqsum<temp){
                reqsum=temp;
                start=i;
            }    

            map.remove(arr[i]);
            temp-=arr[i];
        }
        return reqsum;
    }

    static void DisSubArr(int[] arr,int len){
        System.out.println(" givem subset length : "+len);
        System.out.println("highst sum of formed subsets = "+window(arr,len));
        System.out.print("set details : ");
        for(int j=start;j<start+len;j++){
            System.out.print(arr[j]+", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        RandomGen r = new RandomGen();
        int[] arr=r.array(10);
        Display.array(arr);
        int subSize=3;
        DisSubArr(arr,subSize);
        
    }
}
