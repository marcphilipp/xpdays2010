package adressverwaltung

import org.scalacheck._
import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._

object AdressverwaltungsGeneratoren {

  val addressGen = for {
    street <- alphaStr
    city <- alphaStr
  } yield new Address(street, city)

  val allAddresses = listOfN(5, addressGen).sample.get

  implicit def arbitraryAddress = Arbitrary {
    oneOf(allAddresses)
  }

  implicit def arbitraryPerson = Arbitrary {
    for {
      name <- alphaStr
      addresses <- resize(2, arbitrary[List[Address]])
    } yield {
      val person = new Person(name)
      for (address <- addresses) {
        person assign address
      }
      person
    }
  }

}