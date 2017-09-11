package multithreading;

import java.io.FileWriter;
import java.io.IOException;

class StackOverflow596698 {
    private FileWriter fileWriter;

    public StackOverflow596698(String file) throws IOException {
        fileWriter = new FileWriter(file, true);
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writing(String str, int i) {
        try {
            System.out.print(str + i);
            fileWriter.append(str + i);
            Thread.sleep((long) (Math.random() * 50));
            System.out.print("->" + i + " ");
            fileWriter.append("->" + i + " ");
        } catch (Exception e) {
            System.err.print("Error of stream");
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    private StackOverflow596698 s;

    public MyThread(String str, StackOverflow596698 s) {
        super(str);
        this.s = s;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            s.writing(getName(), i);
        }
    }
}

