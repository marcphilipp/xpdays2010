package quicksort;

import TestHelpers._
import QuickSort._
import org.junit.runner.RunWith
import org.scalacheck.Prop._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.Checkers

@RunWith(classOf[JUnitRunner])
class QuickSortTest extends Spec with ShouldMatchers with Checkers {

  describe("QuickSort") {

    it("orders items") {
      check((xs: List[Int]) => ordered(quickSort(xs)))
    }

    it("retains list size") {
      check((xs: List[Int]) => xs.size == quickSort(xs).size)
    }

    it("retains the same elements") {
      check((xs: List[Int]) => haveSameElements(xs, quickSort(xs)))
    }
  }
}
