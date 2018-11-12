//Michael Schulz
//PR1 20.11.2018
public class TravellingSalesmanProblem {

	public static void main(String[] args) {
		
		/* -- COMMENT 1 --
		 * Hallo, willkommen bei meinem TravelingSalesmanProblem Tutorial.
		 * Dieses Tutorial ist rein zum verstehen gedacht und nicht zum abschreiben.
		 * Da die Lösungen sowiso geteilt werden, gibt es sie hier mit Kommentaren um alle Schritte zu erklären.
		 * Bitte lies alle Kommentare in nummerierter Reihenfolge durch.
		 */
		
		/*
		 * -- COMMENT 2 --
		 * Die main methode sollte inzwischen bekannt sein. Dies Methode wird am Anfang der Klasse ausgeführt.
		 * Sie ist public d.h. Sie ist auch aus anderen Klassen aufrufbar (bedenke, dass Main auch eine Klasse ist. 
		 * Da ich sie nur benutze um ein Objekt meiner anderen Klasse "TravelingSalesman" zu erstellen passiert hier nicht so viel).
		 * static d.h. Sie existiert schon bevor ein Objekt dieser Klasse erstellt wurde
		 * "String[] args" ist ein Array mit Strings, das die Parameter aus der Eingabezeile enthält (ist meistens nicht benuzt aber nötig)
		 */
			
			/* -- COMMENT 3 --
			 * Hier erstelle ich ein neues Objekt meiner TravelingSalesman Klasse
			 * Ich speichere es in einer Variable mit dem Typ "TravelingSalesman" und dem Variablennamen "Salesman"
			 * Ich übergebe zwei Integer als Parameter.
			 * Der Erste gibt an, wie viele Orte der Kaufmann bereisen soll
			 * Die Zweite gibt die Maximale Distanz zweier Orte an.
			 * Diese Variablen können genauso gut auch in der Klasse "hardgecoded" sein d.h. klar im Code definiert
			 * Dadurch könnte man allerdings nicht mehrere Kaufmänner mit unterschiedlichen Anzahlen an Orten erstellen
			 */
			// create a new salesman which travels 10 cities with a max distance of 100
			TravellingSalesman Salesman = new TravellingSalesman(10, 100);

			/* -- COMMENT 4 --
			 * Hier rufe ich die "printTable" Funktion auf, die mein Salesman Objekt besizt, da er von der Klasse TravelingSalesman ist
			 */
			// print the table of the salesman
			Salesman.printTable();

			/* -- COMMENT 5 --
			 * Hier rufe ich die "randomJourney" Funktion auf, die mein Salesman Objekt besizt, da er von der Klasse TravelingSalesman ist
			 * Einen Boolean-Parameter füge ich daher hinzu, da ich die Methode mit Output und (später) ohne benutze.
			 * Hier mit true sage ich sowas wie "gib mir aus, was du bekommst"
			 */
			// print a random journey for the salesman
			System.out.println("RANDOM JOURNEY");
			Salesman.randomJourney(true);

			/* -- COMMENT 6 --
			 * Hier rufe ich die "getBestJourney" Funktion auf, die mein Salesman Objekt besizt, da er von der Klasse TravelingSalesman ist
			 * Der Integer Parameter der Funktion "10000" ist die Anzahl an Verbesserungsversuchen, die ausprobiert werden sollen
			 */
			// print the best journey for the salesman
			System.out.println("BEST JOURNEY");
			Salesman.getBestJourney(10000);
		}

	}

