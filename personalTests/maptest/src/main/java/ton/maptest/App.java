package ton.maptest;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);

        Map test = new Map(20, 40, 3);

        test.printMap();
        while(true){
            test.addRoom();

            test.printMap();
            
            System.out.println("Add another room? y/n");
            if (!scan.nextLine().equals("y"))
                return;
        }

        
    }
}
