import java.util.ArrayList;

public class ThreadExample {

    public static ArrayList<ThreadExample> instances = new ArrayList<ThreadExample>();

    public ThreadExample() {
        instances.add(this);
    }

    public static void main(String[] args) {
        ThreadRead threadRead = new ThreadRead();
        ThreadCreate threadCreate = new ThreadCreate();
        threadCreate.start();
        threadRead.start();

    }

}

class ThreadRead extends Thread {
    public void run() {
        System.out.println(ThreadExample.instances.size());
    }
}

class ThreadCreate extends Thread {
    public void run() {
        ThreadExample.instances.add(new ThreadExample());
    }
}
