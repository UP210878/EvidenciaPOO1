import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero
{
  public static int cociente (int numerator, int denominator)
  {
    return numerator / denominator;
  }
  public static void main (String[]args)
  {
    Scanner input = new Scanner (System.in);
    boolean continueCycle	 = true;
    do
      {
	try			
	{

	  System.out.print ("Introduzca un numerador entero: ");
	  int numerator = input.nextInt ();
	  System.out.print ("Introduzca un denominador entero: ");
	  int denominator = input.nextInt ();

	  int result = cociente (numerator, denominator);

	  System.out.print (result);
	  continueCycle = false;
	}
	catch (InputMismatchException inputMismatchException)
	{
	  System.err.printf ("\nExcepcion: %s \n", inputMismatchException);
	  input.nextLine ();
	  System.
	    out.println ("Debe introducir enteros, intente de nuevo. \n");
	}
	catch (ArithmeticException arithmeticException)
	{
	  System.err.printf ("\nExcepcion: %s \n", arithmeticException);
	  System.out.println ("El denominator no puede ser cero \n");
	}
      }
    while (continueCycle);	
  }
}				