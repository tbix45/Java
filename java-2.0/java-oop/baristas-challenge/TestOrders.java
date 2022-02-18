public class TestOrders {
    public static void main(String[] args) {

        Item item1 = new Item();
        item1.name = "Mocha";
        item1.price = 1.00;
        Item item2 = new Item();
        item2.name = "Latte";
        item2.price = 2.00;
        Item item3 = new Item();
        item3.name = "Drip Coffee";
        item3.price = 3.00;
        Item item4 = new Item();
        item4.name = "Capuccino";
        item4.price = 4.00;

        Order order1 = new Order();
        order1.name = "Cindhuri";

        Order order2 = new Order();
        order2.name = "Jimmy";

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";

        // add item1 to order2 item list and increment the orders total
        order2.items.add(item1);
        order2.total += item1.price;

        // order3 added a cappucine add to total as well
        order3.items.add(item4);
        order3.total += item4.price;

        // order 4 got a latte
        order4.items.add(item2);
        order4.total += item2.price;

        // cindhuris order is now ready, update
        order1.ready = true;
        // jimmy order is now ready, update
        order2.ready = true;

        // sam orders 2 lattes
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price * 2;

        System.out.printf("Order 2: %s\n", order1);
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

    }
}
