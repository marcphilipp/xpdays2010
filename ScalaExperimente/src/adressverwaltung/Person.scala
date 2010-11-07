package adressverwaltung

import scala.collection.immutable._

class Person {
	
	private var addresses : List[Address] = Nil
	
	def assign (newAddress : Address){
		if(this knows newAddress){
			// do nothing
		} else {
			addresses = newAddress :: addresses
		}
	}
	
	def knows (address : Address) =
		 addresses contains address
		 
   def numberOfAddresses = addresses size
   
   def findAddressContaining (part : String) = 
	   addresses filter (address => address contains part)

}