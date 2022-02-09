import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

    // ninja bonus -- number of weeks is variable
    public int getStreakGoal(int numOfWeeks) {
        int sum = 0;
        for (int i = 1; i <= numOfWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    // given an array of item prices sum all prices and return total
    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i];
        }
        return total;
    }

    // given an arraylist of string print out each index and menu item
    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            String name = menuItems.get(i);
            System.out.println(String.format("%s: %s", i, name));
        }
    }

    // print string "enter your name:"
    // then add this code and store in userName variable
    // String userName = System.console().readLine();
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println(String.format("Hello, %s", userName));
        int lineLength = customers.size();
        System.out.println(String.format("There are %s people in front of you.", lineLength));
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            double priceChart = i * price;
            System.out.println(String.format("%s - $%s \n", i, priceChart));
        }
    }

}
