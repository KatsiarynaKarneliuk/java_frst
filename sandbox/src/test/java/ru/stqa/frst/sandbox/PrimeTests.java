package ru.stqa.frst.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 01.05.2016.
 */
public class PrimeTests {

  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

    @Test
  public void testNonPrime () {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }

  @Test
  public void testPrimeFast () {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE ));
  }

  @Test(enabled = false)
  public void testPrimeLong () {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }
  }