/**
 * @author mx
 * @date 2020/9/5 - 17:17
 */
public class PrintABC {
    public static void main(String[] args) {
        ABCPrinter abcPrinter = new ABCPrinter();
        A a = new A(abcPrinter);
        B b = new B(abcPrinter);
        C c = new C(abcPrinter);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
    }
}

class A implements Runnable {
    ABCPrinter abcPrinter;

    public A(ABCPrinter abcPrinter) {
        this.abcPrinter = abcPrinter;
    }

    @Override
    public void run() {
        while (true) {
            abcPrinter.printA();
        }
    }
}

class B implements Runnable {
    ABCPrinter abcPrinter;

    public B(ABCPrinter abcPrinter) {
        this.abcPrinter = abcPrinter;
    }

    @Override
    public void run() {
        while (true) {
            abcPrinter.printB();
        }
    }
}

class C implements Runnable {
    ABCPrinter abcPrinter;

    public C(ABCPrinter abcPrinter) {
        this.abcPrinter = abcPrinter;
    }

    @Override
    public void run() {
        while (true) {
            abcPrinter.printC();
        }
    }
}

class ABCPrinter {
    int count = 0;

    public synchronized void printA() {
        if (count % 3 == 0) {
            System.out.println(Thread.currentThread().getName() + "A");
            ++count;
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void printB() {
        if (count % 3 == 1) {
            System.out.println(Thread.currentThread().getName() + "B");
            ++count;
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void printC() {
        if (count % 3 == 2) {
            System.out.println(Thread.currentThread().getName() + "C");
            ++count;
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
