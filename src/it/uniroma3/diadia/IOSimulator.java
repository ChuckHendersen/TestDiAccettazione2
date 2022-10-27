package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Classe che simula gli input da dare al gioco e raccoglie gli output restituiti da esso.
 * Utile per fare test. Implementa l'interfaccia IO.
 */

public class IOSimulator implements IO {
	
	private BlockingQueue<String> inputList;
	private BlockingQueue<String> outputList;
	
	/*
	 * Costruttore che crea un simulatore di IO
	 * con comando nullo.
	 */
	
	public IOSimulator() {
		this.inputList = new LinkedBlockingQueue<String>();
		this.outputList = new LinkedBlockingQueue<String>();
	}
	
	/*
	 * Costruttore che crea un simulatore di IO che accetta come parametro una lista di
	 * input di tipo String
	 * @param listaInput Lista di input (List<String>)
	 */
	
	public IOSimulator(BlockingQueue<String> listaInput) {
		super();
		this.inputList=listaInput;
	}
	
	public void setListaInput(BlockingQueue<String> listaInput) {
		this.inputList=listaInput;
//		System.out.println(this.inputList);
	}
	public void setListaOutput(BlockingQueue<String> listaOutput) {
		this.outputList=listaOutput;
	}
//	public void setListaInputSenzaNome(List<String> listaInput) {
//		this.inputList = listaInput;
//		this.itInput = inputList.iterator();
//	}
	
	public BlockingQueue<String> getInputList(){
		return inputList;
	}
	
	public BlockingQueue<String> getOutputList(){
		return outputList;
	}
	
	/*
	 * Metodo polimorfo che aggiunge ad una lista l'output corrente generato dal gioco
	 */
	
	@Override
	public void mostraMessaggio(String msg) {
		try {
			this.outputList.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Metodo che legge i comandi dalla lista di input e li fornisce al gioco.
	 * Se la lista di comandi � vuota o si � arrivati all fine di essa, viene
	 * messo in coda un ultimo comando "fine" in modo da fermare il gioco
	 */
	@Override
	public String leggiRiga() {
		String res = inputList.poll();
		if(res!=null){
			return res;
		}
		return "fine";
		// Per motivi di precauzione l'ultimo input è sempre fine
	}
}