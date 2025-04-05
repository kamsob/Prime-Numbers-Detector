/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Exceptions.InputException;
import jakarta.inject.Singleton;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.*;

/**
 *
 * @author kamso
 */
@Getter
@NoArgsConstructor
//@Singleton
public class PrimeDetector {
    private long primeCounter; //count how many primes are under N
    private List<Boolean> isPrime; //Array which have information if number is prime or not(true/false)
    private int nNumber; // N number given by the user
    private List<Integer> detectedPrimesHistory;
    //private static PrimeDetector instance;
    
    //public static PrimeDetector getInstance() {
    //    if (instance == null) {
    //        instance = new PrimeDetector();
    //    }
    //    return instance;
    //}

    /**
     * Does operation on a given stream
     * @param p parameter defining starting point of a stream
     * @param size stream size - number of elements to process
     */
    interface StreamsOperation {
        void operation(int p, int size);
    }
    
    /**
     * Does operation on a given stream using passed implementation of StreamsOperation interface 
     * @param p parameter defining starting point of a stream
     * @param size stream size - number of elements to process
     * @param op StreamOperation Interface implementation - defines operation logic
     */
    private void operateStream(int p, int size, StreamsOperation op){
         op.operation(p, size);
    }
    
    /**
     * method that validates input and if it is correct input is
     * set as nNumber and if it is not then proper exception is thrown
     * @param enterPhrase enterPhrase from user should contain integer larger than 1
     * @return true if input is valid and false if it is not
     * @throws InputException exception for either wrong type or wrong input number 
     */
    public boolean inputValidation(String[] enterPhrase) throws InputException
    {
        InputType input = new InputType(enterPhrase);
        int number = Integer.parseInt(input.getValidatedInput());
        if(number < 2) 
            throw new InputException("Number must be larger than 1");
        nNumber = number;
        return true;
    }
    
    /**
     * function detecting prime nubers under n
     * @return primeNumbersList Integer List of detected prime numbers
     */
    public List<Integer> detectPrimeNumbersUnderN()
    {
        if(detectedPrimesHistory == null)
            detectedPrimesHistory = new ArrayList<>();
        isPrime = new ArrayList<>(Collections.nCopies(nNumber + 1, true));
        sieveOfEratosthenes();
        List<Integer> primeNumbersList = IntStream.range(0, isPrime.size())
                .filter(i -> isPrime.get(i))
                .boxed()
                .collect(Collectors.toList());
        if(primeNumbersList.size() > detectedPrimesHistory.size())
            detectedPrimesHistory = primeNumbersList;
        return primeNumbersList;
    }
    
    /**
    *function that checks if number is prime or not
    *Information is saved in boolean array
    */
    private void sieveOfEratosthenes()
    {
        //lambda operation interface implementation
        StreamsOperation sievePrimesIteration = (p, size) -> {
            IntStream
                .iterate(p * p, i -> i < size, i -> i + p)
                .forEach(i -> isPrime.set(i, false));
        };
        
        isPrime.set(0, false);
        isPrime.set(1, false);
        IntStream.range(2, isPrime.size())
                .filter(p -> isPrime.get(p))
                .forEach(p -> operateStream(p, isPrime.size(), sievePrimesIteration));
                        
        primeCounter = isPrime.stream()
                .filter(prime -> prime)
                .count();
    }
}