package com.goviridian.exams.fibonacci.matrix;

import com.goviridian.exams.fibonacci.IFibonacciApi;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciApiMatrixImpl implements IFibonacciApi {

    //fibonacci matrix with initial values
    private static BigInteger[] fibMatrix = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};


    /**
     * Generates fibonacci sequence using matrix method.
     * <p/>
     * 1 1 ^n  [F(n+1) F(n)  ]
     * 1 0   = [F(n)   F(n-1)]
     *
     * @param startingFrom  the initial term (zero-based).
     * @param numberOfTerms the number of terms the generated sequence must have (i.e., sequence length).
     * @return list of fibonacci sequence terms
     */
    @Override
    public List<Long> generateSequence(long startingFrom, long numberOfTerms) {
        List<Long> result = new ArrayList<Long>();

        //add first term to result list
        BigInteger[] matrix1 = pow(fibMatrix, startingFrom);
        long term1 = getSimpleValue(matrix1);
        if (numberOfTerms > 0) {
            result.add(term1);
        }

        if (numberOfTerms > 1) {
            //add other terms to result list
            long term2 = getSimpleValue(multiply(matrix1, fibMatrix));
            result.add(term2);

            while (result.size() < numberOfTerms) {
                long newTerm = term1 + term2;
                result.add(newTerm);
                term1 = term2;
                term2 = newTerm;
            }
        }

        return result;
    }

    /**
     * Calculates the power of a matrix using exponentiation by squaring method
     * (a^n+1 = a^n * a)
     *
     * @param matrix base
     * @param n      previous fibonacci term
     * @return result matrix
     */
    private BigInteger[] pow(BigInteger[] matrix, long n) {
        BigInteger[] result = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE};
        while (n != 0) {
            if (n % 2 != 0)
                result = multiply(result, matrix);
            n /= 2;
            matrix = multiply(matrix, matrix);
        }
        return result;
    }

    /**
     * Multiplies 2 matrices
     */
    private BigInteger[] multiply(BigInteger[] x, BigInteger[] y) {
        return new BigInteger[]{
                x[0].multiply(y[0]).add(x[1].multiply(y[2])),
                x[0].multiply(y[1]).add(x[1].multiply(y[3])),
                x[2].multiply(y[0]).add(x[3].multiply(y[2])),
                x[2].multiply(y[1]).add(x[3].multiply(y[3]))
        };
    }

    /**
     * Get simple value from a matrix
     * @throws RuntimeException if the result is greather than max allowed value
     */
    private Long getSimpleValue(BigInteger[] matrix) throws RuntimeException{
        BigInteger integer = matrix[0];
        BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);
        if (integer.compareTo(maxLong)==1){
            throw new RuntimeException("The result is too big and it's not supported. Pleasy try again with smaller parameters");
        }

        return integer.longValue();
    }

}
