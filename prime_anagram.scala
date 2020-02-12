import java.lang.Math.sqrt

import scala.util.Sorting.quickSort

/*
Filename: prime_anagram
Created: Siddhesh Salvi
Change history:12.2.2020 / Siddhesh Salvi
9. Extend the Prime Number Program and store only the numbers in that range that are
Anagrams. For e.g. 17 and 71 are both Prime and Anagrams in the 0 to 1000 range.
Further store in a 2D Array the numbers that are Anagram and numbers that are not
Anagram
*/


object prime_anagram{
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{

        print("Enter min of range : ")
        var min_start = scala.io.StdIn.readInt()
        print("Enter min of range : ")
        var max_end = scala.io.StdIn.readInt()

        if(min_start < max_end){
          var prime_count:Int = getPrimeCount(min_start, max_end)
          if(prime_count < 2 ){
            print("there is 0 or single prime number in this range.\n")
          }else {
            var prime_List: Array[Int] = new Array[Int](prime_count)
            var temp_index: Int = 0
            for (num <- min_start to max_end) {
              if (isPrime(num)) {
                prime_List(temp_index) = num
                temp_index += 1
              }
            }
            var two_d_size :Int = 0
            var record:L_list = new L_list()
            for (num <- 0 until prime_List.length - 1) {
              for (num_next <- num + 1 until prime_List.length) {
                if (areAnagram(prime_List(num).toString, prime_List(num_next).toString)) {
                  two_d_size += 1
                  record.add(prime_List(num))
                  record.add(prime_List(num_next))
                }
              }
              }
              var two_d_data = Array.ofDim[Int](two_d_size,2)
            var two_d_index:Int = 0
            for (num <- 0 until prime_List.length - 1) {
              for (num_next <- num + 1 until prime_List.length) {
                if (areAnagram(prime_List(num).toString, prime_List(num_next).toString) && two_d_index < two_d_size) {
                    two_d_data(two_d_index)(0) = prime_List(num)
                    two_d_data(two_d_index)(1) = prime_List(num_next)
                  two_d_index +=1
                }
              }
            }
            for(row <-0 until two_d_size){
              for(col <- 0 to 1){
                print(two_d_data(row)(col)+" ")
              }
              println()
            }
            println("There are total "+record.length+" anagrams in the list")
            flag = false
          }
        }else{
          print("please enter valid Input : \n")
        }

      }
      catch{
        case _=>print("Something went wrong Error occurred.")
      }
    }
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
  //Function to get total prime number count
  def getPrimeCount(start:Int , end:Int):Int={
    var count  = 0
    for(num <- start to end){
      if(isPrime(num)){
        count += 1
      }
    }
    count
  }
  //function to check anagram
  def areAnagram(word1: String, word2: String):Boolean ={
    if(word1.length() != word2.length()){
      false
    }else{
      var dta1 = word1.toCharArray()
      quickSort(dta1)
      var dta2 = word2.toCharArray()
      quickSort(dta2)
      for(index <- 0 until dta1.length){
        if(dta1(index).asDigit != dta2(index).asDigit){
          return false
        }
      }
      true
    }
  }
  // Ordered linked list class
  class L_list {
    var max = 0
    var min = 0
    var length: Int = 0
    var head: Node = _

    //Function to get min
    def getMin: Int = {
      this.min
    }

    //Function to get max
    def getMax: Int = {
      this.max
    }

    // function to add data
    def add(num: Int): Unit = {
      var temp: Node = new Node(num)
      if (isEmpty) {
        this.head = temp
        this.min = num
        this.max = num
        this.length += 1
      } else {
        if (isNotEmpty() && !contains(num)) {

          if (num < this.min) {
            temp.next = head
            head = temp
            this.min = num
          } else if (num > this.max) {
            var temp1: Node = this.head
            while (temp1.next != null) {
              temp1 = temp1.next
              this.max = num
            }
            temp1.next = temp
            this.max = num
          } else {
            var prev: Node = null
            var temp1: Node = this.head
            while (temp1.next.data < num) {
              temp1 = temp1.next
            }
            temp.next = temp1.next
            temp1.next = temp
          }
          this.length += 1
        }
      }

    }
    //function to get first element in the list
    def top():Int={
      if(isNotEmpty()){
        return this.head.data
      }
     -1
    }

    //function to remove data from the list
    def delete(num: Int): Unit = {
      if (isEmpty) {
        print("List is empty can't delete data ")
      } else {
        if (contains(num)) {
          if (this.length == 1) {
            this.head = null
          } else if (num == this.min) {
            this.head = head.next
          } else if (num == this.max) {
            var temp: Node = this.head
            while (temp.next.data != num) {
              temp = temp.next
            }
            temp.next = null
          } else {
            var current: Node = this.head
            var prev: Node = null
            while (current.data != num) {
              prev = current
              current = current.next
            }
            prev.next = current.next
          }
          length -= 1
        } else {
          print("Number not found in the list can't delete data ")
        }
      }
    }

    //function to check number is present in the list
    def contains(num: Int): Boolean = {
      if (isEmpty) {
        false
      } else if (num < this.min && num > this.max) {
        false
      } else {
        var temp: Node = this.head
        while (temp != null) {
          if (temp.data == num) {
            return true
          }
          temp = temp.next
        }
        false
      }
    }

    //Function to print the list
    def display(): Unit = {
      if (isNotEmpty()) {
        var temp: Node = this.head
        while (temp != null) {
          print(temp.data + " ")
          temp = temp.next
        }
      } else {
        print("list is empty")
      }
    }

    //Function to convert linked list into an array
    def getDataInArray:Array[Int]={
      if(isNotEmpty()){
        var temp1:Array[Int] = new Array[Int](length)
        var index = 0
        var temp: Node = this.head
        while (temp != null && index < length) {
          temp1(index) = temp.data
          temp = temp.next
          index += 1}
        temp1
      }else{
        var temp:Array[Int] = new Array[Int](1)
        temp(0) = -1
        temp
      }
    }

    //function to check list is not empty or not
    def isNotEmpty(): Boolean = {
      if (this.isEmpty) return false
      true
    }

    //function to check list is empty or not
    def isEmpty: Boolean = {
      if (this.length == 0) {
        return true
      }
      false
    }

    //class Node to store data
    class Node {
      var data = 0
      var next: Node = _

      def this(num: Int) {
        this()
        this.data = num
      }
    }
  }
} 