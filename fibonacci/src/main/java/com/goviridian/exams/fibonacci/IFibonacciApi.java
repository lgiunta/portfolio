package com.goviridian.exams.fibonacci;

import java.util.List;

/**
 * IFibonacciApi Main API for the Fibonacci Sequence Generator.
 * @author Nicol�s L. Di Benedetto
 * @version ($Revision$)
 * @date 05/10/2012
 */
public interface IFibonacciApi {

	/**
	 * Generates a portion of the Fibonacci sequence of the given number of terms starting from the initial term.
	 * @param startingFrom the initial term (zero-based).
	 * @param numberOfTerms the number of terms the generated sequence must have (i.e., sequence length).
	 * @return a sorted list of numbers that represent the portion of the requested Fibonacci sequence.
	 */
	List<Long> generateSequence(long startingFrom, long numberOfTerms);

}

