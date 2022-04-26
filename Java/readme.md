- Geforkt en git clone
- Geopende in IntelliJ, project op basis van Gradle file
- Run gradle clean build
    Test faalt -> staat in Requirements Specification. Ze liegen niet.
- Run gradle clean build -x test
    Build groen, want negeert testen.
- gradle file bekijken:
    Eerste opmerkingen:
        - Java 1.8 -> updaten naar LTS versie
        - Libraries updaten
        - Maven stuff verwijderen -> onnodige clutter.
- main directory eens bekeken
    - Lezen, wat gebeurt er.
    Eerste opmerkingen:
        - Van Item class en Items property afblijven (as per Requirements Specification -> boze goblin)
            Hierdoor ook geen getters en setters -> Extend? Extend.
        - Items en UpdateQuality mogen eventueel static (as per Requirements Specification)
        - Heeeeeel veel if's. Te veel.
            Soms ook if within an if die samengevoegd kan worden.
        - De for statement kan simpeler en duidelijker.
        - Item array?
        - items[i].quality - items[i].quality -> Whut?
        - if (! conditie) else -> omdraaien, negatie maakt het ingewikkelder
        - Duplicate text. Versimpelen of in een constant gooien.
- tests bekeken
    - GildedRoseTest is broken -> startpunt.
    - TexttestFixture -> voor een snelle start, maar gaan we negeren, want ik wil tonen dat ik ook testen kan schrijven.

- Doelen:
    - Code herschrijven/verbeteren/testen
    - Nieuwe functionaliteit implementeren

- Vereisten en condities:
  ![Conditions](conditions.jpeg)

- Wijzigingen maken aan
    - UpdateQuality method
    - alle nodige code
    - Afblijven:
        - Item class - DO NOT TOUCH
        - Items property - DO NOT TOUCh (mag eventueel static)

- Testen fixen
    - Simpel en bulky, gebaseerd op de TexttestFixture testclasse
    - Waarom? Omdat het duidelijk is, werkt en ik tijdens het refactoren van de productiecode ook de testen ga herschrijven. -> TDD
    - Conjured item nog niet toegevoegd.
