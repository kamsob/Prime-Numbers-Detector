/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * class to detect all prime numbers under n given in the constructor
 * @author Kamil Sobocinski
 */
public class PrimeDetector {
    private int primeCounter; //count how many primes are under N
    private final boolean[] isPrime; //Array which have information if number is prime or not(true/false)
    
    /**
     * function detecting prime nubers under n
     * @param n number under which we want to gather primes n 
     */
    public PrimeDetector(int n)
    {
        primeCounter = 0;
        isPrime = new boolean[n+1];
        sieveOfEratosthenes();
    }
    
    /*
    *function that checks if number is prime or not
    *Information is saved in boolean array
    */
    private void sieveOfEratosthenes()
    {
        for (int i = 0; i < isPrime.length; i++)
            isPrime[i] = true;
        for (int p = 2; p * p < isPrime.length; p++)
            if (isPrime[p] == true)
                for (int i = p * p; i < isPrime.length; i += p)
                    isPrime[i] = false;
        for(int i = 2; i<isPrime.length; i++)
            if(isPrime[i]==true)
                primeCounter++;
    }
    
    /**
     * Function that creates new array of just prime numbers
     * basing on boolean array isPrime and returns that new array
     * @return primeNumbers detected by the class prime numbers
     */
    public int[] getPrimes()
    {
        int[] primeNumbers = new int[primeCounter];
        int counter = 0;
        for(int i = 2; i<isPrime.length; i++)
            if(isPrime[i] == true){
                primeNumbers[counter] = i;
                counter++;
            }
        return primeNumbers;
    }
}
