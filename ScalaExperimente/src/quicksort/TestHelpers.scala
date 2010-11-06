package quicksort;

object TestHelpers {

  def ordered[T <% Ordered[T]](list: List[T]): Boolean = {
    list match {
      case Nil => true
      case x :: Nil => true
      case x :: y :: xs => x <= y && ordered(y :: xs)
    }
  }

  def haveSameElements[T <% Ordered[T]](left: List[T], right: List[T]): Boolean = {
    left match {
      case Nil => right.isEmpty
      case x :: xs =>
        val (xInLeft, leftRemainder) = left partition (_ == x)
        val (xInRight, rightRemainder) = right partition (_ == x)
        xInLeft.size == xInRight.size && haveSameElements(leftRemainder, rightRemainder)
    }
  }
  
  def equalItemsHaveSameOrder[T <% Ordered[T]](left: List[T], right: List[T]): Boolean = {
    left match {
      case Nil => right.isEmpty
      case x :: xs =>
        val (xInLeft, leftRemainder) = left partition (_ == x)
        val (xInRight, rightRemainder) = right partition (_ == x)
        sameElements(xInLeft, xInRight) && equalItemsHaveSameOrder(leftRemainder, rightRemainder)
    }
  }
  
  def sameElements[T <% Ordered[T]](left: List[T], right: List[T]): Boolean = {
    left match {
      case Nil => right.isEmpty
      case x :: xs => x == right.head && sameElements(xs, right.tail)
    }
  }
}