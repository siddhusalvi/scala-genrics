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


object ordered_list{
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        var file = "/home/admin1/IdeaProjects/genrics/src/main/scala/words.csv"
        var data = Source.fromFile(file)
        var sentence : String = ""
        for(line <- data.getLines){
          sentence += line
        }
        var st =sentence.replace(","," ")
        var words = st.split(" ")
        var lsbffer = new ListBuffer[Int]()
        for(i <- words){
          lsbffer += i.toInt
        }
        lsbffer = lsbffer.sorted
        print("\nList is " + lsbffer.toList)
        print("\nEnter a number to search in a list : ")
        var num = scala.io.StdIn.readInt()
        if(lsbffer.contains(num)){
          print("number is found in the list.")
        }else{
          print("number is not found in the list\n adding number to list .")
          lsbffer += num
          lsbffer = lsbffer.sorted
          print("\nList is " + lsbffer.toList)
        }
        flag = false
      }
      catch{
        case _=>print("Something went wrong Error occurred.")
      }
    }
  }
}