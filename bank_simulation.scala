import scala.util.Random

/*
Filename: bank_simulation
Created: Siddhesh Salvi
Change history:8.2.2020 / Siddhesh Salvi

4. Simulate Banking Cash Counter
a. Desc -> Create a Program which creates Banking Cash Counter where people
come in to deposit Cash and withdraw Cash. Have an input panel to add people
to Queue to either deposit or withdraw money and dequeue the people. Maintain
the Cash Balance.
b. I/P -> Panel to add People to Queue to Deposit or Withdraw Money and dequeue
c. Logic -> Write a Queue Class to enqueue and dequeue people to either deposit
or withdraw money and maintain the cash balance
d. O/P -> True or False to Show Arithmetic Expression is balanced or not.
*/


object bank_simulation {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {

        var removed_cus = 0
        var line: Queue = new Queue()
        var line2:Queue = new Queue()
        var str = ""
        var money: Long = 10000
        print("Enter bank approx daily bank customers : ")
        var limit: Int = scala.io.StdIn.readInt()
        var transaction_money: Long = 70000

        for(i <- 1 to limit){
          if(Random.nextInt(3)%2==0){
            line.enqueue(Random.nextLong(transaction_money))
          }else {
            line.enqueue(Random.nextLong(transaction_money) * -1)
          }
        }

        print("Customers who are waiting in queue : ")
        line.display()
        println()
        while (line.isNotEmpty ){
          if(line.peek()>0 || line.peek()*(-1)<=money)
          {
            print(money + " + " + line.peek())
            money += line.peek()
            println(" = " + money)
          }else{
            line2.enqueue(line.peek())
          }
          line.dequeue()
        }
        println("waiting customer who want to withdraw money : ")
        line2.display()
        println()
        while(line2.isNotEmpty){
          if(line2.peek()*(-1)<=money)
          {
            print(money + " + " + line2.peek())
            money += line2.peek()
            println(" = " + money)
            line2.dequeue()
          }else{
            line2.dequeue()
            removed_cus +=1
          }
        }
        println("Removed customers are "+removed_cus)







        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }

  //class Queue for queue management
  class Queue {
    var len: Int = 0
    var front: Node = _
    var rear: Node = _

    //Function to return length
    def size(): Int = {
      this.len
    }

    //Function to check queue is empty
    def isEmpty: Boolean = {
      if (this.len == 0) {
        true
      } else {
        false
      }
    }
    //Function to check queue is not empty
    def isNotEmpty:Boolean = {
      if(isEmpty){
        false
      }else{
        true
      }
    }
    //Function to add data
    def enqueue(money:Long): Unit ={
      var temp:Node = new Node(money)
      if(isEmpty){
        this.front = temp
        this.rear = temp
      }else{
        rear.next = temp
        temp.prev = rear
        rear = temp
      }
      len += 1
    }

    //Function to dequeue data
    def dequeue(): Unit ={
      if(isNotEmpty){
        if(this.len == 1){
          this.front = null
          this.rear = null
        }else{
          this.front = front.next
          front.prev = null
        }
        len -= 1
      }
    }
    def peek():Long={
      if(isNotEmpty){
        this.front.cash
      }else{
        0L
      }

    }


    //Function to print data
    def display(): Unit ={
      if(isEmpty){
        print("Queue is empty ")
      }else{
        var temp:Node = this.front
        while(temp != null){
          print(temp.cash+" ")
          temp = temp.next
        }
      }
    }

    class Node {
      var cash = 0L
      var next: Node = _
      var prev: Node = _

      def this(cash: Long) {
        this()
        this.cash = cash
      }


    }
  }
} 