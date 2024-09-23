Brug af break kan være med til at gøre koden sværere at forstå. Det er bedre at indførere en variable ala

    boolean continue = true;
    while (continue)
    ...
    continue = false;

---

I rollForPoints() metoden laver I en ny Scanner hver gang I kalder metoden, I skal sørge for at lukke den igen med

    scanner.close();

I slutningen af metoden, eller lave en godbal som genbruges.

