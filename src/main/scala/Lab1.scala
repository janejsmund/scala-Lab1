import scala.collection.mutable._

object Lab1 {
  def main(args: Array[String]): Unit = {

    //ćwiczenie 1.
    val days = List("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela")
    def sep() : Unit = println("--------------------------------------------------")

    //a)
    for (d <- days) println(d)
    sep()

    //b)
    for (d <- days if d.charAt(0)=='p') println(d)
    sep()

    //c)
    days.foreach(d => println(d))
    sep()

    //d)
    var counter = 0
    while(counter < days.length) {
      println(days(counter))
      counter += 1
    }
    counter = 0
    sep()

    //e)
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

    //f)
    def ker() : Unit = {
      if(counter < days.length) {
        println(days(days.length-1-counter))
        counter += 1
        ker()
      }
    }
    ker()
    counter = 0
    sep()

    //g)
    println(days.foldLeft("dni: ")(_ + _ + "\r\n"))
    sep()

    println(days.foldRight(" : dni")(_+"\r\n"+_))
    sep()

    //h)
    println(days.filter(_.startsWith("p")).foldLeft("")(_+"\r\n"+_))
    sep()

    //ćwiczenie 2.
    val m = Map("a" -> 24.0, "b" -> 17.0, "c" -> 87.0)
    println(m mapValues(d => 0.9*d))
    sep()

    //ćwiczenie 3.
    val krotka = ("a", 3.14, 2)
    def kro(tuple3: (String, Double, Int)) : Unit = {
      println(tuple3._1)
      println(tuple3._2)
      println(tuple3._3)
    }
    kro(krotka)
    sep()

    //ćwiczenie 4.
    val map : Option[Double] = Some(m.getOrElse("a", 0.0))
    println(map)
    sep()

    //ćwiczenie 5.
    def praca(s : String) : Unit = {
      val workingDays = List("poniedziałek", "wtorek", "środa", "czwartek", "piątek")
      val weekendDays = List("sobota", "niedziela")

      if (workingDays.contains(s)) {println("Praca")}
      else if (weekendDays.contains(s)) {println("Weekend")}
      else {println("Nie ma takiego dnia.")}
    }
    praca("poniedziałek")
    praca("niedziela")
    praca("a")
    sep()

    //ćwiczenie 6.
    class KontoBankowe(var stanKonta : Double) {

      def this() = {
        this(0.0)
      }

      def wplata(kwota : Double) : Unit = {
        stanKonta = stanKonta + kwota
        println("Stan konta po wplacie wynosi: " + stanKonta)
      }

      def wyplata(kwota : Double) : Unit = {
        if (kwota > stanKonta) {
          println("Za malo srodkow na koncie")
          return null
        }
        stanKonta = stanKonta - kwota
        println("Stan konta po wyplacie wynosi: " + stanKonta)
      }

      def SprawdzStanKonta() : Unit = {
        println("Stan konta wynosi: " + stanKonta)
      }
    }

    //ćwiczenie 7.
    class Osoba(val imie : String, val nazwisko : String)  {}
    val jan = new Osoba("Jan", "Ejsmund")
    val janek = new Osoba("Janek", "Ejsmund")
    val dorota = new Osoba("Dorota" ,"")
    def witaj(osoba: Osoba) : Unit = {
      osoba.imie match {
        case "Jan" => println("Hej Janek.")
        case "Janek" => println("Hey Jan.")
        case _ => println("Hej.")
      }
    }
    witaj(jan)
    witaj(janek)
    witaj(dorota)
    sep()

    //ćwiczenie 8.
    def usunZera(i : List[Integer]) : List[Integer] = {
      var result = new ListBuffer[Integer]()
      for (n <- i) {
        if (n != 0) result += n
      }
      result.toList
    }
    println(usunZera(List(2, 3, 4, 5, 6, 0, 7, 6, 1, 0, 2, 1, 0)))
    sep()

    //ćwiczenie 9.
    def zwiekszO1(i : List[Integer]) : List[Integer] = {
      var result = new ListBuffer[Integer]()
      for (n <- i) {
        result += n + 1
      }
      result.toList
    }
    println(zwiekszO1(List(1, 2, 3, 4, 5, 6, 7, 8)))
    sep()

    //ćwiczenie 10.
    def zwrocModulLiczbyZPrzedzialu(i : List[Integer]) : List[Integer] = {
      var result = new ListBuffer[Integer]()
      for(n <- i) {
        if (n >= -5 && n <= 12) {
          if (n >= 0) result += n
          else result += -1 * n
        }
      }
      result.toList
    }
    println(zwrocModulLiczbyZPrzedzialu(List(-8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)))
  }
}
