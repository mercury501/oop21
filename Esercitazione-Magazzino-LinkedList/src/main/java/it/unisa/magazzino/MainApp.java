package it.unisa.magazzino;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import poo21.LinkedList.Implementations.LinkedList;

public class MainApp {
	public static void main(String[] args) {
		Magazzino<Prodotto> magazzino = new Magazzino<>();
		MainApp app = new MainApp();
		System.out.println("Gestione magazino");
		
		Scanner in = new Scanner(System.in);
		int scelta = 0;
		do {
			System.out.println("**************************************");
			System.out.println("* 1 To insert a new list of Products *");
			System.out.println("* 2 To delete a list of Products     *");
			System.out.println("* 3 To print a list of Products      *");
			System.out.println("* -1 To exit                         *");
			System.out.println("* Please insert a Command :          *");
			System.out.println("**************************************");
			
			scelta = in.nextInt();
			
			switch(scelta) {
			case 1:
				app.insertNewLinkedList(magazzino, in, System.in);
				break;
			case 2:
				app.removeList(magazzino, in);
				break;
			case 3:
				System.out.println(" Select output destination (1 for file and 2 for stdout): ");
				scelta = in.nextInt();
				try {
					if(scelta == 1) {
						System.out.println(" Select file name: ");
						String name = in.next();
						app.stampa(magazzino, new OutputStreamWriter(new FileOutputStream(name)));
					} else if (scelta == 2) {
						app.stampa(magazzino, new OutputStreamWriter(System.out));
					} else {
						System.out.println("Wrong output selection");
					}
				} catch (IOException ex) {
					System.err.println(ex.getMessage());
				}
				break;
			case -1:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid input");					
			}
		} while(scelta != -1);
		return;
	}
	
	/*
	 @SuppressWarnings("unchecked")
	 
	private <T> void insertNewList(Magazzino<T> magazzino, Scanner scan, InputStream in) {
		List<? extends T> list = null;
		System.out.println(" Select product type (1 generic product, 2 perishable product): ");
		int scelta = scan.nextInt();
		if(scelta == 1) {
			list = (List<? extends T>) createList(Prodotto.class, scan, in);
		} else if(scelta == 2) {
			list = (List<? extends T>) createList(ProdottoDeperibile.class, scan, in);
		} else {
			System.out.println(" Wrong product type ");
			scan.close();
			return;
		}
		System.out.println(" Insert category name: ");
		String category = scan.next();
		magazzino.addList(list, category);
	}
	*/
	@SuppressWarnings("unchecked")
	private <T> void insertNewLinkedList(Magazzino<T> magazzino, Scanner scan, InputStream in) {
		LinkedList<? extends T> list = new LinkedList<>();
		
		System.out.println(" Select product type (1 generic product, 2 perishable product): ");
		int scelta = scan.nextInt();
		if(scelta == 1) {
			list = (LinkedList<T>) createLinkedList(Prodotto.class, scan, in);
		} else if(scelta == 2) {
			list = (LinkedList<? extends T>) createLinkedList(ProdottoDeperibile.class, scan, in);
		} else {
			System.out.println(" Wrong product type ");
			scan.close();
			return;
		}
		System.out.println(" Insert category name: ");
		String category = scan.next();
		magazzino.addList(list, category);
	}
	/*
	@SuppressWarnings("unchecked")
	private <T> List<T> createList(Class<T> classe, Scanner scan, InputStream in) {
		List<T> list = new Vector<>();
		char exit = 0;
		do {
			try {
				list.add((T) classe.getMethod("createIntance", InputStream.class).invoke(null, in));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			System.out.println(" terminate (y/n)?: ");
			exit = scan.next().charAt(0);
		} while (exit != 'y');
		return list;
	}
	*/
	@SuppressWarnings("unchecked")
	private <T> LinkedList<T> createLinkedList(Class<T> classe, Scanner scan, InputStream in) {
		LinkedList<T> list = new LinkedList<>();
		char exit = 0;
		do {
			try {
				list.add((T) classe.getMethod("createIntance", InputStream.class).invoke(null, in));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			System.out.println(" terminate (y/n)?: ");
			exit = scan.next().charAt(0);
		} while (exit != 'y');
		return list;
	}
	
	private <T> void removeList(Magazzino<T> magazzino, Scanner in) {
		System.out.println(" Insert category name: ");
		String category = in.next();
		if(magazzino.removeList(category)) {
			System.out.println(" List of products correctly removed ");
		} else {
			System.out.println(" MIssing category, no removal done ");
		}
	}

	
	private <T,K extends Writer> void stampa(Magazzino<T> magazzino, K out) throws IOException {
		out.write("Storehouse current state\n");
		out.write(magazzino.toString() + "\n");		
		out.flush();
	}
}
