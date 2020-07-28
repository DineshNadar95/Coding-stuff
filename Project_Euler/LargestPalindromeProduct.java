import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestPalindromeProduct {
    
    private static boolean isPalindrome(int input){
        int original = input;
        int reversed = 0;
        // input == rev(input)
        while(input != 0){
            int rem = input % 10;
            reversed = reversed*10 + rem;
            input /= 10;
        }
        return reversed == original;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt(); 
            int globalProd = Integer.MIN_VALUE;

            for(int a=99; a<=999; a=a+1){
                int prod = 1;
                for(int b=99; b<=999; b++){
                    prod = a*b;
                    if(isPalindrome(prod) && prod < n){
                        globalProd = Math.max(globalProd, prod);
                    }
                }
            }
            System.out.println(globalProd);
        }
    }
}
