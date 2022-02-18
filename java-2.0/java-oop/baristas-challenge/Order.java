import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }
    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }
    //getter
    public String getName(){
        return name;
    }
    //setter
    public void setName(String name){
        this.name = name
    }
    //getter
    public boolean getReady(){
        return ready;
    }
    //setter
    public void setReady(boolean ready){
        this.ready = ready;
    }
    //getter
    public ArrayList<Items> getItems(){
        return items;
    }
    //setter
    public void setItems(ArrayList<Items> items){
        this.items = items;
    }

    //methods
    public void addItem(Item item){
        this.items.add(item);
    }
    public String getStatusMessage(){
        if(this.ready==true){
            return "Your order is ready."
        } else{
            return "Thank you for waiting. Your order will be ready soon."
        }
    }
    public double getOrderTotal(){
        double sum = 0.0;
        for(Item item:this.items){
            sum+= item.getPrice();
        }
        return sum;
    }
    public void display(){
        System.out.println("Customer name: %s", this.name);
    }
}
