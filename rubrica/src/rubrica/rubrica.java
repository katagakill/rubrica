package rubrica;
import java.util.Scanner;

public class rubrica {
	private int Ncontatti=100;// in caso di future implemntazioni che richiedano più di un vettore
	private persona[] elenco = new persona[Ncontatti];// rubrica creata per contenere 100 contatti
	

public void initRubrica() {
	int i;
	for (i=0;i<100;i++) {//  metodo  inizializzazione  rubrica
		elenco[i] = null;
	}

}

public void inserisci() {// metodo per inserire  un nuovo contatto
	int i;
	Scanner tastiera = new Scanner(System.in);
	for (i=0;i<elenco.length;i++){// ricercap rima posizione  libera
		if (elenco[i]==null) {//controllo  se  la posizione  e' vuota
			elenco[i]=new persona();
			System.out.println("Inserisci i dati della persona:");
			System.out.print(" -- nome: "); 
			elenco[i].setNome(tastiera.next());//assegna  nome
			System.out.print(" -- cognome: "); 
			elenco[i].setCognome(tastiera.next());//assegna cognome
			System.out.print(" -- numero telefono: "); 
			elenco[i].setNumero(tastiera.next());
			System.out.print(" -- indirizzo: ");
			elenco[i].setIndirizzo(tastiera.next());//asegna indirizzo
			System.out.print(" -- numero civico: ");
			elenco[i].setNumerocivico(tastiera.nextInt());//assegna  numero  civico
			break;
		}

	}
}
public  void  cancella() {//cancella un contatto
	//**CANCELLA TUTTI I  CONTATTI  CON LO  STESSO COGNOME**//
	String ricerca;//varibile  di ricerca
	String compara;//varibile che assume il  valore della stringa cognome
	Scanner tastiera= new  Scanner(System.in);
	System.out.println("inserisci il  cognome della  persona di  cui vuoi rimuovere  il  contatto");
	ricerca=tastiera.next();
	for(int i=0;i<elenco.length;i++) {//ricerca  delle  pozioni  diverse  da null
		if(elenco[i]!=null) {//compara ogni  posizione diversa da  null
			compara=elenco[i].getCognome();
			if(ricerca.equalsIgnoreCase(compara)==true) {//vvalore   booleano  per comparare ricerca a stringa, se risultano  uguali(true) "cancella" il contatto
				elenco[i]=null;
			}
		}
			}
	
}
public void  ricerca() {//ricerca di un contatto
	//**I CONTATTI 
	int opzione;//si collega all menù 
	int flag=0;//
	String compara;//stringa che assume il cognome contenuto nella posizione attuale dell indice
	String ricerca;
	Scanner tastiera = new Scanner(System.in);
	System.out.println("vuoi ricercare  il  contatto per  cognome(opzione1)o per numero  di cellulare(opzione2)");
	opzione=tastiera.nextInt();
	
	do {//il clico si ripete fin quando non viene inserito una varibile che non sia 1/2 ossia per ricercare contatti (case 1 ricerca per cognome) (case 2 ricerca per numero di telefono)
		switch(opzione) {
		case  1:
			System.out.println("inserisci il  cognome del  contatto che vuoi  trovare");
			ricerca=tastiera.next();
			for(int i=0;i<elenco.length;i++) {//ciclo per la ricerca del contatto inserito (per cognome)
				if(elenco[i]!=null) {//se la psozione non è vuota viene fatto il paragone con la stringa da te inserita(varibile ricerca e la varibile contenuta nella cella del vettore)
					compara=elenco[i].getCognome();
					if(ricerca.equalsIgnoreCase(compara)==true) {
						System.out.println("il numero di telefono di "+compara+"e':"+elenco[i].getNumero()+"");
						flag=1;
					}
				}
			}
			if(flag==0) {// segnalazione dell'inesistenza del contato ricercato
				System.err.println("il contatto: "+ricerca+" non esiste");
			}
			
			break;
		case  2:
			System.out.println("inserisci il  numero del contatto che vuoi cercare");
			ricerca=tastiera.next();
			for(int i=0;i<elenco.length;i++) {//ciclo per la ricerca del contatto inserito (numero)
				if(elenco[i]!=null) {
					compara=elenco[i].getNumero();
					if(ricerca.equalsIgnoreCase(compara)==true) {// ripetizione di quello che viene eseguito disopra
						System.out.println("il  numero  che hai  inserito appartiene al  contatto:"+elenco[i].getCognome()+"");
						flag=1;
					}
				}
			}
			break;
		default:// se viene inserito un numero inseistente il menù si chiude
			System.err.println("come opzione  hai messo:  "+opzione+"  che  non  eiste/non e'  ancora stata  implementata");
			flag=1;
			break;
		}
	}while(flag==0);
}

}