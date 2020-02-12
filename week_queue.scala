import java.time.YearMonth

/*
Filename: week_queue
Created: Siddhesh Salvi
Change history:12.2.2020 / Siddhesh Salvi
13.Create the Week Object having a list of WeekDay objects each storing the day (i.e
S,M,T,W,Th,..) and the Date (1,2,3..) . The WeekDay objects are stored in a Queue
implemented using Linked List. Further maintain also a Week Object in a Queue to
finally display the Calendar
Note - If a particular day has no date then the date is set as empty string and add it
to queue.
*/

object week_queue {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        print("Enter a year : ")
        var year = scala.io.StdIn.readInt()

        print("Enter a month :")
        var month = scala.io.StdIn.readInt()
        val ym = YearMonth.of(year, month)
        val firstDay = ym.atDay(1).getDayOfWeek.name
        var days = ym.lengthOfMonth()
        var start_day = getWeekToInt(firstDay)
        var weeks: Array[Week] = new Array[Week](6)
        for (i <- weeks.indices) {
          weeks(i) = new Week()
        }
        var temp = 1
        var day_count = 1
        for (index <- weeks.indices) {
          var weekArr: Array[Int] = new Array[Int](7)
          for (day <- 0 until 7) {
            if (temp < start_day) {
              temp += 1
              weekArr(day) = 0
            } else {
              if (day_count <= days) {
                weekArr(day) = day_count
                day_count += 1
              } else {
                weekArr(day) = 0
              }
            }
          }
          weeks(index).add(weekArr)
          weeks(index).display()
          flag = false
        }
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }

  //Function to convert String day to week day
  def getWeekToInt(day: String): Int = {
    if (day.equals("SUNDAY")) {
      1
    } else if (day.equals("MONDAY")) {
      2
    } else if (day.equals("TUESDAY")) {
      3
    } else if (day.equals("WEDNESDAY")) {
      4
    } else if (day.equals("THURSDAY")) {
      5
    } else if (day.equals("FRIDAY")) {
      6
    } else if (day.equals("SATURDAY")) {
      7
    } else {
      -1
    }
  }

  //week class to store week
  class Week {

    var sunday: Node = new Node()
    var monday: Node = new Node()
    var tuesday: Node = new Node()
    var wednesday: Node = new Node()
    var thursday: Node = new Node()
    var friday: Node = new Node()
    var saturday: Node = new Node()

    //Function to add data week
    def add(data: Array[Int]) {
      if (data.length == 7) {
        this.sunday.date = data(0)
        if (sunday.date != 0) {
          sunday.day = "sunday"
        }
        this.monday.date = data(1)
        if (monday.date != 0) {
          monday.day = "monday"
        }
        this.tuesday.date = data(2)
        if (tuesday.date != 0) {
          tuesday.day = "tuesday"
        }
        this.wednesday.date = data(3)
        if (wednesday.date != 0) {
          wednesday.day = "wednesday"
        }
        this.thursday.date = data(4)
        if (thursday.date != 0) {
          thursday.day = "thursday"
        }
        this.friday.date = data(5)
        if (friday.date != 0) {
          friday.day = "sunday"
        }
        this.saturday.date = data(6)
        if (saturday.date != 0) {
          saturday.day = "sunday"
        }
      } else {
        print("Array is not valid")
      }
    }

    //Function to print week
    def display(): Unit = {
      var note = ""
      note += this.sunday.date + " " + this.sunday.day + "      "
      note += this.monday.date + " " + this.monday.day + "      "
      note += this.tuesday.date + " " + this.tuesday.day + "      "
      note += this.wednesday.date + " " + this.wednesday.day + "      "
      note += this.thursday.date + " " + this.thursday.day + "      "
      note += this.friday.date + " " + this.friday.day + "      "
      note += this.saturday.date + " " + this.saturday.day + "      "
      println(note)
    }

    //class to store data and references
    class Node {
      var date: Int = 0
      var day: String = ""
    }
  }

}