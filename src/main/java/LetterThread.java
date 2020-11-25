public class LetterThread extends Thread{

    private static final int ITERATIONS = 5;
    private static char charID = 'A';

    private char ownChar;
    LetterPrinter letterPrinter;

    @Override
    public void run() {
        try {
            letterPrinter.printToConsole(getOwnChar());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private LetterThread (LetterPrinter letterPrinter) {
        ownChar = charID++;
        this.letterPrinter = letterPrinter;
    }

    public static LetterThread getInstance(LetterPrinter letterPrinter) {
        if (charID > 'Z') {
            charID = 'Z';
        }
        return new LetterThread(letterPrinter);
    }

    public char getOwnChar() {
        return ownChar;
    }
}
