package oop21.urlTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;

/**
 * Adapted from the teacher's slides
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        URLConnection conn=null; InputStreamReader in;
        BufferedReader data; String line;
        StringBuffer buf=new StringBuffer();
        GetFile urlw= new GetFile("https://www.google.it");
        try {
            conn=urlw.page.openConnection();
            conn.connect();
            System.out.println("Connessione aperta");
            in = new InputStreamReader(conn.getInputStream());
            data=new BufferedReader(in);
            System.out.println("Lettura dati...");
            while ((line=data.readLine())!=null) {
            buf.append(line+"\n");
            }
            System.out.print (buf.toString());
            } catch(IOException e){
            System.out.println("Errore IO:"+e.getMessage());
            }
    }
}
