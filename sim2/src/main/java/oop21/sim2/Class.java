package oop21.sim2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Class {
    List <Professor> ProfessorList;
    List <Student> StudentList;
    String name;

    public Class(List <Professor> PL, List <Student> SL, String nm) {
        this.setName(nm);
        Optional <List <Professor>> inProfs = Optional.ofNullable(PL);
        inProfs.ifPresentOrElse(list -> {this.ProfessorList = list;}, () -> {this.ProfessorList = new ArrayList <Professor> ();});

        Optional <List <Student>> inStud = Optional.ofNullable(SL);
        inStud.ifPresentOrElse(list -> {this.StudentList = list;}, () -> {this.StudentList = new ArrayList <Student>();});
    }

    public void setName(String nm)  {
        this.name = nm;
    }

    public String getName() {
        return this.name;
    }

    public void setProfessorList(List <Professor> PL)   {
        this.ProfessorList = PL;
    }

    public List <Professor> getProfessorList()  {
        return this.ProfessorList;
    }

    public void setStudentList(List <Student> PL)   {
        this.StudentList = PL;
    }

    public List <Student> getStudentList()  {
        return this.StudentList;
    }

    public void addStudent(Student s)   {
        this.StudentList.add(s);
    }

    public void addProfessor(Professor p)   {
        this.ProfessorList.add(p);
    }

    @Override
    public String toString()    {
        return "Class: [Professors: " + this.ProfessorList + ", Students: " + this.StudentList + ", Name: " + this.name + "]";
    }


    
}
