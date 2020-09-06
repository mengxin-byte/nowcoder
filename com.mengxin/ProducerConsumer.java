/**
 * @author mx
 * @date 2020/9/5 - 15:04
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Client client = new Client();
        Producer producer = new Producer(client);
        Thread t1 = new Thread(producer);
        Consumer consumer = new Consumer(client);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}

class Client {
    int count = 0;

    public synchronized void produce() {
        if (count < 20) {
            ++count;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + count + "个产品");
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + count + "个产品");
            --count;
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {

    private Client client;
    public Producer(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            client.produce();
        }

    }
}

class Consumer implements Runnable {

    private Client client;
    public Consumer(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            client.consume();
        }
    }
}
