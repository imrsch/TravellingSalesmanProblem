public class TravellingSalesman {

	/*// amount of cities to visit
	private int amount;
	//max distance two cities can have
	private int maxDistance;
	//table to store the distances in
	private int[][] table;

	// constructor for the salesman
	public TravellingSalesman(int amount, int maxDistance) {
		this.amount = amount;
		this.maxDistance = maxDistance;

		// create cities for the salesman
		init();
	}

	// initialize the table with random values
	public void init() {

		//declare the table
		table = new int[amount][amount];

		// insert random values in the table
		for (int i = 0; i < amount; i++) {
			for (int j = 0; j < amount; j++) {
				
				// diagonal with 0s
				if (i == j) {
					table[i][j] = 0;
					// random values on the right side of the diagonal
				} else if (i < j) {
					
					int distance = (int) (Math.random() * maxDistance);

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

	// generate a random journey for the salesman to travel
	public int[] randomJourney(boolean output) {

		// save the order in which the places are visited
		int[] randomJourney = new int[amount];

		for (int i = 0; i < amount; i++) {
			randomJourney[i] = i;
		}
		
		// switch some random places in the journey
		for (int i = 0; i < amount; i++) {
			int buf = randomJourney[i];
			int rand = (int) (Math.random() * amount);
			randomJourney[i] = randomJourney[rand];
			randomJourney[rand] = buf;
		}
		
		// give an output if the boolean is true
		if (output) {

			// print out random journey places
			for (int i = 0; i < randomJourney.length; i++) {
				if (i == 0) {
					System.out.println("Stadt " + i + ": " + randomJourney[i] + ". Distance from last: 0");
				} else {
					System.out.println("Stadt " + i + ": " + randomJourney[i] + ". Distance from last: "
							+ table[randomJourney[i]][randomJourney[i - 1]]);
				}
			}

			System.out.println("Amount traveled = " + getLength(randomJourney));
		}
		// return the randomJourney for further usage
		return randomJourney;
	}

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

	// train for a given amount of rounds
	public void getBestJourney(int trainAmount) {

		// save the current best journey
		int[] currentJourney = randomJourney(false);
		System.out.println("First journey = " + getLength(currentJourney));

		// check for a different journey
		for (int i = 0; i < trainAmount; i++) {

			int[] gotJourney = changeJourneyUp(currentJourney);

			// save the journey if it is better
			if (getLength(gotJourney) < getLength(currentJourney)) {
				System.out.println("Got a better journey with " + getLength(gotJourney));
				currentJourney = gotJourney;
			}
		}

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
	}}
*/


