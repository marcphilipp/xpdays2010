package adressverwaltung

import org.scalacheck._
import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._

object AdressverwaltungsGeneratoren {

  val addressGenerator = for {
    street <- arbitrary[String]
    city <- arbitrary[String]
  } yield new Address(street, city)

  val allAddresses = getListOf10AddressesFrom(addressGenerator)

  implicit def arbitraryAddress = Arbitrary {
    oneOf(allAddresses)
  }

  implicit def arbitraryPerson = Arbitrary {
    for {
      name <- arbitrary[String]
      number <- pickNumberBetween0And6
      addresses <- pickSoManyAddresses(number)
    } yield new Person(name, addresses)
  }
  
  def getListOf10AddressesFrom(generator : Gen[Address] ) : List[Address] = listOfN(10, generator).sample.get
  def pickNumberBetween0And6() : Gen[Int] = frequency((3, 0), (3, 1), (2, 2), (1, 3), (1, 4), (1, 5), (1, 6))
  def pickSoManyAddresses(number:Int) = pick(number, allAddresses)
}