public class TravellingSalesman {
	
	/* -- COMMENT 7 --
	 * So. Neue Klasse neues Glück.
	 * Erstmal ein paar Variablen.
	 * Beachte, das sie nicht static sind d.h. sie sind erst dann initialisiert (erstellt), sobald ein Objekt der Klasse erstellt wird
	 * 
	 */
	// amount of cities to visit
	private int amount;
	//max distance two cities can have
	private int maxDistance;
	
	/*-- COMMENT 8--
	 * Hier erstelle ich mir mein neues leeres 2 dimensionales Array.
	 * Man kann sich das ganze so vorstellen:
	 * 
	 * array[2][5] lässt sich so vorstellen:
	 * 
	 * 		[ ] [ ] [ ] [ ] [ ]
	 * 		[ ] [ ] [ ] [ ] [ ]
	 * 
	 * Die Position der einzelnen Elemente ist dann:
	 * 
	 * 		array[0][0] |array[0][1] |array[0][2] |array[0][3] |array[0][4] |
	 *      ____________|____________|____________|____________|____________|
	 * 		array[1][0] |array[1][1] |array[1][2] |array[1][3] |array[1][4] |
	 * 
	 * D.h. wenn man ein bestimmten Wert bekommen möchte sagt man z.B.
	 * 
	 * 		int x = array[0][0];
	 * 		x ist dann der Wert, der an Stelle array[0][0] gespeichert ist
	 * 
	 *  !!!VORSICHT!!!
	 *  
	 *  Die Zahl die man bei der deklaration hineinschreibt zb. array[10][10] ist die Anzahl der Elemente
	 *  Da Arrays aber mit "Offset"(Distanz) arbeiten d.h. "Schritte vom ersten Wert entfernt"
	 *  ist [0][0] der aller erste Wert des ersten Arrays.
	 *  Wohingegen z.b. [0][10] nicht aufrufbar ist. Da 10 Schritte vom ersten Element [0] entfernt man beim 11. Element landet
	 *  Da das Array nur 10 Stellen hat, ist man über den Arraygrenzen hinaus
	 */
	//table to store the distances in
	private int[][] table;

	/* -- COMMENT 9 --
	 * 
	 * Die main Methode wird in dieser Klasse nicht benötigt
	 */
	//not needed
	public static void main(String[] args) {
	}

	/*-- COMMENT 10 --
	 * Das ist der Konstruktor. Erkennbar daran, dass er keinen Rückgabewert (void, int,...) hat und den Klassennamen besizt
	 * Dieser wird in der Main Klasse in Zeile 31 ausgeführt, sobald das neue Objekt erstellt wurde.
	 * Wie in COMMENT 3 bereits erklärt wird in diesem Programm "int amount" auf 10 und "int MaxDistance" auf 100 gesezt.
	 * 
	 * "this.amount" ist die Variable in Zeile 10 wohingegen nur "amount" der bekommene Wert 10 ist.
	 * Damit wir mit diesem Wert weiterarbeiten können setzen wir die "globale"(in der gesammten Klasse benutzbare) Variable
	 * auf den Wert der lokalen Variable nur "amount"
	 * Das selbe mit maxDistance.
	 * 
	 * Am Ende der Konstruktor-Methode wird das Programm initialisiert. Hier wird der table befüllt.
	 * Alle Dinge, die später bei den Funktionen wie randomJourney gebraucht werden.
	 */
	// constructor for the salesman
	public TravellingSalesman(int amount, int maxDistance) {
		this.amount = amount;
		this.maxDistance = maxDistance;

		// create cities for the salesman
		init();
	}

	/*-- COMMENT 11 --
	 * 
	 * WICHTIG! HIER PASSIERT VIEL.
	 * 
	 * Diese Methode setzt die Werte in der Tabelle wie in Aufgabe 1 beschrieben
	 * 
	 */
	
