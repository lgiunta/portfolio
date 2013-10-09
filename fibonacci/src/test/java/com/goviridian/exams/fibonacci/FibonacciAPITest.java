package com.goviridian.exams.fibonacci;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * FibonacciAPITest
 * @author Nicol�s L. Di Benedetto
 * @version ($Revision$)
 * @date 05/10/2012
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-test.xml")
public class FibonacciAPITest {

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Fields ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	/**
	 * The Subject Under Test.
	 */
	@Autowired
	IFibonacciApi sut;

	/**
	 * Initial sequence term.
	 */
	private static final int STARTING_TERM = 0;

	/**
	 * Number of terms in expected sequence.
	 */
	private static final short TERMS = 9;

	/**
	 * Expected sequence.
	 */
	private List<Long> expectedSequence = new ArrayList<Long>(FibonacciAPITest.TERMS) {
		{
			this.add(0L);
			this.add(1L);
			this.add(1L);
			this.add(2L);
			this.add(3L);
			this.add(5L);
			this.add(8L);
			this.add(13L);
			this.add(21L);
		}
	};

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/**
	 * Default constructor.
	 */
	public FibonacciAPITest() {}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {}

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Business Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	@Test
	public void shouldGenerateSequence() {
		// GIVEN
		IFibonacciApi fibonacci = this.sut;

		// WHEN
		List<Long> sequence = fibonacci.generateSequence(FibonacciAPITest.STARTING_TERM, FibonacciAPITest.TERMS);

		// THEN
		Assert.assertTrue(sequence.containsAll(this.expectedSequence));
		Assert.assertTrue(this.expectedSequence.containsAll(sequence));
	}

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters & Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

}

