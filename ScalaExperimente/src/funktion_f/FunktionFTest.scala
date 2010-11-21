package funktion_f

import org.junit.runner.RunWith
import org.scalacheck._
import org.scalacheck.Prop._
import org.scalacheck.Test._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.Checkers
import funktion_f.FunktionF._

@RunWith(classOf[JUnitRunner])
class FunktionFTest extends Spec with Checkers {

  describe("f") {

    it("returns 3 for inputs < 5") {
      check((x : Double) =>
        (x < 5.0) ==> (f(x) == 3.0) )
    } 

      it("returns 2 for inputs between 5 and 10") {
      check((x : Double) =>
        ((5.0 <= x) && (x < 10.0)) ==> (f(x) == 2.0) )
    } 

      it("returns 4 for inputs >= 10") {
      check((x : Double) =>
        (10.0 <= x) ==> (f(x) == 4.0) )
    } 
}
}