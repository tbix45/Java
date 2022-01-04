import java.util.ArrayList;

public class Order{

    //Member variables
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    //Constructor
    //takes a name and price as arguments
    //sets them on instantiation
    public Order(){
        //for if nothing is passed in as an arguement
        this.name= "Guest";
        this.ready = false;

    }
    public Order(String name){
        this.name= name;
        this.ready = false;
    }

    public void addItem(Item item){
        this.items.add(item);
    }
    public String getStatusMessage(){
        if(this.ready==true){
            return "It's ready!\n";
        } else{
            return "Keep waiting!\n";
        }
    }
    public double getOrderTotal(){
        double total = 0.0;
        for(Item i: this.items){
            total+=i.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.printf("Customer Name: %s\n", this.name);
        for (Item i: this.items){
            System.out.printf("%s - $%s\n",i.getName(), i.getPrice());
        }
        System.out.printf("Total: $%s\n", this.getOrderTotal());
    }

        //getters and setters - for name and price

        //getter
        public String getName(){
            return name;
        }
        //setter
        public void setName(String name){
            this.name = name;
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
        public ArrayList<Item> getItems(){
            return items;
        }
        //setter
        public void setItems(ArrayList<Item> items){
            this.items = items;
        }

    
}