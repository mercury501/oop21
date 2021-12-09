package oop21.sim2;

public class Person {
    String name;
    String surname;

    public Person(String n, String s)  {
        this.setName(n);
        this.setSurname(s);
    }

    public Person(Person p) {
        this.name = p.getName();
        this.surname = p.getSurname();
    }

    public void setName(String n)   {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public void setSurname(String s)    {
        this.surname = s;
    }

    public String getSurname()  {
        return this.surname;
    }

    @Override
    public String toString()    {
        return "Person: [Name: " + this.name + ", Surname: " + this.surname + "]";
    }

    @Override
    public boolean equals(Object p) {
        Person temp = (Person) p;
        return this.getName().equals(temp.getName()) && this.getSurname().equals(temp.getSurname());
    }

}
