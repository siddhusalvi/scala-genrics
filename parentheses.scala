
object parentheses {
  def main(args: Array[String]): Unit = {
    var stk: Stack = new Stack()
    print("Enter the equation : ")
    var str = scala.io.StdIn.readLine()
    var eqn = str.toCharArray
    var close_flag = true
    var index = 0
    while (close_flag && index < eqn.length) {
      var char: Char = eqn(index)
      if (isBracket(char)) {
        if (isOpenBracket(char)) {
          stk.push(char.toString)
        } else {
          var prevStk = stk.top().charAt(0)
          if (checkPrevious(prevStk, char) && stk.isNotEmpty) {
            stk.pop
          } else {
            close_flag = false
          }
        }
      }
      index += 1
    }
    if (close_flag && stk.length % 2 == 0) {
      print(true)
    } else {
      print(false)
    }
  }
  //Function to check bracket charachters
  def isBracket(givenChar: Char): Boolean = {
    if (givenChar.toInt == '{'.toInt) {
      true
    } else if (givenChar.toInt == '('.toInt) {
      true
    } else if (givenChar.toInt == '['.toInt) {
      true
    } else if (givenChar.toInt == ']'.toInt) {
      true
    } else if (givenChar.toInt == '}'.toInt) {
      true
    } else if (givenChar.toInt == ')'.toInt) {
      true
    } else {
      false
    }
  }
//function to check opening bracket characters
  def isOpenBracket(c: Char): Boolean = {
    if (c.toInt == '{'.toInt) {
      true
    } else if (c.toInt == '['.toInt) {
      true
    } else if (c.toInt == '('.toInt) {
      true
    } else {
      false
    }
  }
//function to compare current and previous character
  def checkPrevious(char1: Char, char2: Char): Boolean = {
    if (char1.toInt == '('.toInt && char2.toInt == ')'.toInt) {
      true
    } else if (char1.toInt == '[' && char2.toInt == ']'.toInt) {
      true
    } else if (char1.toInt == '{' && char2.toInt == '}'.toInt) {
      true
    } else {
      false
    }
  }
  //Stack class to store data in stack
  class Stack {
    var size = 0
    var pos: Node = _

    //Function to return top
    def top(): String = {
      if (isNotEmpty) {
        return pos.data
      }
      " "
    }

    //Function to check whether stack is not empty
    def isNotEmpty: Boolean = {
      if (isEmpty) {
        false
      } else {
        true
      }
    }

    //Function to push the data into stack
    def push(info: String): Unit = {
      var temp = new Node(info)
      if (isEmpty) {
        pos = temp
      } else {
        pos.next = temp
        temp.prev = pos
        pos = temp
      }
      size += 1
    }

    //Function to delete the data from stack
    def pop(): Unit = {
      if (isEmpty) {
        print("Stack is empty.")
      } else {
        if (size == 1) {
          pos = null
        } else {
          var temp: Node = pos.prev
          pos = temp
        }
        size -= 1
      }
    }

    //Function to check whether stack is empty
    def isEmpty: Boolean = {
      if (size == 0) {
        return true
      }
      false
    }

    //Function to return length
    def length: Int = {
      this.size
    }

    //function to display stack
    def display(): Unit = {
      if (isEmpty) {
        print("Stack is Empty")
      } else {
        var temp: Node = pos
        while (temp != null) {
          print(temp.data + " ")
          temp = temp.prev
        }
      }
    }

    class Node {
      var data: String = ""
      var next: Node = _
      var prev: Node = _

      def this(data: String) {
        this()
        this.data = data
      }
    }

  }

}

