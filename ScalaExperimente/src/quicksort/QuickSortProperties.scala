package quicksort;

import org.scalacheck._
import org.scalacheck.Prop._
import QuickSort._
import TestHelpers._

object QuickSortProperties extends Properties("QuickSort") {

  property("ordered") =
    forAll((xs: List[Int]) => ordered(quickSort(xs)))

  property("sameSize") =
    forAll((xs: List[Int]) => xs.size == quickSort(xs).size)

  property("sameElements") =
    forAll((xs: List[Int]) => haveSameElements(xs, quickSort(xs)))

  property("sameElements2") =
    forAll((xs: List[Int]) => classify(ordered(xs), "trivial") {
      haveSameElements(xs, quickSort(xs))
    })

  property("sameElements3") =
    forAll((xs: List[Int]) => collect(xs.size) {
      haveSameElements(xs, quickSort(xs))
    })

  property("sameElements4") =
    forAll((xs: List[Int]) => classify(ordered(xs), "trivial") {
      collect(xs.size) {
        haveSameElements(xs, quickSort(xs))
      }
    })

}
