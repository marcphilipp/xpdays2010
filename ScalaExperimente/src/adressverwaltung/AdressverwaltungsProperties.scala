package adressverwaltung

import AdressverwaltungsGeneratoren._

import org.junit.runner.RunWith
import org.scalacheck._
import org.scalacheck.Prop._
import org.scalacheck.Test._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.Checkers

@RunWith(classOf[JUnitRunner])
class AdressverwaltungsProperties extends Spec with Checkers {

  describe("Person") {

    it("has no addresses in the beginning") {
      check((person: Person, address: Address) =>
        (person.numberOfAddresses == 0) ==> !(person knows address))
    }

    it("assigns unknown address") {
      check((person: Person, address: Address) =>
        !(person knows address) ==> {
          val previousNumber = person.numberOfAddresses
          person assign address

          (person knows address) &&
            (person.numberOfAddresses == previousNumber + 1)
        })
    }

    it("does not assign already known address") {
      check((person: Person, address: Address) =>
        (person knows address) ==> {
          val previousNumber = person.numberOfAddresses

          person assign address
          previousNumber == person.numberOfAddresses
        })
    }
  }
}