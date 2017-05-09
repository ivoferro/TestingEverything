package threads;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Set;

/**
 * Created by IvoFerro on 09/05/2017.
 */
public class ProducerThread extends Thread {

    private final Set<Integer> data;
    private final Random randomGenerator;
    private final ListChangesObservable observable;

    public ProducerThread(Set<Integer> data, Observer observer) {
        this.data = data;

        randomGenerator = new Random();

        observable = new ListChangesObservable();
        observable.addObserver(observer);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Sleeping 10 seconds");
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 5; i++) {
                int rand = randomGenerator.nextInt(100) + 1;
                data.add(rand);
                System.out.printf("Adding %d to the list\n", rand);
            }

            System.out.println("Notifying observers");
            observable.activateChanges();
            observable.notifyObservers();
        }
    }
}
