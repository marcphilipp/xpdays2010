package adressverwaltung

class Address(val strasse : String, val ort : String) {
	
	def contains(part:String) = strasse.contains( part) || ort.contains( part)

	override def equals(other:Any) = other match {
		case that : Address => this.strasse == that.strasse && this.ort == that.ort
		case _ => false
	}
	
	override def hashCode = strasse.hashCode + ort.hashCode
}