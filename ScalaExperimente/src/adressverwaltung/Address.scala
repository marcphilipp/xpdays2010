package adressverwaltung

class Address(val street: String, val city: String) {
	
  def contains(part: String) = street.contains(part) || city.contains(part)

  override def equals(other: Any) = other match {
    case that: Address => this.street == that.street && this.city == that.city
    case _ => false
  }

  override def toString = street + ", " + city

  override def hashCode = street.hashCode + city.hashCode
}