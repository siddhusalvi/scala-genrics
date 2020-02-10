import scala.io.Source

/*
Filename: hashing_function
Created: Siddhesh Salvi
Change history:10.2.2020 / Siddhesh Salvi

6. Hashing Function to search a Number in a slot
a. Desc -> Create a Slot of 10 to store Chain of Numbers that belong to each Slot to
efficiently search a number from a given set of number
b. I/P -> read a set of numbers from a file and take user input to search a number
c. Logic -> Firstly store the numbers in the Slot. Since there are 10 Numbers divide
each number by 11 and the reminder put in the appropriate slot. Create a Chain
for each Slot to avoid Collision. If a number searched is found then pop it or else
push it. Use Map of Slot Numbers and Ordered LinkedList to solve the problem.
In the Figure Below, you can see number 77/11 reminder is 0 hence sits in the 0
slot while 26/11 remainder is 4 hence sits in slot 4
d. O/P -> Save the numbers in a file
*/


object hashing_function {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {

      try {
        var file = "/home/admin1/IdeaProjects/genrics/src/main/scala/words.csv"
        val data = Source.fromFile(file)
        var sentence: String = ""
        for (line <- data.getLines) {
          sentence += line
        }
        var letter = sentence.replace(",", " ")
        var numbers = letter.split(" ")

        var letters = Array[Int](numbers.length)
        for (i <- 0 until numbers.length) {
          var num = numbers(i).toInt

        }

        var numberMap: Array[L_list] = new Array[L_list](11)

        for (i <- numberMap.indices) {
          numberMap(i) = new L_list()
        }

        for (i <- numbers.indices) {
          var num = numbers(i).toInt
          var index = num % 11
          numberMap(index).add(num)
        }

        print(" Slotwise numbers are : \n")
        for (i <- numberMap.indices) {
          print(i + " : ")
          numberMap(i).display()
          println()
        }
        print("\nEnter a Number to search : ")
        var num = scala.io.StdIn.readInt()
        if (numberMap(num % 11).contains(num)) {
          print("true")
        } else {
          print("false")
        }
        flag = false
        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }

    }
  }

  //class Linked list
  class L_list {
    var max = 0
    var min = 0
    var length: Int = 0
    var head: Node = null

    //Function to get min
    def getMin(): Int = {
      this.min
    }

    //Function to get max
    def getMax(): Int = {
      this.max
    }

    // function to add data
    def add(num: Int): Unit = {
      var temp: Node = new Node(num)
      if (isEmpty()) {
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

    //function to remove data from the list
    def delete(num: Int): Unit = {
      if (isEmpty()) {
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
      if (isEmpty()) {
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

    //Function to print list
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
    //function to check list is not empty or not
    def isNotEmpty(): Boolean = {
      if (this.isEmpty()) return false
      true
    }

    //function to check list is empty or not
    def isEmpty(): Boolean = {
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