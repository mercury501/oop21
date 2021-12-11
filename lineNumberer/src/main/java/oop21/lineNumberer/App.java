package oop21.lineNumberer;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner cli = new Scanner(System.in);
        System.out.println("Input file name: ");
        String fileName = cli.next();
        
        try {
            FileReader f = new FileReader(fileName);
            Scanner fsc = new Scanner(f);

            PrintWriter fo = new PrintWriter(fileName.replace(".txt", "_s.txt"));
            int lineNum = 1;
            while (fsc.hasNextLine())   {
                String line = fsc.nextLine();
                fo.println("/** " + lineNum + " **/" + line );
                System.out.println("/** " + lineNum + " **/" + line );
                lineNum++;
            }
        }
            catch (IOException e )  {
                e.printStackTrace();
            }
        System.out.println("Done!");
    }
}
