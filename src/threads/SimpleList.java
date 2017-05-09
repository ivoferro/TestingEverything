package threads;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/**
 * Created by IvoFerro on 09/05/2017.
 */
public class SimpleList extends JFrame implements Observer {

    private final Set<Integer> data;

    private JList<Integer> dataList;

    private DataListModel dataListModel;

    public SimpleList(Set<Integer> data) {
        this.data = data;

        createComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 600));
        pack();
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        dataListModel = new DataListModel(data);
        dataList = new JList<>(dataListModel);

        add(dataList, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("UI was notified");

        dataListModel = new DataListModel(data);
        dataList.setModel(dataListModel);

        JOptionPane.showMessageDialog(this, "list updated");
    }
}
