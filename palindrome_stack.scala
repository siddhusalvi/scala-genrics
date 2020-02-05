import java.lang.Math.sqrt

import scala.collection.mutable

/*
Filename: anagram_stack
Created: Siddhesh Salvi
Change history:5.2.2020 / Siddhesh Salvi

10. Add the Prime Numbers that are Anagram in the Range of 0 - 1000 in a Stack using
the Linked List and Print the Anagrams in the Reverse Order.
*/


object palindrome_stack {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        var min = 0
        var max = 100000
        var stk = mutable.Stack[Int]()
        for (i <- min to max) {
          if (isPrime(i) && isPalindrome(i.toString.toCharArray)) {
            stk.push(i)
          }
        }
        while (!stk.isEmpty) {
          print(stk.top + " ")
          stk.pop()
        }

        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
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

  def isPalindrome(word: Array[Char]): Boolean = {
    var left = 0
    var right = word.length - 1
    while (left < right) {
      if (word(left).asDigit != word(right).asDigit) {
        return false
      }
      left += 1
      right -= 1
    }
    true
  }
} 