import java.util.ArrayList;

public class TestOrders{
    public static void main(String[] args){


            // Menu items
            Item item1 = new Item("cappucino", 5.5);
            Item item2 = new Item("Mocha", 6.5);
            Item item3 = new Item("Latte", 4.5);
            Item item4 = new Item("Drip Coffee", 5.0);
        
        //2 orders for unspecified guests
            Order order1 = new Order();
            Order order2 = new Order();
        //3 orders for overloaded with name
            Order order3= new Order("Alex");
            Order order4= new Order("Bob");
            Order order5= new Order("Tyler");
        //add 2 items to each order using the additem method: order3.addItem(item1)
        order1.addItem(item1);
        order1.addItem(item4);
        order2.addItem(item3);
        order3.addItem(item1);
        order4.addItem(item4);
        order4.addItem(item4);
        order5.addItem(item4);
        order4.addItem(item4);
        // order1.setReady(true);
        // System.out.printf(order1.getStatusMessage());
        //test the total by printing
        // System.out.printf("%s's total is %s\n", order1.getName(), order1.getOrderTotal());
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}