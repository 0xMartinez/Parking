# Parking
Project for Intive Patronage

## Opis systemu
Aplikacja została zaprojektowana w celu zarządzania parkingiem. Pracownik parkingu ma możliwość dokonywania następujących operacji:
* dodawanie klientów,
* wyświetlanie klientów,
* dodawanie miejsc parkingowych,
* wyświetlanie wolnych miejsc parkingowych,
* usuwanie miejsc parkingowych,
* tworzenie rezerwacji,
* usuwanie rezerwacji,
* wyświetlanie wszystkich rezerwacji dla konkretnego klienta.

Struktura danych:
* Customer:
  - customerId (unikalna w systemie, minimum 2, maksymalnie 20 znaków, nie może zawierać samych białych znaków)
 
* ParkingSpace:
  - parkingSpaceId (Id generowane automatycznie na podstawie podanego numeru miejsca(placeNumber) oraz kondygnacji(storey) według wzoru: placeNumber-storey)
  - placeNumber (numer miejsca parkingowego)
  - storey (kondygnacja)
  - forDisabled (czy miejsce jest dla niepełnosprawnych)
  
* Reservation:
  - parkingSpaceId (Id miejsca parkingowego dla ktorego dokonywana jest rezerwacja)
  - customerId (Id klienta dla ktorego dokonywana jest rezerwacja)
  
  
 ## Zbudowanie aplikacji
  Aby zbudować aplikację należy w CMD wejść w folder projektu a następnie wywołać następującą komendę:
  ```curl
  mvnw spring-boot:build-info
  ```
  
 ## Uruchomienie
  Aby uruchomić aplikację należy w CMD wejść w folder projektu a następnie wywołać następującą komendę:
  
  ```curl
  mvnw spring-boot:run
  ```
 a następnie w oknie przeglądarki przejść pod adres: http://localhost:8080
 
 
## Polecenia w narzędziu curl
 Aby dodać rezerwację należy najpierw dodać klienta oraz miejsce parkingowe. Przykładowy ciąg komend w narzędziu curl pokazujący funkcjonalność systemu:

 ```curl
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X POST http://localhost:8080/parking/customer/add?customerId=bob
 
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X POST http://localhost:8080/parking/customer/add?customerId=tom
 
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X POST "localhost:8080/parking/add?placeNumber=1&storey=1&forDisabled=true"
 
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X POST "localhost:8080/parking/add?placeNumber=1&storey=2&forDisabled=true"
 
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X POST "localhost:8080/parking/add?placeNumber=1&storey=3&forDisabled=true"
 
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X POST "localhost:8080/parking/reservation/add?parkingSpaceId=1-1&customerId=bob"
 
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X POST "localhost:8080/parking/reservation/add?parkingSpaceId=1-2&customerId=bob"
 
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X GET "localhost:8080/parking/reservation/list/bob?CustomerId=bob"
 
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X POST "localhost:8080/parking/reservation/delete/1-1?ParkingSpaceId=1-1"
 
 curl -H "Content-Type: application/json" "Accept: application/json"~ -X GET "localhost:8080/parking/list"
 ```
 
## Wymagania:
 Java 17



 
 

 

  
  
  
  
  
  
