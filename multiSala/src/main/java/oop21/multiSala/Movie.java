package oop21.multiSala;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Movie {
    String title;
    List <Actor> cast;
    Director director;

    public Movie(String t, List <Actor> c, Director d)  {
        this.title = t;
        Optional <List <Actor>> cst = Optional.ofNullable(c);
        cst.ifPresentOrElse(ls ->{ this.cast = ls; }, () -> { this.cast = new ArrayList<>();} );

        this.director = d;
    }

    public String getTitle()    {
        return this.title;
    }

    public List <Actor> getCast()   {
        return this.cast;
    }

    public Director getDirector()   {
        return this.director;
    }

    public void setTitle(String t)  {
        this.title = t;
    }  

    public void setCast(List <Actor> al)    {
        this.cast = al;
    }

    public void setDirector(Director d) {
        this.director = d;
    }

    @Override 
    public String toString()    {
        return "Movie: [ " + this.title + ", " + this.director.toString() + ", " + this.cast + " ]";
    }


}
