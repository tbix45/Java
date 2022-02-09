import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomArrayList = new ArrayList<Integer>(10);
        System.out.println("size is: " + randomArrayList.size());
        return randomArrayList;
    }

}
