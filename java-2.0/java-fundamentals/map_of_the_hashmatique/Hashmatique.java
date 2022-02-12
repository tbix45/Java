import java.util.HashMap;

public class Hashmatique{
    public static void main(String[]args){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Mr. Moom", "Its a real cold moon...");
        map.put("Dog Day", "Dog day baybee");
        map.put("For whom the bell", "Look to the sky rhy befor u die");
        map.put("LALAL", "Who boy hahah LALA");

        System.out.println(map.get("Dog Day"));
        System.out.println(map.get("LALAL"));

        for (String key : map.keySet()) {
            System.out.println(String.format("Track: %s: Lyrics: %s", key, map.get(key)));
        }
    }
}