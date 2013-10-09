package com.goviridian.exams.fibonacci;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-test.xml")
public class FibonacciAPIComplementaryTest {

	/**
	 * The Subject Under Test.
	 */
	@Autowired
	IFibonacciApi fibonacciApi;

    private List<Long> expectedSequence;

    @Before
    public void setup(){
        expectedSequence = new ArrayList<Long>();
    }

    @Test
   	public void test_1StartingFrom_1Term() {
        expectedSequence.add(1l);
   		List<Long> sequence = fibonacciApi.generateSequence(1, 1);

   		Assert.assertEquals(expectedSequence, sequence);
   	}

    @Test
   	public void test_10StartingFrom_1Term() {
        expectedSequence.add(89l);
   		List<Long> sequence = fibonacciApi.generateSequence(10l, 1);

   		Assert.assertEquals(expectedSequence, sequence);
   	}

    @Test
   	public void test50StartingFrom_1Term() {
        expectedSequence.add(20365011074l);
   		List<Long> sequence = fibonacciApi.generateSequence(50l, 1);

   		Assert.assertEquals(expectedSequence, sequence);
   	}

    @Test
   	public void test92StartingFrom_1Term() {
        expectedSequence.add(7540113804746346429l);
   		List<Long> sequence = fibonacciApi.generateSequence(91l, 1);

   		Assert.assertEquals(expectedSequence, sequence);
   	}

    @Test(expected = RuntimeException.class)
   	public void test100StartingFrom_1Term() {
   		List<Long> sequence = fibonacciApi.generateSequence(100l, 1);
   		Assert.assertEquals(expectedSequence, sequence);
   	}
	@Test
	public void test5StartingFrom_10Terms() {
        expectedSequence.add(8l);
        expectedSequence.add(13l);
        expectedSequence.add(21l);
        expectedSequence.add(34l);
        expectedSequence.add(55l);
        expectedSequence.add(89l);
        expectedSequence.add(144l);
        expectedSequence.add(233l);
        expectedSequence.add(377l);
        expectedSequence.add(610l);
		List<Long> sequence = fibonacciApi.generateSequence(5, 10);

        Assert.assertEquals(expectedSequence, sequence);
	}

    @Test
    public void test90StartingFrom_2Terms() {
        expectedSequence.add(4660046610375530309l);
        expectedSequence.add(7540113804746346429l);
        List<Long> sequence = fibonacciApi.generateSequence(90l, 2);
        Assert.assertEquals(expectedSequence, sequence);
    }

}

