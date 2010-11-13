package adressverwaltung

import scala.collection.immutable._

class Person(name: String) {

  private var addresses: List[Address] = Nil

  def assign(newAddress: Address) {
    if (this knows newAddress) {
      return
    }
    addresses = newAddress :: addresses
  }

  def knows(address: Address) = addresses contains address

  def numberOfAddresses = addresses size

  def findAddressContaining(part: String) =
    addresses filter (address => address contains part)

  override def toString = name + addresses
}