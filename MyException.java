public class MyException extends Exception
{
    private int errorCode;
    
    public MyException(int errorCode){
        this.errorCode = errorCode;
    }
    
    @Override
    public String getMessage()
    {
        return "MyException: Exception code " + errorCode;
    }
    
    public static void main(String[] args){
        int number;
        
        try{
            number = 22;
            
            if (number >= 0 && number <= 10){
                throw new MyException(111);
            }
            else if(number > 10 && number <= 20){
                throw new MyException(222);
            }
            else if(number > 20 && number <= 30){
                throw new MyException(333);
            }
        }catch(MyException ex){
            System.out.println(ex.getMessage());
        }
    }
}