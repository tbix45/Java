import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TestCafe {
    public static void main(String[] args) {
        
    /* 
      You will need add 1 line to this file to create an instance 
      of the CafeUtil class. 
      Hint: it will need to correspond with the variable name used below..
    */
        CafeUtil cafeCommands = new CafeUtil();
    	
        /* ============ App Test Cases ============= */
    
        // System.out.println("----- Streak Goal Test -----");
        // System.out.println("Purchases needed by week 10:\n"+  cafeCommands.getStreakGoal());
    
        // System.out.println("----- Order Total Test-----");
        // double[] prices = {3.5, 1.5, 4.0, 4.5};
        // System.out.println("Order total:"+ cafeCommands.getOrderTotal(prices));
        
        System.out.println("----- Display Menu Test-----");
        
        List<String> loadMenu = Arrays.asList(
            "drip coffee",
            "cappucino",
            "latte",
            "mocha"
        );
        // System.out.println(loadMenu);
        ArrayList<String> menu = new ArrayList<String>();
        menu.addAll(loadMenu);
        cafeCommands.displayMenu(menu);
    
   
        System.out.println("\n----- Add Customer Test-----");

        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        Integer count = 0;
        for (int i = 0; i < 4; i++) {
            cafeCommands.addCustomer(customers);
            System.out.printf("%s\n", count);
            count +=1;
        }
    }
}
