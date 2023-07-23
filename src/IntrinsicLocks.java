import java.util.ArrayList;

public class IntrinsicLocks {

    private String lastName;
    private int nameCount;
    private ArrayList<String> nameList = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println("Hello World!");

    }

    public void addName(String name) {
        synchronized (this) {
            lastName = name;
            nameCount++;
        }
        nameList.add(name);
    }


}