	// initialize the table with random values
	public void init() {

		/* -- COMMENT 12 --
		 * Ich setzte zuerst die Tabelle auf eine 2 dimensionale Matrix aus Integern mit der Größe "Anzahl der Städte" * "Anzahl der Städte"
		 * 
		 * Ich speichere dabei keine Städtenamen in der Tabelle und nur die Distanzen.
		 * 
		 * Beispiel:
		 * 
		 *   A B C D E F
		 * A 0 3 5 9 7 4
		 * B 3 0 1 8 3 9
		 * C 5 1 0 2 1 7
		 * D 9 8 2 0 3 2
		 * E 7 3 1 3 0 1
		 * F 4 9 7 2 1 0
		 * 
		 * BEACHTE: Ich speichere in einer Spalte immer die DISTANZ zwischen einer Stadt und allen anderen Städten
		 * 
		 * 	Da ich die Städtenamen (A,B,C,...) nicht speichere sieht mein 2 dimensionales Array eigentlich so aus:
		 * 
		 *  0 3 5 9 7 4
		 *  3 0 1 8 3 9
		 *  5 1 0 2 1 7
		 *  9 8 2 0 3 2
		 *  7 3 1 3 0 1
		 *  4 9 7 2 1 0
		 * 
		 * 
		 *  Wenn ich jetzt den Wert von array[0][1] möchte ist das "3"
		 *  Das sagt mir aus: "Von Stadt B zu Stadt A ist die Distanz 3"
		 */
		
		//declare the table
		table = new int[amount][amount];
		
		/*--COMMENT 13 --
		 * Ich benutze eine doppelte For-Schleife um einmal durch mein neu erstelltes array zu gehen
		 * Man kann sich das so vorstellen als würde man mit der ersten For-Schleife durch die einzelnen Zeilen gehen
		 * und dann mit der inneren die Spalten von links nach rechts durch
		 */
		// insert random values in the table
		for (int i = 0; i < amount; i++) {
			for (int j = 0; j < amount; j++) {
				
				/* -- COMMENT 14 --
				 * Ich unterscheide 3 Fälle.
				 * Entweder Ich bin im Bereich oben rechts des Arrays 
				 * Oder ich bin auf der mittleren Spiegelachse
				 * Oder ich bin im Bereich unten links des Arrays
				 * 
				 * Wenn i und j gleich sind dann befinde ich mich auf der Diagonalen und muss den Wert 0 setzen (am besten auf Papier nachrechnen)
				 * 
				 * Wenn ich oben rechts bin setze ich den Wert auf einen Random Wert
				 * 
				 * Wenn ich unten links bin kopiere ich mir den Wert gespiegelt mit der Diagonalen oben rechts
				 * 
				 * Beispiel: 
				 *  0 3 5 9 7 4
				 *  3 0 1 8 3 9
				 *  5 1 0-2-1 7
				 *  9 8<2>0 3 2
				 *  7 3 1 3 0 1
				 *  4 9 7 2 1 0
				 *  
				 *  Wie vorhin erklärt ist z.b. der Wert bei array[3][2] die 2 (sie ist mit <> markiert)
				 *  
				 *  Es fällt auf, dass die gespiegelte 2 (mit -- markiert) im array bei position array[3][2] sizt.
				 *  
				 *  D.h. ist die Position unten links [x][y] der gleiche Wert wie bei [y][x]
				 *  
				 *  Um zu schauen ob der derzeitige Wert in der oberen oder untern Hälfte liegt kann man i mit j vergleichen
				 *  wenn i (die derzeitige Zeile) kleiner ist als j (die Spalte) ist man im Bereich oben rechts
				 *  Wenn i größer ist als j ist man in dem Bereich unten links
				 */
				
				// diagonal with 0s
				if (i == j) {
					table[i][j] = 0;
					// random values on the right side of the diagonal
				} else if (i < j) {
					
					int distance = (int) (Math.random() * maxDistance);
					//Distanz darf nicht 0 sein
					while (distance == 0) {
						distance = (int) (Math.random() * maxDistance);
					}
					table[i][j] = distance;
					// copy the random values of the right side
				} else if (i > j) {
					table[i][j] = table[j][i];
				}
			}
		}
	}

