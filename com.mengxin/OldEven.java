/**
 * @author mx
 * @date 2020/9/5 - 15:27
 */
public class OldEven {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Even even = new Even(printer);
        Thread t1 = new Thread(even);
        t1.setName("偶数线程");
        Old old = new Old(printer);
        Thread t2 = new Thread(old);
        t2.setName("奇数线程");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}


class Printer {
    int count = 0;

    public synchronized void printEven() {
        System.out.println(Thread.currentThread().getName() + "---" + count);
        ++count;
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printOld() {
        System.out.println(Thread.currentThread().getName() + "---" + count);
        ++count;
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Even implements Runnable {

    private Printer printer;

    public Even(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while(true) {
            printer.printEven();
        }
    }
}

class Old implements Runnable {

    private Printer printer;

    public Old(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while (true) {
            printer.printOld();
        }

    }
}
