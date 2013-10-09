package com.goviridian.exams.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * FibonacciApiDummyImpl
 * @author Nicol�s L. Di Benedetto
 * @version ($Revision$)
 * @date 05/10/2012
 */
public class FibonacciApiDummyImpl implements IFibonacciApi {

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Fields ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/**
	 * Default constructor.
	 */
	public FibonacciApiDummyImpl() {}

	/**
	 * @see com.goviridian.exams.fibonacci.IFibonacciApi#generateSequence(int, short)
	 */
	@Override
	public List<Long> generateSequence(final long startingFrom, final long numberOfTerms) {
		List<Long> dummySequence = new ArrayList<Long>();
		dummySequence.add(0L);
		dummySequence.add(1L);
		dummySequence.add(1L);
		dummySequence.add(2L);
		dummySequence.add(3L);
		dummySequence.add(5L);
		dummySequence.add(8L);
		dummySequence.add(13L);
		dummySequence.add(21L);
		return dummySequence;
	}

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Business Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters & Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

}

