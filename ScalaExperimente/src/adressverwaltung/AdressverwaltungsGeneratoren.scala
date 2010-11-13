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

  implicit def addresses: Arbitrary[Address] = Arbitrary {
    oneOf(allAddresses)
  }

  implicit def persons: Arbitrary[Person] = Arbitrary {
    for {
      name <- alphaStr
      addresses <- resize(3, arbitrary[List[Address]])
    } yield {
      val person = new Person(name)
      for (address <- addresses) {
        person assign address
      }
      person
    }
  }

}