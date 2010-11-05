package quicksort;

object QuickSort {

  def quickSort[T <% Ordered[T]](list: List[T]): List[T] = {
    list match {
      case Nil => Nil
      case x :: xs =>
        val (before, after) = xs partition (_ < x)
        quickSort(before) ++ (x :: quickSort(after))
    }
  }
}

