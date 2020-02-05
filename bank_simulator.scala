import scala.collection.mutable
import scala.util.Random

/*
  Filename: bank_simulator
Created: Siddhesh Salvi
  Change history: 5.2.2020 / Siddhesh Salvi

4. Simulate Banking Cash Counter
a.Desc -> Create a Program which creates Banking Cash Counter where people
  come in to deposit Cash and withdraw Cash.Have an input panel to add people
to Queue to either deposit or withdraw money and dequeue the people.Maintain
the Cash Balance.
  b.I / P -> Panel to add People to Queue to Deposit or Withdraw Money and dequeue
c.Logic -> Write a Queue Class to enqueue and dequeue people to either deposit
  or withdraw money and maintain the cash balance
*/


object bank_simulator {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        var str = ""
        var money: Long = 10000
        var remov = 0
        print("Enter bank approx daily bank customers : ")
        var limit: Int = scala.io.StdIn.readInt()
        var transaction_money: Long = 70000

        var adder = Random.nextInt(limit)
        var taker = Random.nextInt(limit)

        print("adder : " + adder + " taker : " + taker)

        var ad_q = mutable.Queue[Long]()
        for (i <- 1 to adder) {
          ad_q.enqueue(Random.nextLong(transaction_money))
        }
        print("\nPeople who want to deposit money : " + ad_q)

        var take_q = mutable.Queue[Long]()
        for (i <- 1 to taker) {
          take_q.enqueue(Random.nextLong(transaction_money))
        }
        print("\nPeople who want to withdraw money : " + take_q)

        var flag1 = true
        while (flag1) {
          str = ""
          str += "Money is : " + money
          if (!ad_q.isEmpty) {
            str += " + " + ad_q.front
            money += ad_q.front
            ad_q.dequeue()

          }
          if (!take_q.isEmpty && money >= take_q.front) {
            str += " - " + take_q.front
            money -= take_q.front
            str += " = " + money
            take_q.dequeue()
          }
          if (ad_q.isEmpty && !take_q.isEmpty) {
            print("\n" + take_q.front + " is removed due to low balence :" + money)
            take_q.dequeue()
            remov += 1
          }
          if (ad_q.isEmpty && take_q.isEmpty) {
            flag1 = false
          }
          print("\n" + str)
        }
        str = "Finally out of " + adder + " adders and " + taker + " takers there are " + ad_q.length + " depositers and removed takers " + remov + " in queue and balence money is " + money
        print("\n" + str)

        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }
} 