/*
Filename: binary_trees
Created: Siddhesh Salvi
Change history:6.2.2020 / Siddhesh Salvi

7. Number of Binary Search Tree
Solve the Problem in the following link
https://www.hackerrank.com/challenges/number-of-binary-search-tree.
*/

object binary_trees {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        print("Enter a number to find its Binary search tree : ")
        var num = scala.io.StdIn.readInt()
        print("total Possible combimations are : " + catlan(num))
        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }
  //Function to calculate catlan no
  def catlan(num: Int): Int = {
    var c = binomialCoeff(2 * num, num)
    c / (num + 1)
  }
  //Function to calculate binomial coeff
  def binomialCoeff(num: Int, kk: Int): Int = {
    var res = 1
    var k = kk
    if (k > num - k) {
      k = num - k
    }
    for (i <- 0 until k) {
      res *= num - i
      res /= i + 1
    }
    res
  }
  //Function to calculate factorial
  def getFactorial(num: Int): Int = {
    var ans = 1
    for (i <- 1 to num) {
      ans *= i
    }
    ans
  }
} 