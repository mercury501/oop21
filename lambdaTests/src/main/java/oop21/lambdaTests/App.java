package oop21.lambdaTests;

/**
 * Hello world!
 *
 */

interface StringFormat  {
    String run(String str);
}

public class App 
{

    public static String formatString(String str, StringFormat sf)  {
        return sf.run(str);
    }

    public static void main( String[] args )
    {
        StringFormat test = (n) -> n + " test";
        StringFormat exclaim = (n) -> n + " !!!";

        System.out.println( formatString("Hello World", test));
        System.out.println( formatString("Hello World", exclaim));
    }
}
