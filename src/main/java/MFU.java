public class MFU {

    public synchronized void print(String name) {
        System.out.println(name + " печатает...");
    }

    public synchronized void scan(String name) {
        System.out.println(name + " сканирует...");
    }

    public synchronized void copy(String name) {
        scan(name);
        System.out.print(" и ");
        print("");
    }

}
