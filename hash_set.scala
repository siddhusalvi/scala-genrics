import scala.io.Source

/*
Filename: hash_set
Created: Siddhesh Salvi
Change history:5.2.2020 / Siddhesh Salvi

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


object hash_set {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        var file = "/home/admin1/IdeaProjects/genrics/src/main/scala/words.csv"
        var data = Source.fromFile(file)
        var sentence: String = ""
        for (line <- data.getLines) {
          sentence += line
        }
        var st = sentence.replace(",", " ")
        var words = st.split(" ")
        var st1 = words.toSet
        print("Set is : " + st1)
        print("\nEnter any value to search in set : ")
        var word = scala.io.StdIn.readLine()
        if (st1.contains(word)) {
          print(word + " found in set. ")
        } else {
          print(word + " not found in set. ")
        }

        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }
} 