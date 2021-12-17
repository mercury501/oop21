package oop21.multiSala;

import java.time.LocalDate;

public class Person {

    String name;
    String surname;

    LocalDate dob;

    public Person(String n, String s, LocalDate d)  {
        this.name = n;
        this.surname = s;
        this.dob = d;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname()  {
        return this.surname;
    }

    public LocalDate getDob()   {
        return this.dob;
    }

    public void setName(String n)   {
        this.name = n;
    }

    public void setSurname(String s)    {
        this.surname = s;
    }

    public void setDob(LocalDate d) {
        this.dob = d;
    }

    @Override
    public String toString()    {
        return "[ " + this.name + ", " + this.surname + ", " + this.dob.toString() + " ]";
    }
    
}
