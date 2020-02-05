/*
Filename: balenced_equation
Created: Siddhesh Salvi
Change history:5.2.2020 / Siddhesh Salvi

3. Simple Balanced Parentheses
a. Desc -> Take an Arithmetic Expression such as
(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) where parentheses are used to order the
performance of operations. Ensure parentheses must appear in a balanced
fashion.
b. I/P -> read in Arithmetic Expression such as (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)
c. Logic -> Write a Stack Class to push open parenthesis “(“ and pop closed
parenthesis “)”. At the End of the Expression if the Stack is Empty then the
Arithmetic Expression is Balanced. Stack Class Methods are Stack(), push(),
pop(), peak(), isEmpty(), size()
d. O/P -> True or False to Show Arithmetic Expression is balanced or not.
*/

import scala.collection.mutable

object balenced_equation {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        print("Enter the equation : ")
        var word = scala.io.StdIn.readLine()
        val eq = word.toCharArray
        print(checkEquation(eq))
        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }

  //Function to check equation
  def checkEquation(data: Array[Char]): Boolean = {
    var flag = true
    var i: Int = 0
    var stk = mutable.Stack[Char]()
    while (flag && i < data.length) {
      var t: Int = data(i).toInt
      if (t == '{'.toInt || t == '('.toInt || t == '['.toInt) {
        stk.push(data(i))
      } else if (t == '}'.toInt || t == ')'.toInt || t == ']'.toInt) {
        if (stk.isEmpty) {
          flag = false
        } else if (checkPrev(t, stk)) {
          stk.pop()
        } else {
          flag = false
        }
      }
      i += 1
    }
    if (flag && stk.isEmpty) {
      true
    } else {
      false
    }
  }

  //Function to check top sign on stack and
  def checkPrev(ch: Int, stk: mutable.Stack[Char]): Boolean = {
    if (stk.top.toInt == '{'.toInt && '}'.toInt == ch) {
      true
    } else if (stk.top.toInt == '('.toInt && ')'.toInt == ch) {
      true
    } else if (stk.top.toInt == '['.toInt && ']'.toInt == ch) {
      true
    } else {
      false
    }
  }
}