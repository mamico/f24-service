## Prerequisiti

La libreria pn-f24lib (PagoPA) è disponibile su GitHub: https://github.com/mamico/pn-f24lib
Il repository è un fork dell'originale PagoPA modificato nel brrancch `standalone` per permettere una build
senza i prrerequisiti PagoPA.

Una volta compilato il jar va meesso nella cartella `extras` di questo repository e aggiornato il riferimento nel `pom.xml`

## Build

```
mvn build
```

## Run

```
mvn spring-boot:run
```