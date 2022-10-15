package main;

import java.lang.reflect.Constructor;

public class Controllore {
	
	public boolean esistenzaInterfaceIo(){
		String nomeAtteso = "it.uniroma3.diadia.IO";
		try {
			Class<?> classeIo= Class.forName(nomeAtteso);
			if(classeIo.isInterface()) {
				System.out.println("OK! Esiste l'interface IO.");
				classeIo.getMethod("leggiRiga");
				classeIo.getMethod("mostraMessaggio", String.class);
				return true;
			}else{
				throw new ClassNotFoundException();
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! L'interface IO non esiste, o è stata chiamata diversamente oppure è nel package sbagliato. Assicurarsi che IO sia una interface e non una classe.");
		} catch (NoSuchMethodException e) {
			System.out.println("Attenzione! Non esiste il metodo leggiRiga() e/o mostraMessaggio(String msg) nell'interface.");
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean esistenzaBuilderDiadia() {
		Class<?> classeDiaDia;
		boolean risultato=false;
		try {
			classeDiaDia = Class.forName("it.uniroma3.diadia.DiaDia");
			for(Constructor<?> constructor : classeDiaDia.getDeclaredConstructors()) {
				if(constructor.getParameterCount()==1 && constructor.getParameterTypes()[0]== Class.forName("it.uniroma3.diadia.IO")) {
					risultato=true;
				}
			}
			if(risultato)
				System.out.println("OK! Esiste il costruttore di diadia richiesto.");
			else
				System.out.println("Attenzione! Non esiste il costruttore di DiaDia al quale si puo' passare l'IO.");
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! Non e' stata individuata nessuna classe DiaDia. Assicurarsi di aver esportato\nil proprio DiaDia in formato jar e di averlo posizionato nella cartella esatta.");
		}
		return risultato;
	}
	
	public boolean esisteLabirinto() {
		String nomeAtteso = "it.uniroma3.diadia.ambienti.Labirinto";
		try {
			@SuppressWarnings("unused")
			Class<?> classeLab= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Labirinto ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Labirinto non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteStanza() {
		String nomeAtteso = "it.uniroma3.diadia.ambienti.Stanza";
		try {
			@SuppressWarnings("unused")
			Class<?> classeStanza= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Stanza ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Stanza non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteAttrezzo() {
		String nomeAtteso = "it.uniroma3.diadia.attrezzi.Attrezzo";
		try {
			@SuppressWarnings("unused")
			Class<?> classeAttrezzo= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Attrezzo ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Attrezzo non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteGiocatore() {
		String nomeAtteso = "it.uniroma3.diadia.giocatore.Giocatore";
		try {
			@SuppressWarnings("unused")
			Class<?> classeGiocatore= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Giocatore ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Giocatore non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteBorsa() {
		String nomeAtteso = "it.uniroma3.diadia.giocatore.Borsa";
		try {
			@SuppressWarnings("unused")
			Class<?> classeBorsa= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Borsa ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Borsa non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteComando() {
		String nomeAtteso = "it.uniroma3.diadia.Comando";
		try {
			@SuppressWarnings("unused")
			Class<?> classeComando= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Comando ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Comando non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteDiaDia() {
		String nomeAtteso = "it.uniroma3.diadia.DiaDia";
		try {
			@SuppressWarnings("unused")
			Class<?> classeDiadia= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste DiaDia ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe DiaDia non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}


	public boolean esistePartita() {
		String nomeAtteso = "it.uniroma3.diadia.Partita";
		try {
			@SuppressWarnings("unused")
			Class<?> classePartita= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Partita ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Partita non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean controlliPrimaDellaConsegna() {
		return this.esisteDiaDia()&&this.esistePartita()&&this.esisteLabirinto()&&
				this.esisteStanza()&&this.esisteGiocatore()&&this.esisteComando()&&
				this.esisteBorsa()&&this.esisteAttrezzo()&&this.esistenzaInterfaceIo()&&
				this.esistenzaBuilderDiadia();
	}
}