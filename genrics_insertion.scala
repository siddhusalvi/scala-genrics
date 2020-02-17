object genrics_insertion {
  def main(args: Array[String]): Unit = {
    var s:Array[String] = Array("a","c","D","b")

    var ss= new Sort()
    ss.insertionSort(s);
    println(s.mkString(" "))
  }

  class Sort[T <: Comparable[T]] {
    def insertionSort(data: Array[T]): Unit = { // start at the first index and iterate through to the end
      for (i <- 1 until data.length) {
        var currentIndex = i

        while ( {
          currentIndex > 0 && data(currentIndex - 1).compareTo(data(currentIndex)) > 0
        }) {
          val temp = data(currentIndex)
          data(currentIndex) = data(currentIndex - 1)
          data(currentIndex - 1) = temp
          currentIndex -= 1
        }
      }
    }
  }

}


