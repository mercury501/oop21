package oop21.urlTest;

import java.net.*; 
import java.io.*;

public class GetFile {
URL page;
public GetFile(String ur) {
try {
    this.page = new URL(ur);
} catch (MalformedURLException e) {
    System.out.println("Bad URL: "+page);
}
}
}


