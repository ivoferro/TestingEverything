package threads;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IvoFerro on 09/05/2017.
 */
public class Run {

    public static void main(String[] args) {
        Set<Integer> data = new HashSet<>();
        data.add(20);
        data.add(50);
        data.add(20);

        SimpleList simpleListFrame = new SimpleList(data);
        simpleListFrame.setVisible(true);

        Thread producerThread = new ProducerThread(data, simpleListFrame);
        producerThread.start();
    }
}
