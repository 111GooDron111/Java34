import java.util.Random;

public class UserThread extends Thread{
    private String name;

    private Random rand = new Random();
    private MFU mfu;

    public UserThread(MFU mfu, String name) {
        this.mfu = mfu;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            currentAction(rand.nextInt(3));
        }
    }

    private void currentAction(int nextInt) {
        switch (nextInt) {
            case 0:
                mfu.print(name);
                break;
            case 1:
                mfu.scan(name);
                break;
            default:
                mfu.copy(name);
        }
    }
}
