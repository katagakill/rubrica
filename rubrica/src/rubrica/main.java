package rubrica;
import java.util.Scanner;

public class main {
	
	

	public static void main(String[] args) {
		int  i=0;//flag
		int scelta;//varibile di scelta 
		rubrica myrubrica= new rubrica();
		Scanner tastiera= new Scanner(System.in);// scanner per interazione con l'utente
		myrubrica.initRubrica();
		do {// controllo per la selezione dell'azione da compiere, se viene inserito 0 esce dal programma
			System.out.println("opzione 1 crea  contatto||opzione  2 ricerca  per numero/nome|| opzione 3 cancella contatto||opzione 0 esci dalla rubrica");
			scelta= tastiera.nextInt(); 
			switch(scelta) {
			case 1:
				System.out.println("ti  chiedero' i dati della persona di cui  vuoi creare  il contatto");
				myrubrica.inserisci();
				
				break;
			case 2:
				System.out.println("ricerco il contatto che mi  chiederai");
				myrubrica.ricerca();
				
				break;
			case 3:
				System.out.println("cancello il contatto che  mi chiederai");
				myrubrica.cancella();
				break;
			case  0:
				i=1;
				System.out.println("arrivederci");
				break;
			default: 
				System.err.println("come opzione  hai messo:  "+scelta+"  che  non  eiste/non e'  ancora stata  implementata");
				break;
			}
		}while(i==0);

	}

}
