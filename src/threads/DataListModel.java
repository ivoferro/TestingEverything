package threads;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by IvoFerro on 09/05/2017.
 */
public class DataListModel extends AbstractListModel<Integer> {

    private final List<Integer> data;

    public DataListModel(Set<Integer> data) {
        this.data = new ArrayList(data);
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Integer getElementAt(int i) {
        return data.get(i);
    }
}
