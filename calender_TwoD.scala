/*
Filename: calender_TwoD
Created: Siddhesh Salvi
Change history:5.2.2020 / Siddhesh Salvi

12.Write a program Calendar.java that takes the month and year as command-line
arguments and prints the Calendar of the month. Store the Calendar in an 2D Array,
the first dimension the week of the month and the second dimension stores the day
of the week. Print the result as following.  
*/

import java.time.YearMonth

object calender_TwoD {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        print("Enter a year : ")
        var year = scala.io.StdIn.readInt()

        print("Enter a month :")
        var month = scala.io.StdIn.readInt()

        var mat = Array.ofDim[String](7, 7)
        val ym = YearMonth.of(year, month)
        val firstDay = ym.atDay(1).getDayOfWeek.name
        var days = ym.lengthOfMonth()

        true
        for (i <- 1 until 7) {
          for (j <- 0 until 7) {
            mat(i)(j) = " "
          }
        }
        mat(0)(0) = "SUNDAY"
        mat(0)(1) = "MONDAY"
        mat(0)(2) = "TUESDAY"
        mat(0)(3) = "WEDNESDAY"
        mat(0)(4) = "THURSDAY"
        mat(0)(5) = "FRIDAY"
        mat(0)(6) = "SATURDAY"

        var counter = 1
        var flag1 = true
        for (i <- 1 until 7) {
          for (j <- 0 until 7) {
            if (!flag1 && counter <= days) {
              mat(i)(j) = counter.toString
              print(counter)
              counter += 1
            }
            if (flag1 && firstDay.equals(mat(0)(j))) {
              print(mat(0)(j))
              flag1 = false
              mat(i)(j) = counter.toString
              counter += 1
            }
          }
        }

        print("\n")
        for (i <- 0 until 7) {
          for (j <- 0 until 7) {
            print(mat(i)(j) + " ")
          }
          print("\n")
        }

        flag = false
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }
} 