	/*--COMMENT 15 --
	 * Eine Methode mit einem Parameter, welcher sagt ob die Länge der Strecke der Reise ausgegeben werden soll oder nicht
	 * Sie gibt ein Array zurück, das man entweder weiterbenutzen kann oder wie in der Main nicht.
	 * 
	 */
	// generate a random journey for the salesman to travel
	public int[] randomJourney(boolean output) {
		
		/*--COMMENT 16--
		 * Eine neue Reise, die alle Städte besucht, weshalb die Größe die Anzahl an Städte sein muss 
		 */
		// save the order in which the places are visited
		int[] randomJourney = new int[amount];

		/* -- COMMENT 17 --
		 * Das array wird erst auf (1,2,3,4,5,6,7,8,...) gesetzt.
		 */
		for (int i = 0; i < amount; i++) {
			randomJourney[i] = i;
		}
		
		/* -- COMMENT 18 --
		 * Selber mechanismus, wie wir beim Bubblesort angeschaut haben
		 * Dieser Codeabschnitt tauscht einfach random die Werte im Array herum
		 */
		// switch some random places in the journey
		for (int i = 0; i < amount; i++) {
			int buf = randomJourney[i];
			int rand = (int) (Math.random() * amount);
			randomJourney[i] = randomJourney[rand];
			randomJourney[rand] = buf;
		}
		
		// give an output if the boolean is true
		if (output) {

			/*--COMMENT 19 --
			 * Gibt alle besuchten Städte in der Reihenfolge aus und gibt an, welche distanz zwischen den beiden Städten ist
			 * 
			 * WICHTIGES BEISPIEL:
			 * 
			 *  0 3 5 9 7 4
			 *  3 0 1 8 3 9
			 *  5 1 0 2 1 7
			 *  9 8 2 0 3 2
			 *  7 3 1 3 0 1
			 *  4 9 7 2 1 0
			 *  
			 *  Das ist mein table
			 *  
			 *  Ich habe jetzt den Journey 1,2,3,4,5,6
			 *  
			 *  D.h. ich besuche erst die Stadt 1. Die bisherige Distanz ist 0.
			 *  Dann gehe ich zur 2. Dafür schaue ich an array[0][1]. (Nicht vergessen array[0][0] ist die distanz von Stadt 1 zu 1)
			 *  Ich habe meine Reise in dem Array "journey = {0,1,2,3,4,5,6}" gespeichert
			 *  d.h. journey[0] ist die Stadt 0 und journey[1] ist die Stadt 1
			 * 	ich rufe dann in meinem table die position table[ journey[1] ][ journey[0] ]
			 * 	auf das ist gleich wie table[1][0], nur das es die Stadt nimmt, die an der Position in der Reise steht
			 */
			// print out random journey places
			for (int i = 0; i < randomJourney.length; i++) {
				if (i == 0) {
					System.out.println("Stadt " + i + ": " + randomJourney[i] + ". Distance from last: 0");
				} else {
					System.out.println("Stadt " + i + ": " + randomJourney[i] + ". Distance from last: "
							+ table[randomJourney[i]][randomJourney[i - 1]]);
				}
			}
			/* -- COMMENT 20 -- 
			 * getLength kommt gleich...
			 */
			System.out.println("Amount traveled = " + getLength(randomJourney));
		}
		// return the randomJourney for further usage
		return randomJourney;
	}

	/* -- COMMENT 21 --
	 * 
	 * getLength nimmt ein array und checkt die Werte auf der Tabelle um zu schauen, wie weit die komplette Distanz der Reise ist
	 * 
	 * Dafür speichere ich mir das Endergebnis in einem Integer "traveledAmount"
	 * 
	 * Ich speichere mir alle Distanzen der Punkte in einem array bsp: 0 -> 0 ist 0
	 * 																   0 -> 2 ist 10
	 * 																   2 -> 7 ist 30
	 * 																distance = {0,10,30}
	 * Dann addiere ich alle Distanzen aufeinander und am Ende noch die Distanz von der letzen Stadt bis zur Ersten
	 */
	// returns the length a journey takes
	private int getLength(int[] journey) {

		// save the distances between two places in an array
		int[] distance = new int[amount];

		// save the distances between two places
		for (int i = 0; i < distance.length - 1; i++) {
			distance[i] = table[journey[i]][journey[i + 1]];
		}
		// count the distances together
		int traveledAmount = 0;
		for (int i = 0; i < distance.length; i++) {
			traveledAmount += distance[i];
		}
		// return to journey start point
		traveledAmount += table[journey[journey.length - 1]][journey[0]];
		return traveledAmount;
	}

