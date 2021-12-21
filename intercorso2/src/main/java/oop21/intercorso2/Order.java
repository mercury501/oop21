package oop21.intercorso2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Order {
    LocalDate date;
    Customer cust;
    List <MenuItem> itemList;

    public Order(LocalDate d, List<MenuItem> iL, Customer c)    {
        Optional <List <MenuItem>> temp = Optional.ofNullable(iL);
        temp.ifPresentOrElse(l -> {this.itemList = l;}, () -> {this.itemList = new ArrayList <MenuItem>();});
        this.date = d;
        this.cust = c;
    }

    public void setDate(LocalDate d)    {
        this.date = d;
    }

    public void setCustomer(Customer c) {
        this.cust = c;
    }

    public void setItemList(List <MenuItem> l)  {
        this.itemList = l;
    }

    public LocalDate getDate()  {
        return this.date;
    }

    public Customer getCustomer()   {
    return this.cust;
    }

    public List<MenuItem> getItemList() {
        return this.itemList;
    }


    public int getCostOrder()   {
        Map <String, Integer> mp = new HashMap<>();
        Map <String, Integer> costs = Map.of("Appetizer", 5, "Main Course", 10, "Second Course", 13);

        List <String> types = MenuItem.getValidTypes();
        Iterator <String> it = types.iterator();
        while (it.hasNext())    {
            mp.put(it.next(), 0);
        }
        
        this.getItemList().stream().forEach(i -> mp.put(i.getType(), mp.get(i.getType()) + i.getQuantity()));

        int output = 0;
        it = types.iterator();

        while (it.hasNext())    {
            String key = it.next();
            output += mp.get(key) * costs.get(key);
        }

        return output;
        
    }

    public double getOrderCost()    {
        List <String> types = this.itemList.stream().map(i -> i.getType()).toList();
        List <Integer> quantities = this.itemList.stream().map(i -> i.getQuantity()).toList();
        double cost = 0;
        int itemCost = 0;

        Iterator <String> it = types.iterator();
        Iterator <Integer> it1 = quantities.iterator();
        while (it.hasNext())    {
            switch(it.next())   {
                case "Appetizer":
                    itemCost = 5;
                    break;
                case "Main Course":
                    itemCost = 10;
                    break;
                case "Second Course":
                    itemCost = 13;
                    break;
                default:
                    itemCost = 0;
            }
            cost += itemCost * it1.next();
        }
        return cost;
    }


    public int courseQuantity(String t)  {
        if (!MenuItem.getValidTypes().contains(t))
            return -1;
        long temp = this.itemList.stream().filter(i -> i.getType() == t).map( j -> j.getQuantity())
            .reduce(0, (subtotal, element) -> subtotal + element);
        return (int) temp;
    }
    
    @Override 
    public String toString()    {
        return "Order: [ " + this.date + ", " + this.cust + ", " + this.itemList + " ]";
    }
    
}
