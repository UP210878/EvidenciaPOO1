public class StackException
{
    public static void main(String[] args) 
    {
        try 
        {
            method1();
        } 
        catch (Exception exception)
        {
            System.err.printf("%s\n\n", exception.getMessage());
            exception.printStackTrace();
            StackTraceElement[] elementsTrack = exception.getStackTrace();

            System.out.println("\nTracking of row getStackTrace:");
            System.out.println("Class\t\t\tFile\t\t\tLine\tMethod");
            for (StackTraceElement elements : elementsTrack) 
            {
                System.out.printf("%s\t", elements.getClassName());
                System.out.printf("%s\t", elements.getFileName());
                System.out.printf("%s\t", elements.getLineNumber());
                System.out.printf("%s\n", elements.getMethodName());
            }
        }
    }
    public static void method1() throws Exception
    {
        method2();
    }
    public static void method2() throws Exception
    {
        method3();
    }
    public static void method3() throws Exception
    {
        throw new Exception(" The exception was launched in method3" );
    }
}