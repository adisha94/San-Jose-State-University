import java.io.FileNotFoundException;

public class FileNotFoundTester
{
    public static void main(String[] args) throws FileNotFoundException
    {
        
        Salaries.main(new String[]{ "nosuchfile.txt" });
     
        System.out.println("Expected: File not found: nosuchfile.txt");    
    }
}
