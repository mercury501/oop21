package oop21.sim2;

public class Professor extends Person {
    String subject;

    public Professor(String nm, String snm, String sbj) {
        super(nm, snm);
        this.setSubject(sbj);
    }

    public void setSubject(String sbj)  {
        this.subject = sbj;
    }

    public String getSubject()  {
        return this.subject;
    }

    @Override
    public String toString()    {
        return "Professor: [Subject: " + this.subject + " " + super.toString() + "]";
    }
    
    @Override
    public boolean equals(Object pf) {
        Professor temp = (Professor) pf;
        return this.getSubject().equals(temp.getSubject()) && super.getName().equals(temp.getName()) && super.getSurname().equals(getSurname());
    }
}
