public class LetterPrinter {

    public synchronized void printToConsole(char charID) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            System.out.print(charID);
            if (i != 0) notify();
            wait();
        }
    }

}
