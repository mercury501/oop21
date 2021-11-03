package oop21.disegnaFigure;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Punto p1 = new Punto(0,5);
        Punto p2 = new Punto(10,5);
        Punto p3 = new Punto(20,10);
        Triangolo tri = new Triangolo(p1, p2, p3);
        
        System.out.println(tri.toString());
        System.out.println("Il baricentro è: " + tri.baricentro());
    }
}
