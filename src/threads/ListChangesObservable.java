package threads;

import java.util.Observable;

/**
 * Created by IvoFerro on 09/05/2017.
 */
public class ListChangesObservable extends Observable {

    public void activateChanges() {
        setChanged();
    }

    public void deactivateChanges() {
        clearChanged();
    }
}
