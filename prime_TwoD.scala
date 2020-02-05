/*
Filename: prime_TwoD
Created: Siddhesh Salvi
Change history:5.2.2020 / Siddhesh Salvi

8. Take a range of 0 - 1000 Numbers and find the Prime numbers in that range. Store
the prime numbers in a 2D Array, the first dimension represents the range 0-100,
100-200, and so on. While the second dimension represents the prime numbers in
that range

*/

import java.lang.Math.sqrt

object prime_TwoD {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        printPrimeMat()
        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }

  def printPrimeMat(): Unit = {
    var x = 10
    var y = 1
    var z = 100
    val mat = Array.ofDim[Int](x, y, z)
    for (i <- 0 until x) {
      for (j <- 0 until y) {
        for (k <- 0 until z) {
          if (isPrime((i) * 100 + (k + 1))) {
            mat(i)(j)(k) = (i) * 100 + (k + 1)
          }
        }
      }
    }
    for (i <- 0 until x) {
      println("\n" + ((i * 100) + 1) + "-" + (i + 1) * 100)
      for (j <- 0 until y) {
        for (k <- 0 until z) {
          if (mat(i)(j)(k) != 0) {
            print(mat(i)(j)(k) + " ")
          }
        }
      }
    }
  }

  def prime_range(min: Int, max: Int): Unit = {
    print("Prime numbers between " + min + " and " + max + " : ")
    for (i <- min to max) {
      if (isPrime(i)) {
        print(i + " ")
      }
    }
  }

  def isPrime(num: Int): Boolean = {
    if (num < 2) {
      false
    } else if (num < 4) {
      true
    } else {
      for (i <- 2 to sqrt(num).toInt) {
        if (num % i == 0) {
          return false
        }
      }
      true
    }
  }
} 