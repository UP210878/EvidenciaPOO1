import java.util.Scanner;
public class DivideByZeroNoExceptions
{
  public static int division (int numerator, int denominator)
  {
    return numerator / denominator;
  }
  public static void main (String[]args)
  {
    Scanner input = new Scanner (System.in);
    System.out.print ("Introduzca un numerador entero: ");
    int numerator = input.nextInt ();
    System.out.print ("Introduzca un denominador entero: ");
    int denominator = input.nextInt ();
    int result = division (numerator, denominator);
    System.out.print (result);
}}