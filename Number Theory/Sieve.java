import java.util.*;

public class Sieve {

    public static void runSieve(int input , int nth){
        int[] primes = new int[input+1];
        int counter = 0;
        for(int i=0; i < input; i++){
            primes[i] = 1;      // all are primes initially
        }
        primes[0] = 1;
        primes[1] = 1;
        // for an `i` set its multiples as primes[i] = 0
        for(int i=2; i*i <= input; i++){
            if(primes[i] == 1){
                for(int j=i*i; j <= input; j += i){
                    primes[j] = 0;
                }
            }
        }

        for(int x=2; x < input; x++){       // because 2 & 3 will be set to `1`
            if(primes[x] == 1){
                counter++;
                if(counter == nth){
                    System.out.println("Nth prime here: "+x);
                }
            }
        }

        return;
    }
    public static void main(String[] args){
        // find all the N prime numbers before input
        runSieve(100000, 10001);
    }
}