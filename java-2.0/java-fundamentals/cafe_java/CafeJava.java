public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 3.85;
        double latte = 4.50;
        double cappuccino = 5.10;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        // ** Your customer interaction print statements will go here ** //
        System.out.println(customer1 + pendingMessage); // Displays "Welcome to Cafe Java, Cindhuri"

        // Noah orders
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
        } else {
            System.out.println(customer4 + pendingMessage);
        }

        // sam orders 2 lattes, show total
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + latte * 2);
        } else {
            System.out.println(pendingMessage);
            System.out.println(displayTotalMessage + latte * 2);
        }

        // Jimmy ordered lattee but was charged a coffee
        System.out.println(displayTotalMessage + (latte - dripCoffee));

        // String name = "Anthony";
        // System.out.println(name.charAt(0));

    }
}
