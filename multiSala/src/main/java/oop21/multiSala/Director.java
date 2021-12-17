package oop21.multiSala;

import java.time.LocalDate;

public class Director extends Person {
    public Director(String n, String s, LocalDate d)  {
        super(n, s, d);
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
        return "Director: " + super.toString();
    }
}
