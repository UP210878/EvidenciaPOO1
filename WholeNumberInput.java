import java.util.*;

public class WholeNumberInput
{
	public static void main(String[] args) 
	{
	    int[] vector = {20,45,76,1,34,567,423,6,3,5};
	    Scanner input = new Scanner(System.in);
		int index;
		boolean continueCycle = true;
		do{
		try{
		    System.out.print("Input a value between 0 and 9 ");
		    index = input.nextInt();
		    System.out.print ("In the index " + index + " the value stored is " + vector[index]);
		    continueCycle = false;
		}
		catch(InputMismatchException ex){
		    System.out.println("The value must be an integer");
		    input.nextLine();
		}
		catch(IndexOutOfBoundsException ex){
		    System.out.println("The value must be between 0 and 9");
		}
		}while (continueCycle);
	}
}

