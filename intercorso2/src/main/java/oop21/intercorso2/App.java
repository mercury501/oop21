package oop21.intercorso2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        List <Order> orderList = new ArrayList<>();
        Customer c1 = new Customer("Piero", "Pieroni", "Via Cantone", "Taranto", "555-24253");
        Customer c2 = new Customer("Dado", "Concettina", "Via Togliatti", "Salerno", "555-75453");
        Customer c3 = new Customer("Pero", "Rombo", "Via Ciccio", "Salerno", "555-242785");
        Customer c4 = new Customer("Tommaso", "Biagiozzi", "Via Europa", "Napoli", "555-43253");

        List <MenuItem> l1 = List.of(new MenuItem("Carbonara", 3, "Main Course"), new MenuItem("Costolette", 3, "Second Course"), new MenuItem("Insalata di Polpo", 3, "Appetizer"));
        List <MenuItem> l2 = List.of(new MenuItem("Pasta e Fagioli", 2, "Main Course"), new MenuItem("Bistecca", 2, "Second Course"), new MenuItem("Involtini Primavera", 2, "Appetizer"));
        List <MenuItem> l3 = List.of(new MenuItem("Pasta e Patate", 3, "Main Course"), new MenuItem("Seppia", 4, "Second Course"), new MenuItem("Arancino", 3, "Appetizer"));
        List <MenuItem> l4 = List.of(new MenuItem("Risotto", 1, "Main Course"), new MenuItem("Salsiccia", 1, "Second Course"), new MenuItem("Panzerotto", 1, "Appetizer"));


        orderList.add(new Order(LocalDate.of(2021, 11, 5), l1, c1));
        orderList.add(new Order(LocalDate.of(2020, 12, 4), l2, c2));
        orderList.add(new Order(LocalDate.of(2021, 6, 5), l3, c3));
        orderList.add(new Order(LocalDate.of(2021, 9, 1), l4, c4));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));
        orderList.add(new Order(LocalDate.of(2021, 3, 4), l4, c2));

        //Esercizio 1

        System.out.println("Ordini col costo superiore a 50 euro: " + 
            orderList.stream().map(o -> o.getOrderCost()).filter(c -> c >= 50).count()
        );

        long ordiniDiSalerno = orderList.stream().map(o -> o.getCustomer().getCityAddress()).filter(c -> c == "Salerno").count();
        long clientiDiSalerno = orderList.stream().map(o -> o.getCustomer()).filter(c -> c.getCityAddress() == "Salerno").distinct().count();
        
        System.out.println("Numero medio di ordini effettuati da persone di Salerno: " + (double) ordiniDiSalerno / clientiDiSalerno
            
        );

        //Esercizio 2 incpompleto

        /*

        List <Customer> clienti = orderList.stream().map(o -> o.getCustomer()).distinct().toList();

        List <Customer> clientiOrdini = orderList.stream().map(o -> o.getCustomer()).toList();

        Iterator <Customer> it = clienti.iterator();
 

        System.out.println("Numero di clienti con più di 10 ordini: " + 
            orderList.stream().map(o -> o.getCustomer())
        );

        */
        /*
        System.out.println("Numero di ordini in cui i secondi son più dei primi: " 
            
        );
        */
        
        
        //Esercizio 3

        Comparator <Order> perData = (Order o1, Order o2) -> {
            if (o1.getDate().isBefore(o2.getDate()))
                return 1;
            if (o1.getDate().isAfter(o2.getDate()))
                return -1;
            int r = o1.getCustomer().getSurname().compareTo(o2.getCustomer().getSurname());

            if (r != 0)
                return r;
            return o1.getCustomer().getName().compareTo(o2.getCustomer().getName());
        } ;

        Comparator <Order> perCosto = (o1, o2) -> {
            double costO1 = o1.getOrderCost();
            double costO2 = o2.getOrderCost();
            if (costO1 > costO2)
                return -1;
            if (costO1 < costO2)
                return 1;
            return 0;

        };


        List <Order> ord = new ArrayList<>(orderList);
        System.out.println("Ordini non ordinati: " + ord);
        Collections.sort(ord, perData);

        System.out.println("Ordini ordinati con criterio 1: " + ord);

        Collections.sort(ord, perCosto);
        System.out.println("Ordini ordinati con criterio 2: " + ord);

    }
}
