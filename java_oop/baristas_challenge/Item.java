public class Item{

    //Member variables
    private String name;
    private double price;

    //Constructor
    //takes a name and price as arguments
    //sets them on instantiation
    public Item(){
        //for if nothing is passed in as an arguement
    }
    public Item(String name, double price){
        this.name= name;
        this.price = price;
    }
    //getters and setters - for name and price

        //getter
        public String getName(){
            return this.name;
        }
        //setter
        public void setName(String name){
            this.name = name;
        }

        //getter
        public double getPrice(){
            return this.price;
        }
        //setter
        public void setPrice(double price){
            this.price = price;
        }
        

    
}