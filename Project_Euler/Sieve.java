import java.util.*;

public class Sieve{ 
    public static void main(String[] args){
        int input = 50;

        boolean[] primes = new boolean[input+1];

        for(int i=0; i<primes.length; i++){
            primes[i] = true;
        }

        for(int p=2; p*p <= primes.length; p++){
            if(primes[p] == true){
                for(int i=p*p; i<= primes.length; i += p){
                    primes[i] = false;
                }
            }
        }

        for(int p=2; p <= primes.length; p++){
            if
        }
    }
}