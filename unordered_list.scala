import scala.collection.mutable.ListBuffer
import scala.io.Source

/*
Filename: ordered_list
Created: Siddhesh Salvi
Change history:4.2.2020 / Siddhesh Salvi
2. Ordered List
a. Desc -> Read .a List of Numbers from a file and arrange it ascending Order in a
Linked List. Take user input for a number, if found then pop the number out of the
list else insert the number in appropriate position
b. I/P -> Read from file the list of Numbers and take user input for a new number
c. Logic -> Create a Ordered Linked List having Numbers in ascending order.
d. O/P -> The List of Numbers to a File.
*/


object unordered_list{

  def main(args: Array[String]): Unit = {
    var list: L_list = new L_list()

    var file = "/home/admin1/IdeaProjects/genrics/src/main/scala/words.csv"

    var data = Source.fromFile(file)
    var sentence: String = ""
    for (line <- data.getLines) {
      sentence += line
    }
    var st = sentence.replace(",", " ")
    var words = st.split(" ")
    for (i <- words) {
      list.add(i)
    }
    print("list is ")
    list.printl()
    print("\nEnter number to delete or add in a list from list : ")
    var word = scala.io.StdIn.readLine()
    if (list.contains(word)) {
      list.remove(word)
      print("after deletion number in list are : ")
      list.printl()
    } else {
      print("after adding number in list are : ")
      list.add(word)
      list.printl()
    }


  }

  //class Linked list
  class L_list {
    var count: Int = 0
    var head: Node = null

    //Function to add data
    def add(data: String): Unit = {
      var t: Node = new Node(data)
      if (this.isEmpty()) {
        this.head = t
      } else {
        var temp = head
        while (temp.next != null) {
          temp = temp.next
        }
        temp.next = t
      }
      count += 1
    }

    //Function to check list empty
    def isEmpty(): Boolean = {
      if (head == null) {
        return true
      }
      false
    }

    //Function to return length
    def length(): Int = {
      return this.count
    }

    //Function to print list
    def printl(): Unit = {
      if (isEmpty()) {
        println("List is empty")
      } else {
        var t: Node = head
        while (t != null) {
          print(t.data + " ")
          t = t.next
        }
      }
    }

    def remove(info: String): Unit = {
      if (contains(info)) {
        if (head.data.equals(info)) {
          head = head.next
        } else {
          var flag = true
          var t = head
          while (flag) {
            var pre: Node = t
            t = t.next
            if (t.next == null) {
              pre.next = null
              flag = false
            } else {
              if (t.data.equals(info)) {
                pre.next = t.next
                flag = false
              }
            }
          }
        }
        this.count -= 1
      } else {
        println("operation unsuccessful not present.")
      }
    }

    //Function to check data present in list
    def contains(info: String): Boolean = {
      if (this.isEmpty()) {
        return false
      }
      var t: Node = this.head
      while (t != null) {
        if (t.data.equals(info)) {
          return true
        }
        t = t.next
      }
      false
    }
    //Class node
    class Node {
      var data = ""
      var next: Node = _
      def this(info: String) {
        this()
        this.data = info
      }
    }
  }
}