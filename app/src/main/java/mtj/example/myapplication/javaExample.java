package mtj.example.myapplication;

import java.util.ArrayList;

public class javaExample {




    public static void main (String[] args ) {
        // your block here
        int[] arr1= {4,9,3,5,7,4,9};
        int[] arr2= {14,19,43,5,77,4,9};

        for(int i =0;i<=arr1.length;i++)
        {
            for(int j =0;j<=arr2.length;j++)
            {
                if(arr1[i]==arr2[j])
                System.out.println(i);
            }
        }
    }

}
