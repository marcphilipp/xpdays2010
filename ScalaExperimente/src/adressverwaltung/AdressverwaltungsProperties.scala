package adressverwaltung

import org.junit.runner.RunWith
import org.scalacheck._
import org.scalacheck.Prop._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.Checkers

@RunWith(classOf[JUnitRunner])
class AdressverwaltungsProperties extends Spec with Checkers with ShouldMatchers {
	
	val address = new Address("Strasse", "Ort")
	
	def createPeter = new Person("Peter")
	def createPaul : Person = {
		val person = new Person("Paul")
		person assign address
		return person
	}
	
	val addresses = Gen.oneOf(address, new Address("andere Strasse", "anderer Ort"))
	val persons = Gen.wrap(Gen.oneOf(createPeter, createPaul))

	describe("Person") {
		
	    it("has no addresses in the beginning") {
	    	new Person("Klaus").numberOfAddresses should equal (0)
	    }
	    
	    it("assigns unknown address") {
	    	check(forAll(persons, addresses)((person, address) => 
	    	!(person knows address) ==>
	    	{
	    		val previousNumber = person.numberOfAddresses
	    		person.assign(address)
	    		
	    		(person knows address) &&
	    		(person.numberOfAddresses == previousNumber + 1)
	    	}))
	    }
	    it("does not assign already known address") {
	    	check(forAll(persons, addresses)((person, address) => 
	    	(person knows address) ==>
	    	{
	    		val previousNumber = person.numberOfAddresses
	    		person assign address
	    		
	    		previousNumber == person.numberOfAddresses
	    	}))
	    }
	}
}