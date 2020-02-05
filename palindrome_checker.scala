/*
Filename: palindrome_checker
Created: Siddhesh Salvi
Change history:5.2.2020 / Siddhesh Salvi

5. Palindrome-Checker
a. Desc -> A palindrome is a string that reads the same forward and backward, for
example, radar, toot, and madam. We would like to construct an algorithm to
input a string of characters and check whether it is a palindrome.
b. I/P -> Take a String as an Input
c. Logic -> The solution to this problem will use a deque to store the characters of
the string. We will process the string from left to right and add each character to
the rear of the deque.
d. O/P -> True or False to Show if the String is Palindrome or not.
*/

import scala.collection.mutable

object palindrome_checker {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        print("Enter a word to check palindrome : ")
        var word = scala.io.StdIn.readLine()
        var chrs = word.toCharArray
        var dq = mutable.ArrayDeque[Char]()
        for (i <- chrs) {
          dq += i
        }
        var str = ""
        while (!dq.isEmpty) {
          str += dq.last.toString
          dq.removeLast()
        }
        if (str.equals(word)) {
          print(word + " is palinodrome. ")
        } else {
          print(word + " is not palinodrome. ")
        }


        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }
} 