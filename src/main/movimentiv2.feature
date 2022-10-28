#Controllo del corretto spostamento tra stanze (comando Vai)
Feature: Verifica funzionalità dello spostamento

	@TestVaiNord
  Scenario: verifica che in un labirito formato da due stanze nord/sud ci si possa spostare 
   Given il gioco e stato avviato
   Given carico il comando "guarda"
   And carico il comando "vai nord"
   And carico il comando "guarda"
   Then verifico lo spostamento da "Atrio" a "Biblioteca" verso "nord"
   And hai vinto la partita
   
  @TestVaiEst
  Scenario: verifica che in un labirito formato da due stanze nord/sud ci si possa spostare 
   Given il gioco e stato avviato
   Given carico il comando "guarda"
   And carico il comando "vai est"
   And carico il comando "guarda"
   Then verifico lo spostamento da "Atrio" a "Aula N11" verso "est"