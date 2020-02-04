/*
Filename: linked_list
Created: Siddhesh Salvi
Change history:4.2.2020 / Siddhesh Salvi

1. List
a. Desc -> Read the Text from a file, split it into words and arrange it as Linked List.
Take a user input to search a Word in the List. If the Word is not found then add it
to the list, and if it found then remove the word from the List. In the end save the
list into a file
b. I/P -> Read from file the list of Words and take user input to search a Text
c. Logic -> Create a Unordered Linked List. The Basic Building Block is the Node
Object. Each node object must hold at least two pieces of information. One ref to
the data field and second the ref to the next node object.
d. O/P -> The List of Words to a File.

*/
import java.io.FileWriter
import scala.collection.mutable.ListBuffer
import scala.io.Source
object linked_list{
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
        var lsbffer = new ListBuffer[String]()
        for(i <- words){
          lsbffer += i
        }
        print("List is " + lsbffer.toList)

        print("\n Enter word to search in list : ")
        var word = scala.io.StdIn.readLine()
        if(lsbffer.contains(word)){
          print(word + " is found in the list deleting the list. ")
          lsbffer -= word
          var fw = new FileWriter("/home/admin1/IdeaProjects/genrics/src/main/scala/words.csv")
          for(i <- lsbffer)
          {fw.write(i+", ")}
          fw.close()
          print("\nafter deletion list is "+lsbffer.toList)

        }else{
          print(word + " is not found in the list. ")
        }
        flag = false
      }
      catch{
        case _=>print("Something went wrong Error occurred.")
      }
    }
  }
}