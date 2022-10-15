
Feature: Il giocatore muore quando finisce i cfu

#Non abbiamo modo di testare accuratamente la feature di morte per come impostati i requisiti attualmente

  @TestMorte
  Scenario: Eseguito un grande numero di spostamenti il giocatore muore e la partita termina
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    Given carico il comando "vai est"
    Given carico il comando "vai ovest"
    And il gioco e stato avviato 
    Then viene mostrato il messaggio di morte
    Then il gioco si chiude