package adressverwaltung

import org.scalacheck._
import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._

object AdressverwaltungsGeneratoren {

  val addressGenerator = for {
    street <- alphaStr
    city <- alphaStr
  } yield new Address(street, city)

  val allAddresses = listOfN(10, addressGenerator).sample.get

  implicit def arbitraryAddress = Arbitrary {
    oneOf(allAddresses)
  }

  implicit def arbitraryPerson = Arbitrary {
    for {
      name <- alphaStr
      number <- frequency((3, 0), (3, 1), (2, 2), (1, 3), (1, 4), (1, 5), (1, 6))
      addresses <- pick(number, allAddresses)
    } yield {
      val person = new Person(name)
      for (address <- addresses) {
        person assign address
      }
      person
    }
  }
}