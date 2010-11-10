package adressverwaltung

import org.junit.runner.RunWith
import org.scalacheck.Prop._
import org.scalatest.Assertions._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.Checkers

@RunWith(classOf[JUnitRunner])
class AdressverwaltungsTest extends Spec with Checkers {

  describe("Person") {

    it("hat keine Adresse, bekommt neue Adresse") {
    	val person = new Person("Peter")
    	  val newAddress = new Address("Ludwigstr. 5", "75045 Walzbachtal")
    	  person assign newAddress
    	  assert(person knows newAddress)
    	  assert(person.numberOfAddresses == 1)
    }

      it("hat keine Adresse, bekommt neue Adresse zweimal") {
    	val person = new Person("Peter")
    	  val newAddress = new Address("Ludwigstr. 5", "75045 Walzbachtal")
    	  person assign newAddress
    	  person assign newAddress
    	  assert(person knows newAddress)
    	  assert(person.numberOfAddresses == 1)
    }

      it("hat keine Adresse, bekommt zweimal dieselbe Adresse") {
    	val person = new Person("Peter")
    	  person assign new Address("Ludwigstr. 5", "75045 Walzbachtal")
    	  person assign new Address("Ludwigstr. 5", "75045 Walzbachtal")
    	  assert(person.numberOfAddresses == 1)
    }

      it("hat schon Adressen, bekommt neue Adresse") {
    	val person = new Person("Peter")
    	  person assign new Address("Albert-Nestler-Str. 11", "76131 Karlsruhe")
    	  person assign new Address("Werthmannstr. 10", "76131 Karlsruhe")
    	
    	  val newAddress = new Address("Ludwigstr. 5", "75045 Walzbachtal")
    	  person assign newAddress
    	  assert(person knows newAddress)
    	  assert(person.numberOfAddresses == 3)
    }
      
      it("findet eine vorhandene Adresse"){
    	  val person = new Person("Peter")
    	  person assign new Address("Ludwigstr. 5", "75045 Walzbachtal")

    	   val foundAddresses = person findAddressContaining "Ludwig"
    	   
    	   assert(foundAddresses contains new Address("Ludwigstr. 5", "75045 Walzbachtal"))
      }
      
      it("findet mehrere vorhandene Adressen"){
    	  val person = new Person("Peter")
    	  person assign new Address("Ludwigstr. 5", "75045 Walzbachtal")
    	  person assign new Address("Germanenstr. 5", "75045 Walzbachtal")
    	  person assign new Address("Weidenweg 5", "75045 Ludwigslust")

    	   val foundAddresses = person findAddressContaining "Ludwig"
    	   
    	   assert(foundAddresses.size == 2)
    	   assert(foundAddresses contains new Address("Ludwigstr. 5", "75045 Walzbachtal"))
    	  assert(foundAddresses contains new Address("Weidenweg 5", "75045 Ludwigslust"))
      }
      
      it("findet keine nicht vorhandene Adresse"){
    	  val person = new Person("Peter")
    	  person assign new Address("Ludwigstr. 5", "75045 Walzbachtal")

    	   val foundAddresses = person findAddressContaining "Weg"
    	   
    	   assert(foundAddresses.size == 0)
      }
  }
}