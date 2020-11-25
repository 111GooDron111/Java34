import java.util.ArrayList;

public class Main {

    public static synchronized void main(String[] args) {

        System.out.println("______________Первое задание!______________");
        exerciseOne();
        System.out.println();

        System.out.println("______________Второе задание!______________");
        exerciseTwo();

    }



    private static void exerciseOne() {

        int NUM_OF_THREADS = 5;

        LetterPrinter lp = new LetterPrinter();

        ArrayList<LetterThread> threads = new ArrayList<>();

        for (int i = 0; i < NUM_OF_THREADS; i++) {
            LetterThread thread = LetterThread.getInstance(lp);
            thread.start();
            threads.add(thread);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notifyManage(lp);
    }

    private static void exerciseTwo() {
        MFU mfu = new MFU();

        for (int i = 0; i < 10; i++) {
            new UserThread(mfu, "User " + i).start();
        }
    }

    private static void notifyManage(LetterPrinter lp) {
        synchronized (lp) {
            lp.notify();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lp) {
            lp.notifyAll();
        }
    }


}
