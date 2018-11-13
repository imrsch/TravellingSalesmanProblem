//Michael Schulz
//PR1 20.11.2018
public class TravellingSalesmanProblem {
	
	public static void GenTable(int field[][])
	{
		for(int i = 0;i<field.length;i++)
		{
			for(int k = 0;k<field.length;k++)
			{
				if(i==k)
				{
					field[i][k]=0;
				}
				else
				{
					int PH = (int)(Math.random()*10);
					while(PH == 0)
					{
						PH = (int)(Math.random()*10);
					}
					field[i][k] = PH;
				}	
			}
		}
		for(int i = 0;i<field.length;i++)
		{
			for(int k = 0;k<field.length;k++)
			{
				field[i][k]=field[k][i];
			}
		}
		for(int i = 0; i <10; i++)
		{
			for(int k = 0; k <10; k++)
			{
				System.out.print(field[i][k]);
			}

			System.out.println();
		}

	}
	public static void vertauschen(int way[])
	{
		//random index
		for(int i = 0; i<10; i++)
		{
			int zahl1 = (int)(Math.random()*10);
			int zahl2 = (int)(Math.random()*10);
			//Platzhalter zum tauschen
			int c =0;
			c = way[zahl1];
			way[zahl1] = way[zahl2];
			way[zahl2] = c;
		}
	}
	
	public static void main(String[] args) {
		
		
		int field[][] = new int [10][10];
		GenTable(field);
		

		int way [] = {0,1,2,3,4,5,6,7,8,9};
		vertauschen(way);
		System.out.println();
		for(int i = 0; i < 10; i++)
		{
			System.out.println(way[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			/*// create a new salesman which travels 10 cities with a max distance of 100
			TravellingSalesman Salesman = new TravellingSalesman(10, 100);

			// print the table of the salesman
			Salesman.printTable();

			// print a random journey for the salesman
			System.out.println("RANDOM JOURNEY");
			Salesman.randomJourney(true);

			// print the best journey for the salesman
			System.out.println("BEST JOURNEY");
			Salesman.getBestJourney(10000);*/
	}
}

