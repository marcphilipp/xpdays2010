package adressverwaltung

import org.scalacheck._
import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._

object AdressverwaltungsGeneratoren  {

  implicit def addresses: Arbitrary[Address] = Arbitrary {
    for {
      street <- arbitrary[String]
      city <- arbitrary[String]
    } yield new Address(street, city)
  }

  implicit def persons: Arbitrary[Person] = Arbitrary {
    for {
      name <- arbitrary[String]
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