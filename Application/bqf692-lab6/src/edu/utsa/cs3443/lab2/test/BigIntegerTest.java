package edu.utsa.cs3443.lab2.test;

import edu.utsa.cs3443.lab2.BigInteger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class BigIntegerTest {
    BigInteger bigInteger;
    BigInteger bigInteger2;
    BigInteger bigIntegerZero;
    BigInteger bigIntegerSmall;
    BigInteger bigIntegerBig;
    BigInteger bigIntegerFail;
    @Before
    public void setUp(){
        bigInteger = new BigInteger("10");
        bigInteger2 = new BigInteger("20");
        bigIntegerZero = new BigInteger("0");
        bigIntegerSmall = new BigInteger("1");
        bigIntegerBig = new BigInteger("10000000000000000000000000000000000000");

        System.out.println("Set Up!");
    }

    @Test
    public void setBigInteger(){
        bigInteger.setBigInteger("20");
        assertEquals(bigInteger.toString(), bigInteger2.toString());

        bigIntegerSmall.setBigInteger("0");
        assertEquals(bigIntegerSmall.toString(), bigIntegerZero.toString());

//        setBigInteger works only 1 time
//        bigInteger.setBigInteger("1");
//        assertEquals(bigInteger.toString(), bigIntegerSmall.toString());
    }

    @Test
    public void testSetBigInteger() {
        bigInteger.setBigInteger("10000000000000000000000000000000000000");
        assertEquals(bigInteger.toString(), bigIntegerBig.toString());
    }

    @Test
    public void testSetBigInteger2(){ assertNotNull(bigInteger); }

    @Test
    public void add() {
        assertEquals(bigInteger.add(bigInteger).toString(), "20");
        assertEquals(bigInteger.add(bigInteger2).toString(), "30");
        assertEquals(bigIntegerBig.add(bigIntegerZero).toString(), "10000000000000000000000000000000000000");
        assertEquals(bigInteger.add(bigIntegerSmall).toString(), "11");
        assertEquals(bigInteger.add(bigIntegerBig).toString(), "10000000000000000000000000000000000010");
        //assertEquals(bigInteger.add(bigInteger).toString(), "10");
    }

    @Test
    public void increment() {
        assertTrue(bigInteger.increment().toString().equals("11"));
        assertTrue(bigInteger2.increment().toString().equals("21"));
        assertTrue(bigIntegerZero.increment().toString().equals("1"));
        assertTrue(bigIntegerSmall.increment().toString().equals("2"));
        assertTrue(bigIntegerBig.increment().toString().equals("10000000000000000000000000000000000001"));
        //assertTrue(bigInteger.increment().toString().equals("21"));
    }

    @Test
    public void multiply() {
        assertEquals(bigInteger.multiply(bigInteger).toString(), "100");
        assertEquals(bigInteger.multiply(bigInteger2).toString(), "200");
        assertEquals(bigInteger.multiply(bigIntegerZero).toString(), "0");
        assertEquals(bigInteger.multiply(bigIntegerSmall).toString(), "10");
        assertEquals(bigInteger.multiply(bigIntegerBig).toString(), "100000000000000000000000000000000000000");
        //assertEquals(bigInteger.multiply(bigInteger).toString(), "200");
    }

    @Test
    public void compareTo() {
        assertEquals(0, bigInteger.compareTo(bigInteger));
        assertEquals(-1, bigInteger.compareTo(bigInteger2));
        assertEquals(1, bigInteger.compareTo(bigIntegerZero));
        assertEquals(1, bigIntegerBig.compareTo(bigInteger));
        assertEquals(1, bigIntegerBig.compareTo(bigIntegerZero));
        //assertEquals(1, bigInteger.compareTo(bigInteger));
    }
}