package oop21.Quadrilateri;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Rettangolo r1 = new Rettangolo(25, 7);
    	Rettangolo r2 = new Rettangolo(7, 25);
    	System.out.println(r1);
    	System.out.println(r2);
    	
    	System.out.println(r1.equals(r2));
    	System.out.println(r1.compareTo(r2));
    	
    	Quadrato q1 = new Quadrato(7.33);
    	Quadrato q2 = new Quadrato(12);
    	System.out.println(q1);
    	System.out.println(q2);
    	
        System.out.println(q1.equals(q2));
        System.out.println(q1.compareTo(q2));
        System.out.println(r1.equals(q2));
        System.out.println(q1.compareTo(r2));
        System.out.println(r1.compareTo(q2));
        System.out.println(q1.hashClass());
        
        System.out.println(q1.serializza());
    }
}
