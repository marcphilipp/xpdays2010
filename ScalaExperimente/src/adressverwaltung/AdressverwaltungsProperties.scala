package adressverwaltung

import org.junit.runner.RunWith
import org.scalacheck._

import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._
import org.scalacheck.Prop._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.Checkers

@RunWith(classOf[JUnitRunner])
class AdressverwaltungsProperties extends Spec with Checkers with ShouldMatchers {

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

  describe("Person") {

    it("has no addresses in the beginning") {
      new Person("Klaus").numberOfAddresses should equal(0)
    }

    it("assigns unknown address") {
      check((person: Person, address: Address) =>
        !(person knows address) ==> {
          val previousNumber = person.numberOfAddresses
          person.assign(address)

          (person knows address) &&
            (person.numberOfAddresses == previousNumber + 1)
        })
    }
    
    it("does not assign already known address") {
      check((person: Person, address: Address) =>
        // (person knows address) ==>
        {
          person assign address
          val previousNumber = person.numberOfAddresses
          person assign address

          previousNumber == person.numberOfAddresses
        })
    }
  }
  
}