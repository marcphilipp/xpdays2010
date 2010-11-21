package funktion_f

object FunktionF {

	def f ( x : Double ) : Double = x match {
		case y if y < 5.0 => 3.0
		case y if y < 10.0 => 2.0
		case _ => 4.0
	}
}