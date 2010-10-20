import org.scalacheck._
import org.scalacheck.Prop._

object StringProperties extends Properties("String") {

//  property("startsWith") = forAll((a: String, b: String) => (a + b).startsWith(a))

//  property("endsWith") = forAll((a: String, b: String) => (a + b).endsWith(b))
	
  // Is this really always true?
  property("concat") = forAll((a: String, b: String) =>
    (a + b).length > a.length && (a + b).length > b.length)

//  property("substring") = forAll((a: String, b: String) =>
//    (a + b).substring(a.length) == b)

//  property("substring") = forAll((a: String, b: String, c: String) =>
//    (a + b + c).substring(a.length, a.length + b.length) == b)
    
}
