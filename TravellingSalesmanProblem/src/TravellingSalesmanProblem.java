//Michael Schulz
//PR1 20.11.2018
public class TravellingSalesmanProblem {
	
	//Fill two dimensional Array
	public static void GenTable(int field[][])
	{
		//Go through the array vertical
		for(int i = 0;i<field.length;i++)
		{
			//Go through the array horizontal
			for(int k = 0;k<field.length;k++)
			{
				//Diagonal = 0;
				if(i==k)
				{
					field[i][k]=0;
				}
				//Else random number
				else
				{
					//Generate random number
					int place = (int)(Math.random()*10);
					//Random number = 0 -> generate new random number
					while(place == 0)
					{
						place = (int)(Math.random()*10);
					}
					//Set random number on field..
					field[i][k] = place;
				}	
			}
		}
		//Go through the array vertical
		for(int i = 0;i<field.length;i++)
		{
			//Go through the array horizontal
			for(int k = 0;k<field.length;k++)
			{
				//Symmetry of the field
				field[i][k]=field[k][i];
			}
		}
		//Go through the array vertical
		for(int i = 0; i <field.length; i++)
		{
			//Go through the array horizontal
			for(int k = 0; k <field.length; k++)
			{
				//Print out array:field
				System.out.print(field[i][k]);
			}
            //Not all numbers in a row ->we can check symmetry
			System.out.println();
		}

	}
	//Change order of cities to create a tour
	public static void vertauschen(int way[])
	{
		//Generate 10 random numbers
		for(int i = 0; i<10; i++)
		{
			int nu1 = (int)(Math.random()*10);
			int nu2 = (int)(Math.random()*10);
			//Free variable parameter to change nu1/nu2
			int c =0;
			//Save nu1 in variable c
			c = way[nu1];
			//Set nu1 to nu2
			way[nu1] = way[nu2];
			//Get nu1 value saved in variable c
			way[nu2] = c;
		}
	}
	//Change order of two cities
	public static void nimm2(int way2[],int duplicate[])
	{
		//Save way2[k] in duplicate[k]
		for(int k=0;k<10; k++)
		{
		duplicate[k]= way2[k];
		}
		//Generate 1 random number
		int nu1 = (int)(Math.random()*10);
		int nu2 = (int)(Math.random()*10);
		//If generated numbers the same change nu2 as long as they are different
		if(nu1==nu2)
		{
			while(nu1==nu2)
			{
				nu2 = (int)(Math.random()*10);
			}
		}
		//Free variable parameter to change duplicate[nu1]/duplicate[nu2]
		int c =0;
		//Save duplicate[nu1] in variable c
		c = duplicate[nu1];
		//Set duplicate[nu1] to duplicate[nu2]
		duplicate[nu1] = duplicate[nu2];
		//Get duplicate[nu1]value saved in variable c
		duplicate[nu2] = c;
	}
	//Count distance from city to city
	public static int laenge(int field[][],int array[])
	{
		int distance = 0;
		//Distance for 10 cities
		for(int k=0;k<array.length;k++)
		{
			//If k=9 go back to city 1 ->tour
			if(k==9)
			{
			distance = distance + field[array[k]][array[0]];
			}
			//If k<9 count distance
			else if(k<9)
			{
			distance = distance +field[array[k]][array[k+1]];
			}

		}
		return distance;
	}
	
	
	public static void main(String[] args) {
		
		//Declaration of the variables
		int field[][] = new int [10][10];
		int duplicate [] = new int [10];
		int route = 0;
		//Call method GenTable()
		GenTable(field);
		//Save values 0..9 in way[]
		int way [] = {0,1,2,3,4,5,6,7,8,9};
		//Call method vertauschen()
		vertauschen(way);
		System.out.println();
		//
		for(int i =0;i<10000;i++)
		{
			//Call method nimm2()
			nimm2(way,duplicate);
			//If new way < old way 
			if(laenge(field,duplicate)< laenge(field,way))
			{
				route++;
				System.out.println("");
				//Way[] gets the more efficient route from duplicate[]
				//(in duplicate[] the order changed)
				for(int k=0;k<10; k++)
				{
					way[k]= duplicate[k];
				}
				//Out print of the actually better/best route(distance)
				System.out.println("Strecke "+route+":"+laenge(field,way)+"km");
				//Out print of the actually better/best route(cities)
				for(int j=0;j<10; j++)
				{
					System.out.print(way[j]);
				}
				
			}
		}

	}
}