	/*--COMMENT 22 --
	 * 
	 * Das ist ziemlich basic. Ich lasse mir meine Tabelle auf dem Bildschirm ausgeben durch eine doppelte For-Schleife
	 * Alles extra ist nur, damit die Tabelle gut aussieht
	 * Das die Tabelle hässlich wird, wenn die zahlen 99 übersteigen ist mir bewusst aber ich habe es nicht als nötig empfungen dafür extra etwas einzubauen
	 * 
	 */
	public void printTable() {
		System.out.println("Table:\n________________________________________");
		// print the table to the screen
		for (int i = 0; i < amount; i++) {
			for (int j = 0; j < amount; j++) {
				if (table[i][j] < 10) {
					System.out.print("| " + table[i][j] + "|");
				} else {
					System.out.print("|" + table[i][j] + "|");
				}
			}
			System.out.println("\n|__||__||__||__||__||__||__||__||__||__|");
		}
	}

	/* --COMMENT 23 --
	 * 
	 * Ab jetzt wird es spaßig.
	 * Man startet mit einer zufälligen Reise und ändert die Positionen zweier Städte.
	 * Wenn das Ergebnis kürzer ist, macht man damit weiter, sonst nicht
	 */
	// train for a given amount of rounds
	public void getBestJourney(int trainAmount) {
		
		/*--COMNMENT 24--
		 * Das array currentJourney speichert die bisher beste Reise
		 */
		// save the current best journey
		int[] currentJourney = randomJourney(false);
		System.out.println("First journey = " + getLength(currentJourney));

		/*--COMNMENT 25--
		 * Ich lasse das Programm so oft ausprobieren, wie ich angegeben habe
		 */
		// check for a different journey
		for (int i = 0; i < trainAmount; i++) {
			
			/*--COMMENT 26--
			 * Ich gebe das derzeitige beste Array in meine Funktion, die zwei beliebige Städte umdreht
			 */
			int[] gotJourney = changeJourneyUp(currentJourney);
			
			/*--COMMENT 27
			 *  Wenn die Reisedistanz des neuen besser ist, dann wird es übernommen sonst wird das alte behalten
			 */
			// save the journey if it is better
			if (getLength(gotJourney) < getLength(currentJourney)) {
				System.out.println("Got a better journey with " + getLength(gotJourney));
				currentJourney = gotJourney;
			}
		}
		
		/* --COMMENT 28--
		 * Das ist nur noch Ausgabe der besten Reise
		 */
		System.out.println("Best journey I found was with " + getLength(currentJourney));

		// print out random journey places
		for (int i = 0; i < currentJourney.length; i++) {
			if (i == 0) {
				System.out.println("Stadt " + i + ": " + currentJourney[i] + ". Distance from last: 0");
			} else {
				System.out.println("Stadt " + i + ": " + currentJourney[i] + ". Distance from last: "
						+ table[currentJourney[i]][currentJourney[i - 1]]);
			}
		}
	}

	/* --COMMENT 29--
	 * Diese Funktion nimmt ein Array.
	 * Beachte, dass das array als Referenz übergeben wird und daher jede Änderung auch an dem übergebenen übernommen wird
	 * Da wir das bei unserem currentJourney nicht wollen, speichern wir uns alle Werte in einer Kopie
	 * Dann werden nur noch 2 random Städte in der Reise geändert und das Array zurück gegeben
	 */
	private int[] changeJourneyUp(int[] currentJourney) {
		// save a copy of the current journey
		int[] copyOfcurrentJourney = new int[amount];
		for (int i = 0; i < copyOfcurrentJourney.length; i++) {
			copyOfcurrentJourney[i] = currentJourney[i];
		}
		// switch some random places in the journey
		int rand1 = (int) (Math.random() * amount);
		int rand2 = (int) (Math.random() * amount);
		int buf = copyOfcurrentJourney[rand1];
		copyOfcurrentJourney[rand1] = copyOfcurrentJourney[rand2];
		copyOfcurrentJourney[rand2] = buf;
		return copyOfcurrentJourney;
	}
	/*--COMMENT 30--
	 * So...
	 * Ich hoffe es war alles ausführlich und gut erklärt.
	 * Natürlich gibt es bessere Wege und eventuelle Fehler im Programm.
	 * Wenn du welche findest, bitte teile es mir mit
	 * 
	 * Danke für's lesen und teile mir bitte mit, wenn es dir geholfen hat. Hat immerhin 3 Stunden gedauert die Kommentare zu schreiben...
	 * 
	 * Nicht vergessen: Nicht Kopieren sondern Verstehen ist das worauf es ankommt!
	 * 
	 * Viel Spaß beim Programmieren!
	 */
}

