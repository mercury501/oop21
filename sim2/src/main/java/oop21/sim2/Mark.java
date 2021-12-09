package oop21.sim2;

public class Mark {
    int value;
    String subject;

    public Mark(int v, String s) throws Exception    {
        this.setMark(v);
        this.setSubject(s);
    }

    public void setMark(int v) throws Exception    {
        if (v < 0 || v > 10)
            throw new Exception("Vote out of range!");

        this.value = v;   
    }

    public int getMark()    {
        return this.value;
    }

    public void setSubject(String s)    {
        this.subject = s;
    }

    public String getSubject()  {
        return this.subject;
    }

}
