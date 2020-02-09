/*
Filename: palindrome_dequeue
Created: Siddhesh Salvi
Change history:9.2.2020 / Siddhesh Salvi

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

object palindrome_dequeue {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        var dQ: Dequeue = new Dequeue()
        print("Enter a word to check it is palindrome or not : ")
        var word = scala.io.StdIn.readLine()
        var word2 = ""
        var letters = word.toCharArray
        for (i <- letters) {
          dQ.addEnd(i)
        }
        for (i <- letters) {
          word2 += dQ.peekRear().toString
          dQ.removeRear()
        }
        print("word is : " + word + " reverse is : " + word2)
        if (word.equals(word2)) {
          print(" Word is palindrome")
        } else {
          print(" Word is not palindrome")
        }
        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }

  class Dequeue {

    var len = 0
    var rear: Node = null
    var front: Node = null

    // to check queue is not empty or not
    def isNotEmpty: Boolean = {
      if (isEmpty) {
        false
      } else {
        true
      }
    }

    //function to add data at end
    def addEnd(letter: Char): Unit = {
      if (isEmpty) {
        addFront(letter)
      } else {
        var temp: Node = new Node(letter)
        temp.prev = this.rear
        this.rear.next = temp
        this.rear = temp
        this.len += 1
      }

    }

    //function to add data at front
    def addFront(letter: Char): Unit = {
      var temp: Node = new Node(letter)
      if (isEmpty) {
        this.front = temp
        this.rear = temp
      } else {
        temp.next = this.front
        front.prev = temp
        this.front = temp
      }
      this.len += 1
    }

    //Function to delete data from end
    def removeRear(): Unit = {
      if (isEmpty) {
        print("queue is empty can't remove elements. ")
      } else if (size < 2) {
        removeFront()
      } else {
        this.rear = rear.prev
        this.rear.next = null
        this.len -= 1
      }
    }

    //function to delete data at front
    def removeFront(): Unit = {
      if (isEmpty) {
        print("Not possible to remove list is empty")
      } else {
        if (size == 1) {
          this.front = null
          this.rear = null
        } else {
          this.front = front.next
          front.prev = null
        }
        this.len -= 1
      }
    }

    //to check queue is empty or not
    def isEmpty: Boolean = {
      if (this.len == 0) {
        true
      } else {
        false
      }

    }

    def size: Int = {
      this.len
    }

    //Function to display dequeue
    def display(): Unit = {
      if (isEmpty) {
        print("List is empty")
      } else {
        var temp: Node = this.front
        while (temp != null) {
          print(temp.letter + " ")
          temp = temp.next
        }
      }

    }

    //function to peek end element
    def peekRear(): Char = {
      if (isEmpty) {
        ' '
      } else if (size == 1) {
        peekFront()
      } else {
        rear.letter
      }
    }

    //function to peek front element
    def peekFront(): Char = {
      if (isEmpty) {
        ' '
      } else {
        front.letter
      }
    }

    class Node {
      var letter: Char = ' '
      var prev: Node = _
      var next: Node = _

      def this(letter: Char) {
        this()
        this.letter = letter
      }
    }


  }
}
