import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        String greeting = String.format("Hello, %s. Lovely to see you", name);
        return greeting;
    }

    public String guestGreeting(String dayPeriod, String name) {
        // YOUR CODE HERE
        String greeting = String.format("Good %s, %s. Lovely to see you", dayPeriod, name);
        return greeting;
    }

    public String yell() {
        // YOUR CODE HERE
        String yelled = "you are crazy batman!";
        return yelled.toUpperCase();
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        int alfred = conversation.indexOf("Alfred");
        int alexis = conversation.indexOf("Alexis");
        if (alfred!=-1){
            return "At your service. As you wish, naturally.";
        }
        else if(alexis!=-1){
            return "Right away, sir. She certainly isn't sophisticated enough for that";
        }
        else{
            return "Right. And with that I shall retire.";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

