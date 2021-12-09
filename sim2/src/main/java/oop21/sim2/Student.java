package oop21.sim2;

import java.util.List;

public class Student extends Person {
    String mat;
    List<Mark> MarkList;

    public Student( String nm, String snm, String mat, List<Mark> ML)   {
        super(nm, snm);
        this.setMat(mat);
        this.setMarkList(ML);
    }

    
    public void setMat(String mat)  {
        this.mat = mat;
    }

    public String getMat()  {
        return this.mat;
    }

    public void setMarkList(List<Mark> ML)  {
        this.MarkList = ML;
    }

    public List<Mark> getMarkList() {
        return this.MarkList;
    }
    
}
