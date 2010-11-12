package adressverwaltung

import AdressverwaltungsGeneratoren._

import org.junit.runner.RunWith
import org.scalacheck._
import org.scalacheck.Prop._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.Checkers

@RunWith(classOf[JUnitRunner])
class AdressverwaltungsProperties extends Spec with Checkers with ShouldMatchers {

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