import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        
    /* 
      You will need add 1 line to this file to create an instance 
      of the CafeUtil class. 
      Hint: it will need to correspond with the variable name used below..
    */
    
    /* ============ App Test Cases ============= */
    
    // Menu items
    Item item1 = new Item();
    Item item2 = new Item();
    Item item3 = new Item();
    Item item4 = new Item();

    item1.name= "Mocha";
    item1.price=2.10;
    item2.name= "Latte";
    item2.price=1.00;
    item3.name= "Drip Coffee";
    item3.price=3.60;
    item4.name= "Capuccino";
    item4.price=4.78;
    
    // Order variables -- order1, order2 etc.
    Order order1 = new Order();
    Order order2 = new Order();
    Order order3 = new Order();
    Order order4 = new Order();

    order1.name = "Cindhuri";
    order2.name = "Jimmy";
    order3.name = "Noah";
    order4.name = "Sam";

    order1.total =4.87;
    order1.ready = false;
    ArrayList<Item> items = new ArrayList<Item>();

                // Application Simulations
                // Use this example code to test various orders' updates
                // System.out.printf("Name: %s\n", order1.name);
                // System.out.printf("Total: %s\n", order1.total);
                // System.out.printf("Ready: %s\n", order1.ready);
//add item 1 to order 2's item list and increment the total 
                // order2.items.add(item1);
                // order2.total = item1.price + item2.price;
                // System.out.printf("Order 2's Total: %s\n", order2.total);
//order 3 ordered a cappucino. add the capp to their order list and to their tab
                // order3.items.add(item4);
                // order3.total += item4.price;
                // System.out.printf("Order 3's order and total is: %s, $%s\n", item4.name, order3.total);
//order 4 got a latte
                order4.items.add(item2);
                order4.total+=item2.price;
                // System.out.printf("Order 4's Total and order is: $%s, %s\n", order4.total, item2.name);
//order1 is ready
                // order1.ready=true;
                // if(order1.ready==true){
                //     System.out.printf("Your order is ready %s\n", order1.name );
                // } else{
                //     System.out.printf("You need to wait %s\n", order1.name );
                // };
//order4 got 2 more lattes. update it
                order4.items.add(item2);
                order4.items.add(item2);
                order4.total+=(2*item2.price);
                System.out.printf("%s your new order is %s for a total of $%s\n", order4.name, order4.items, order4.total);
//order2 is ready
                // order2.ready=true;
                // if(order2.ready==true){
                //     System.out.printf("Your order is ready %s\n", order2.name );
                // } else{
                //     System.out.printf("You need to wait %s\n", order2.name );
                // };
    }
}
