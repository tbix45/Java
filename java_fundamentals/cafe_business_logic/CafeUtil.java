import java.util.ArrayList;

public class CafeUtil{

    public int getStreakGoal(){
        int sum = 0;
        for(int i=1;i<=10;i++){
            sum+=i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double totalPrice = 0.0;
        for(int i=0;i<=prices.length-1; i++){
            totalPrice+=prices[i];
        }
        return totalPrice;
    }

    public void displayMenu(ArrayList<String>menuItems){
        for (int i = 0; i <menuItems.size() ;i++){
            Integer index = i;
            String item = menuItems.get(i);
            System.out.printf("%s %s\n", index, item );
        }
    }

    public void addCustomer(ArrayList<String>customer){
        Integer count = 0;
        ArrayList<String> customerList = new ArrayList<String>();

        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello " + userName);
        System.out.printf("There are %s people in front of you. and count is: %s\n", customerList.size(), count);

        customerList.add(userName);
        count+=1;
        System.out.println(customerList);


        return;
    }

}