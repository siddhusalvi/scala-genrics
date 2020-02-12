import java.lang.Math.sqrt

import scala.util.Sorting.quickSort

/*
Filename: prime_anagram_stack
Created: Siddhesh Salvi
Change history:12.2.2020 / Siddhesh Salvi
10. Add the Prime Numbers that are Anagram in the Range of 0 - 1000 in a Stack using
the Linked List and Print the Anagrams in the Reverse Order. Note no Collection
Library can be used.
*/
object prime_anagram_stack {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        var record: Stack = new Stack()
        print("Enter min of range : ")
        var min_start = scala.io.StdIn.readInt()
        print("Enter min of range : ")
        var max_end = scala.io.StdIn.readInt()

        if (min_start < max_end) {
          var prime_count: Int = getPrimeCount(min_start, max_end)
          if (prime_count < 2) {
            print("there is 0 or single prime number in this range.\n")
          } else {
            var prime_List: Array[Int] = new Array[Int](prime_count)
            var temp_index: Int = 0
            for (num <- min_start to max_end) {
              if (isPrime(num)) {
                prime_List(temp_index) = num
                temp_index += 1
              }
            }
            for (num <- 0 until prime_List.length - 1) {
              for (num_next <- num + 1 until prime_List.length) {
                if (areAnagram(prime_List(num).toString, prime_List(num_next).toString)) {
                  record.push(prime_List(num))
                  record.push(prime_List(num_next))
                }
              }
            }
            println("Prime numbers which are also anagrams :")
            record.display()
          }
          flag = false
        }
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }

  //Function to get total prime number count
  def getPrimeCount(start: Int, end: Int): Int = {
    var count = 0
    for (num <- start to end) {
      if (isPrime(num)) {
        count += 1
      }
    }
    count
  }

  //Function to check prime number
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

  //function to check anagram
  def areAnagram(word1: String, word2: String): Boolean = {
    if (word1.length() != word2.length()) {
      false
    } else {
      var dta1 = word1.toCharArray
      quickSort(dta1)
      var dta2 = word2.toCharArray
      quickSort(dta2)
      for (index <- dta1.indices) {
        if (dta1(index).asDigit != dta2(index).asDigit) {
          return false
        }
      }
      true
    }
  }

  //Stack class to manage data
  class Stack {
    var head: Node = _
    var len: Int = 0

    // to check stack is not empty
    def isNotEmpty: Boolean = {
      if (isEmpty) {
        false
      } else {
        true
      }
    }

    // to check stack is empty or not
    def isEmpty: Boolean = {
      if (this.len == 0) {
        true
      } else {
        false
      }
    }

    //Function to add data in stack
    def push(num: Int): Unit = {
      var temp: Node = new Node(num)
      if (isEmpty) {
        this.head = temp
      } else {
        this.head.prev = temp
        temp.next = this.head
        this.head = temp
      }
      this.len += 1
    }

    //Function to display data
    def display(): Unit = {
      if (isEmpty) {
        print("stack is empty")
      } else {
        var temp: Node = this.head
        while (temp != null) {
          print(temp.data + "\n")
          temp = temp.next
        }
      }
    }

    //Function to delete the data
    def pop(): Unit = {
      if (isEmpty) {
        print("stack is empty")
      } else if (this.len == 1) {
        this.head = null
        this.len -= 1
      } else {
        this.head = this.head.next
        this.head.prev = null
        this.len -= 1
      }
    }


    //class to store the data
    class Node {
      var data = 0
      var next: Node = _
      var prev: Node = _

      def this(num: Int) {
        this()
        this.data = num
      }
    }
  }
} 