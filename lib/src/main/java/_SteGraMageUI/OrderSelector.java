package _SteGraMageUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderSelector extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<String> leftList;
    private DefaultListModel<String> leftListModel;
    private JList<String> rightList;
    private DefaultListModel<String> rightListModel;
    private ArrayList<String> selectedNames;
	private JScrollPane leftScrollPane;
	private JScrollPane rightScrollPane;

    public OrderSelector () {
        setLayout(new GridLayout(1, 2));
        selectedNames = new ArrayList<>();

        // Initialize left list
        leftListModel = new DefaultListModel<>();
        leftList = new JList<>(leftListModel);
        leftScrollPane = new JScrollPane(leftList);

        // Initialize right list
        rightListModel = new DefaultListModel<>();
        rightList = new JList<>(rightListModel);
        rightScrollPane = new JScrollPane(rightList);

        // Buttons to move items between lists
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));

        JButton addButton = new JButton(">>");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveSelectedItems(leftList, leftListModel, rightListModel, selectedNames);
            }
        });
        JButton removeButton = new JButton("<<");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveSelectedItems(rightList, rightListModel, leftListModel, selectedNames);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        // Add components to panel
        add(leftScrollPane);
        add(buttonPanel);
        add(rightScrollPane);
    }

    private void moveSelectedItems(JList<String> sourceList, DefaultListModel<String> sourceModel, DefaultListModel<String> targetModel, ArrayList<String> selectedNames) {
        for (String selectedValue : sourceList.getSelectedValuesList()) {
            sourceModel.removeElement(selectedValue);
            targetModel.addElement(selectedValue);
            if (sourceModel == leftListModel) {
                selectedNames.add(selectedValue);
            } else {
                selectedNames.remove(selectedValue);
            }
        }
    }

    public void addName(String name) {
        leftListModel.addElement(name);
    }

    public ArrayList<String> getSelectedNames() {
        return selectedNames;
    }
    
    public void clear() {
    	leftListModel.removeAllElements();
    	rightListModel.removeAllElements();
    	selectedNames = new ArrayList<>();
    	repaint();
    }
}
