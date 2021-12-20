package oop21.intercorso2;

public class Customer {
    String name;
    String surname;
    String streetAddress;
    String cityAddress;

    String phoneNumber;

    public Customer(String n, String s, String sA, String cA, String pN)  {
        this.name = n;
        this.surname = s;
        this.phoneNumber = pN;
        this.streetAddress = sA;
        this.cityAddress = cA;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname()  {
        return this.surname;
    }

    public String getStreetAddress()  {
        return this.streetAddress;
    }

    public String getCityAddress()  {
        return this.cityAddress;
    }

    public String getPhoneNumber()  {
        return this.phoneNumber;
    }

    public void setName(String n)   {
        this.name = n;
    }

    public void setSurname(String s)    {
        this.surname = s;
    }

    public void setStreetAddress(String a)    {
        this.streetAddress = a;
    }

    public void setCityAddress(String a)    {
        this.cityAddress = a;
    }

    public void setPhoneNumber(String p)    {
        this.phoneNumber = p;
    }

    @Override
    public String toString()    {
        return "Customer: [ " + this.name + ", " + this.surname + ", " + this.streetAddress + ", " + this.cityAddress + ", " + this.phoneNumber + " ]";
    }
    
}
