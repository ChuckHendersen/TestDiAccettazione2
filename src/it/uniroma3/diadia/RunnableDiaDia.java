package it.uniroma3.diadia;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//import it.uniroma3.diadia.ambienti.Labirinto;

public class RunnableDiaDia implements Runnable{

	//private DiaDia diadia;

	private Object diadiaObj = null;
	private Class<?> classeDiaDia = null;
	private Class<?> classeIO = null;
	private Method metodoGioca = null;
	private Class<?> classeLabirinto = null;

	//	public RunnableDiaDia (IO io) {
	//		this.diadia = new DiaDia(io);
	//	}

	//	public RunnableDiaDia (IO io, Labirinto maze) {
	//		this.diadia = new DiaDia(io,maze);
	//	}
	//	
	//	public RunnableDiaDia (IO io, Labirinto maze, int cfu) {
	//		this.diadia = new DiaDia(io,maze,cfu);
	//	}

	public RunnableDiaDia (IO io) {
		try {
			this.classeDiaDia = Class.forName("it.uniroma3.diadia.DiaDia");
			this.classeIO = Class.forName("it.uniroma3.diadia.IO");
			metodoGioca=classeDiaDia.getMethod("gioca");
			Constructor<?>[] listaCostruttori = classeDiaDia.getConstructors();
			for(Constructor<?> c:listaCostruttori) {
				if(c.getParameterCount()==1 && c.getParameterTypes()[0]==classeIO) {
					this.diadiaObj=c.newInstance(io);
				}
			}

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("Qualcosa e' andato storto. Assicurarsi di aver avviato ControlliPrimaDellaConsegna.jar e verificare che l'esito sia completamente positivo.");
			System.out.println("Il programma ora si interrompera'.");
			System.exit(1);
		}
	}
	
	public RunnableDiaDia (IO io,Object labirinto) {
		try {
			this.classeDiaDia = Class.forName("it.uniroma3.diadia.DiaDia");
			this.classeIO = Class.forName("it.uniroma3.diadia.IO");
			this.classeLabirinto = Class.forName("it.uniroma3.diadia.ambienti.Labirinto");
			metodoGioca=classeDiaDia.getMethod("gioca");
			Constructor<?>[] listaCostruttori = classeDiaDia.getConstructors();
			for(Constructor<?> c:listaCostruttori) {
				if(c.getParameterCount()==2 && c.getParameterTypes()[0]==classeIO && c.getParameterTypes()[1]==classeLabirinto) {
					this.diadiaObj=c.newInstance(io,labirinto);
				}
			}
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("Qualcosa e' andato storto. Assicurarsi di aver posizionato il proprio diadia nella cartella corretta e che ControlliPrimaDellaConsegna.jar dia esito completamente positivo...\nSi prega di leggere le istruzioni d'uso.");
			System.out.println("Il programma ora si interrompera'.");
			System.exit(1);
		}
	}

	@Override
	public void run() {
		try {
			metodoGioca.invoke(diadiaObj);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}