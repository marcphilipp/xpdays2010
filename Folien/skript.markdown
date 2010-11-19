# Unit Tests als Spezifikation?

## Mathematisches Beispiel

### Funktionsdefinition

	double f(double x) {
		if (x < 5d)  return 3d;
		if (x < 10d) return 2d;
		return 4d;
	}

### Unit Test

	@Test public void wertetabelle() {
		assertEquals(3, f(1), DELTA);
		assertEquals(3, f(3), DELTA);
		assertEquals(2, f(7), DELTA);
		assertEquals(4, f(12), DELTA);
	}

### Visualisierung des Unit Tests

	|                o
	|   o  o
	|          o
	L_____________________

* Zu wenige Punkte
* Skaliert nicht

TODO Verschiedene Kurven durch die Punkte legen

Unit Test entspricht Wertetabelle

<table>
  <tr><th>x</th><th>f(x)</th></tr>
  <tr><td>1</td><td>3</td></tr>
  <tr><td>3</td><td>3</td></tr>
  <tr><td>7</td><td>2</td></tr>
  <tr><td>12</td><td>4</td></tr>
</table>

> Traditional test suites verify a few well-picked scenarios or example inputs.  
> → does not uncover errors in legal inputs the test writer overlooked. [1]

### Mathematische Spezifikation

These: Oft näher an der Formulierung einer User Story

∀ x:      x <  5 => f(x) = 3  
∀ x:  5 ≤ x < 10 => f(x) = 2  
∀ x: 10 ≤ x      => f(x) = 4

Kann man das so in JUnit ausdrücken?

### Theories

> A theory generalizes a (possibly inﬁnite) set of example-based tests. Theories should be true for any data exercised by human-chosen data or automatic data generation. [1]

Erklären (2-3 Folien)

	@Theory public void firstSection(double x) {
		assumeTrue(x < 5);
		assertEquals(3, f(x));
	}

Wie kommen die Werte rein?

	@DataPoints public static int[] values = {1, 3, 7, 12};

Trennung von zu Wertdefinition und Spezifikation der Eigenschaft

Die gleichen Werte wie im Unit Test! Es ist zwar leichter, neue Werte hinzuzufügen, aber man muss sich die Werte immer noch selbst ausdenken  
→ Nix gewonnen!

Kann man nicht automatisch "zufällige" Eingabewerte generieren?

### Automatisierte Generierung von Eingabewerten

* ScalaCheck zeigen (in Eclipse)
* Erklären: Wie geht das?
* Generatoren:
	* 100 erfolgreiche Läufe
	* max. 500 erfolglose Versuche
* Test fehlschlagen lassen

Fertig, oder?


## Objekte

* Story mit Abnahmekriterien (auf Folie)
* Implementierung zeigen
* Unit Test zeigen
* Frage ins Publikum: Reicht dieser Test?
* Antwort: Nein; list.clear() einbauen.

### Umformung des Unit Tests in eine Theory

TODO Live oder mit versch. Dateien?

* Man merkt: Es fehlt ein assume → Test wird rot
* Implementierung korrigieren

Fazit: Theories haben geholfen und sind näher an der User Story dran

Aber: Daten werden immer noch per Hand definiert.

### Generatoren in ScalaCheck

* Hilft das hier auch?
* Theories als ScalaCheck-Properties zeigen
* Generatoren zeigen und kurz erklären

### Gibt's das nicht für Java?

* JUnit-Quickcheck ist rudimentärer Ansatz in diese Richtung
* Theories mit `@Forall`-Annotation versehen
* `Extractors` statt `@DataPoints`

----------------

## Fazit

TODO Kein Entweder-oder!

> An example can quickly lead a reader to an intuitive grasp of the desired functionality, but a theory helps make clear which aspects of the example are necessary, and which are arbitrary. [1]


## TODO Was fehlt?

* Was muss man bei der Verwendung von generierten Eingabewerten beachten?
	* Beispiel: Teste ich nicht nur triviale Fälle?
	* Man sollte sich die Verteilung der generierten Werte anschauen!
* Was macht einen guten Unit Test aus?
* Was macht eine gute Spezifikation aus?
* Wie geht das beides zusammen?


## Quellen

[1] David Saff, Marat Boshernitsan, and Michael D. Ernst; Theories in Practice: Easy-to-Write Speciﬁcations that Catch Bugs, MIT-CSAIL-TR-2008-002

