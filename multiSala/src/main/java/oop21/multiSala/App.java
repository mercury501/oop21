package oop21.multiSala;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

       List <Movie> cinema = new ArrayList<>();

        

        cinema.add(new Movie("La Vendetta dei Pith", List.of(
            new Actor("Armando", "Pero", LocalDate.of(1961, 5, 6)), new Actor("Piere", "OPiere", LocalDate.of(1992, 07, 06)), 
            new Actor("Lello", "Bidello", LocalDate.of(1995, 10, 5))), new Director("Tonnaso", "Biagiozzi", LocalDate.of(1992, 4, 22))));

        cinema.add(new Movie("Il ritorno del Pero", List.of(
            new Actor("Francesco", "Baglio", LocalDate.of(1990, 4, 7)), new Actor("Federico", "Altresi", LocalDate.of(1986, 3, 6))),
            new Director("Dado", "Concettina", LocalDate.of(1997, 12, 12))));
        
        cinema.add(new Movie("Bene ma non Benissimo", List.of(
            new Actor("Massimo", "Alfredi", LocalDate.of(1960, 4, 7)), new Actor("Ugo", "Scuro", LocalDate.of(1956, 1, 6))),
            new Director("Dado", "Concettina", LocalDate.of(1997, 12, 12))));

        cinema.add(new Movie("Io Speriamo che me la Lambda", List.of(
            new Actor("Armando", "Pero", LocalDate.of(1961, 5, 6)), new Actor("Federico", "Altresi", LocalDate.of(1986, 3, 6))),
            new Director("Lello", "Bidello", LocalDate.of(1995, 10, 5))));

        cinema.add(new Movie("Non ci resta che malloc", List.of(
            new Actor("Armando", "Pero", LocalDate.of(1961, 5, 6)), new Actor("Piero", "Pierisi", LocalDate.of(1936, 9, 6)), new Actor("Anita", "LaDespacito", LocalDate.of(1996, 11, 2))),
            new Director("Lello", "Bidello", LocalDate.of(1995, 10, 5))));
        System.out.println(cinema + "\n\n");

        System.out.println("Movies with at least 3 actors: " +
            cinema.stream().filter(m -> m.getCast().size() >= 3).toList()  + "\n\n"
            );        


        List <Movie> ml = new ArrayList(cinema.stream().toList());

        Comparator <Movie> dirAge = (m1, m2) -> {
            LocalDate m1Dob = m1.getDirector().getDob();
            LocalDate m2Dob = m2.getDirector().getDob();
            
            if (m1Dob.compareTo(m2Dob) < 0)
                return 1;
            return 0;
        };

        Collections.sort(ml, dirAge);

        System.out.println("Movies in order of director's date of birth: "  +
            ml + "\n\n"
        );

        List <Actor> oldFellows = cinema.stream().flatMap(m -> m.getCast().stream()).distinct().toList();
        
        System.out.println("Actors older than 1940: " +
            cinema.stream().flatMap(
                m -> m.getCast().stream().filter(
                    a -> a.getDob().isBefore(LocalDate.of(1940, 1, 1)) 
                )
                )
            .toList() + "\n\n"
        );

       

    }
}