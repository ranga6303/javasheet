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

    public static void array(int[][] arr){
        if(arr==null){
            System.out.println("array is empty");
            return;
        }
        
        int digits,max=String.valueOf((arr.length*arr[0].length)*(arr.length*arr[0].length)).length();
        System.out.println("\narray elements are:\n");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                digits=String.valueOf(arr[i][j]).length();

                System.out.print(arr[i][j]+"  ");
                while(digits<max){
                    System.out.print(" ");
                    digits++;
                }
            }
            System.out.println("\n");
        }
        
    }


    public static void array(String[] arr){
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
