package multithreading;

public class StackOverflow596698Threads {
    public static void main(String[] args) {
        try {
            StackOverflow596698 s = new StackOverflow596698("C:\\Users\\Polina\\test\\data.txt");

            MyThread t1 = new MyThread("First", s);
            MyThread t2 = new MyThread("Second", s);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            s.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
