import java.util.ArrayList;
import java.util.Collections;

public class RandomName {

    private ArrayList<String> names;

    public RandomName() {
        names = new ArrayList<String>();
        names.add("Name 1");
        names.add("Name 2");
        names.add("Name 3");
        names.add("Name 4");
        names.add("Name 5");
        names.add("Name 6");
        names.add("Name 7");
        names.add("Name 8");
        names.add("Name 9");
        names.add("Name 10");
        names.add("Name 11");
        names.add("Name 12");
    }

    public String oneRandomName(){
        Collections.shuffle(names);
        String result = names.get(0);
        return result;
    }

    public ArrayList<String> twoRandomNames() {
        Collections.shuffle(names);
        ArrayList<String> results = new ArrayList<String>();
        results.add(names.get(0));
        results.add(names.get(1));
        return results;
    }

    public void addName (String name){
        names.add(name);
    }

    public ArrayList<String> getNames() {
        ArrayList<String> copy = new ArrayList<>(this.names);
        return copy;
    }
}
