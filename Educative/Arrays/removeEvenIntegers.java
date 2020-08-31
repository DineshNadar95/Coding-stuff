import java.util.*;

public class removeEvenIntegers {
    public static void main(String[] args){
        int[] input = new int[]{1,2,4,5,10,6,3};
        int indx = 0;
        
        for(int i=0; i<input.length; i++){
            if(input[i] % 2 != 0){
                input[indx++] = input[i];
            }
        }

        int[] output = new int[indx];
        for(int x=0; x<indx; x++){
            output[x] = input[x];
        }
        
        for(int x: output)
            System.out.print(x+"\t");
    }
}