## Prerequisiti

La libreria pn-f24lib (PagoPA) è disponibile su GitHub: https://github.com/mamico/pn-f24lib
Il repository è un fork dell'originale PagoPA modificato nel branch `standalone` per permettere una build
senza i prerequisiti PagoPA.

Una volta compilato il jar va messo nella cartella `extras` di questo repository e eventualmente aggiornato il riferimento nel `pom.xml`


## TODO

Attualmente il servizio gestsce solo F24 simplified

## Build

```
mvn build
```

## Run

### Per utilizzare il servizio come applicazione RESTAPI

```
mvn spring-boot:run
```

oppure

```
java -jar target/f24-service-1.0.0.jar
```

Esempio di richiesta GET con curl:

```
curl -X POST http://localhost:5000/api/f24/pdf/simplified -H "Content-Type: application/json" -d @examples/f24simplified.json --output f24.pdf
```

### Per utilizzare il servizio come cli

Utilizzando il parametro `--cli` il programma può essere utilizzato come cli.


```
cat examples/f24simplified.json | java -jar target/f24-service-1.0.0.jar --cli > f24.pdf
```
