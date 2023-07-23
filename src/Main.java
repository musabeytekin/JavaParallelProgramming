// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SynchronizedRGB myColor = new SynchronizedRGB(0, 0, 0, "Pitch Black");
//        int myColorInt = myColor.getRGB();
        //another thread can execute this code: myColor.set(255, 255, 255, "White");
        //the fallowing line is not thread safe
//        String myColorName = myColor.getName();

        //the fallowing line is thread safe

        synchronized (myColor) {
            int myColorInt = myColor.getRGB();
            String myColorName = myColor.getName();
        }



    }
}