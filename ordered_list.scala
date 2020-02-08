
/*
Filename: ordered_list
Created: Siddhesh Salvi
Change history:8.2.2020 / Siddhesh Salvi

2. Ordered List
a. Desc -> Read .a List of Numbers from a file and arrange it ascending Order in a
Linked List. Take user input for a number, if found then pop the number out of the
list else insert the number in appropriate position
b. I/P -> Read from file the list of Numbers and take user input for a new number
c. Logic -> Create a Ordered Linked List having Numbers in ascending order.
d. O/P -> The List of Numbers to a File.
*/

import scala.io.Source
object ordered_list {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        var list: L_list = new L_list()

        var file = "/home/admin1/IdeaProjects/genrics/src/main/scala/words.csv"

        val data = Source.fromFile(file)
        var sentence: String = ""
        for (line <- data.getLines) {
          sentence += line
        }
        var st = sentence.replace(",", " ")
        var words = st.split(" ")
        for (i <- words) {
          list.add(i.toInt)
        }
        print("list is : ")
        list.display()
        print("\nEnter a number to add or delete from list : ")
        var num = scala.io.StdIn.readInt()
        if (list.contains(num)) {
          list.delete(num)
        } else {
          list.add(num)
        }
        print("After operation list is : ")
        list.display()
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
      } else {
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
      }
      this.length += 1
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

    //function to check list is empty or not
    def isEmpty(): Boolean = {
      if (this.length == 0) {
        return true
      }
      false
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