package samslib;

public class Display {
    public static void array(int[] arr){
        if(arr==null){
            System.out.println("array is empty");
            return;
        }
        System.out.println("array elements are:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" , ");
        }
        System.out.println();
    }
}
