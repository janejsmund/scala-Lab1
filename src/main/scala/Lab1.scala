object Lab1 {
  def main(args: Array[String]): Unit = {
    val days = List("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela")
    def sep() = println("--------------------------------------------------")

    for (d <- days) println(d)
    sep()

    for (d <- days if d.charAt(0)=='p') println(d)
    sep()

    days.foreach(d => println(d))
    sep()

    var counter = 0
    while(counter < days.length) {
      println(days(counter))
      counter += 1
    }
    counter = 0
    sep()

    def rek() : Unit = {
      if(counter < days.length) {
        println(days(counter))
        counter += 1
        rek()
      }
    }
    rek()
    counter = 0
    sep()

    def ker() : Unit = {
      if(counter < days.length) {
        println(days(days.length-counter-1))
        counter += 1
        ker()
      }
    }
    ker()
    counter = 0
    sep()

    println(days.foldLeft("dni: ")(_ + _ + "\r\n"))
    sep()

    println(days.foldRight(" : dni")(_+"\r\n"+_))
    sep()

    println(days.foldLeft("dni: ")(_ + _ + "\r\n").filter()

  }
}
