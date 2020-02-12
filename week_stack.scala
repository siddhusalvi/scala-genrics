import java.time.YearMonth

/*
Filename: week_stack
Created: Siddhesh Salvi
Change history:12.2.2020 / Siddhesh Salvi
13.Create the Week Object having a list of WeekDay objects each storing the day (i.e
S,M,T,W,Th,..) and the Date (1,2,3..) . The WeekDay objects are stored in a Queue
implemented using Linked List. Further maintain also a Week Object in a Queue to
finally display the Calendar
Note - If a particular day has no date then the date is set as empty string and add it
to queue.
14. Modify the above program to store the Queue in two Stacks. Stack here is also
implemented using Linked List and not from Collection Library*/

object week_stack{
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        print("Enter a year : ")
        var year = scala.io.StdIn.readInt()
        print("Enter a month :")
        var dayDate:Queue = new Queue()
        var month = scala.io.StdIn.readInt()
        val ym = YearMonth.of(year, month)
        var days = ym.lengthOfMonth()

        for(day<-1 to days){
          var weekday =  ym.atDay(day).getDayOfWeek.name
          dayDate.enqueue(day,weekday)
        }
        dayDate.display()
        flag = false
      }
      catch{
        case _=>print("Something went wrong Error occurred.")
      }
    }
  }

  class Queue(){
    var dt:StackDate = new StackDate()
    var dy:StackDay = new StackDay()

    def enqueue(date:Int,day:String): Unit ={
      this.dt.push(date)
      this.dy.push(day)
    }

    def dequeue():Unit={
      this.dt.pop()
      this.dy.pop()
    }

    def display():Unit = {
      this.dt.display()
      this.dy.display()
    }
    //Stack class for date
    class StackDate {
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
    //Stack class for day
    class StackDay {
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
      def push(word: String): Unit = {
        var temp: Node = new Node(word)
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
        var data: String = _
        var next: Node = _
        var prev: Node = _

        def this(word: String) {
          this()
          this.data = word
        }
      }
    }
  }
} 