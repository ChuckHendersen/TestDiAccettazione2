# Basta che contenga il messaggio iniziale senza modificarlo

Feature: Verifica della funzionalita delle stampe

	@TestMessaggioDiBenvenuto
  Scenario: Verifica la presenza del messaggio di benvenuto all avvio del gioco
    Given il gioco e stato avviato
    Then viene mostrato il messaggio_di_benvenuto
#   And confronto il messaggio_di_benvenuto con il messaggio_aspettato
    
	@TestMessaggioDiFineETerminazionePartita
	Scenario: Verifica che la partita finisca quando si digita fine
		Given carico il comando "fine"
		And il gioco e stato avviato
		Then il gioco stampa un messaggio di arrivederci
		And il gioco si chiude