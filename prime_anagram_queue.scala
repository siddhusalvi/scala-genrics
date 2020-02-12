import java.lang.Math.sqrt

import scala.util.Sorting.quickSort

/*
Filename: prime_anagram_queue
Created: Siddhesh Salvi
Change history:12.2.2020 / Siddhesh Salvi
11. Add the Prime Numbers that are Anagram in the Range of 0 - 1000 in a Queue using
the Linked List and Print the Anagrams from the Queue. Note no Collection Library
can be used.
*/
object prime_anagram_queue {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        var record = new Queue()
        print("Enter min of range : ")
        val min_start = scala.io.StdIn.readInt()
        print("Enter min of range : ")
        val max_end = scala.io.StdIn.readInt()

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
                  record.enqueue(prime_List(num))
                  record.enqueue(prime_List(num_next))
                }
              }
            }
            println("Prime numbers which are also anagrams :")
            record.display()
            flag = false
          }
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

  //class Queue for store data
  class Queue {
    var len: Int = 0
    var front: Node = _
    var rear: Node = _

    //Function to return length
    def size(): Int = {
      this.len
    }

    //Function to add data
    def enqueue(num: Int): Unit = {
      var temp: Node = new Node(num)
      if (isEmpty) {
        this.front = temp
        this.rear = temp
      } else {
        rear.next = temp
        temp.prev = rear
        rear = temp
      }
      len += 1
    }

    //Function to palindrome_dequeue data
    def dequeue(): Unit = {
      if (isNotEmpty) {
        if (this.len == 1) {
          this.front = null
          this.rear = null
        } else {
          this.front = front.next
          front.prev = null
        }
        len -= 1
      } else {
        print("Queue is empty")
      }
    }

    //Function to check queue is not empty
    def isNotEmpty: Boolean = {
      if (isEmpty) {
        false
      } else {
        true
      }
    }

    //Function to check queue is empty
    def isEmpty: Boolean = {
      if (this.len == 0) {
        true
      } else {
        false
      }
    }

    //function to get first data
    def peek(): Long = {
      if (isNotEmpty) {
        this.front.data
      } else {
        -1
      }

    }

    //Function to print data
    def display(): Unit = {
      if (isEmpty) {
        print("Queue is empty ")
      } else {
        var temp: Node = this.front
        while (temp != null) {
          print(temp.data + "\n")
          temp = temp.next
        }
      }
    }

    //class Node to store data and reference
    class Node {
      var data = 0
      var next: Node = _
      var prev: Node = _

      def this(given_data: Int) {
        this()
        this.data = given_data
      }
    }

  }

}