package oop21.intercorso2;

import java.util.List;

public class MenuItem {
    String desc;
    int quantity;
    String type;
    static List <String> validTypes = List.of("Appetizer", "Main Course", "Second Course");

    /**
     * 
     * @param d description
     * @param q quantity
     * @param t type
     * @throws Exception
     */
    public MenuItem (String d, int q, String t) throws Exception {
        if (!validTypes.contains(t))
            throw new Exception("Invalid MenuItem type!");
        this.desc = d;
        this.quantity = q;
        this.type = t;        
    }

    public String getDescription()  {
        return this.desc;
    }

    public int getQuantity()    {
        return this.quantity;
    }

    public String getType() {
        return this.type;
    }

    static public List <String> getValidTypes()    {
        return validTypes;
    }

    public void setDescription(String d)    {
        this.desc = d;
    }

    /**
    @param q quantity of menuItems
    */
    public void setQuantity(int q)  {
        this.quantity = q;
    }

    /**
     * 
     * @param t type
     * @throws Exception
     */
    public void setType(String t) throws Exception   {
        if (!validTypes.contains(t))
            throw new Exception("Invalid MenuItem type!");
        this.type = t;
    }
    
    @Override
    public String toString()    {
        return "MenuItem: [ " + this.desc + ", " + this.type + ", " + this.quantity + " ]";
    }
}
