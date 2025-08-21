import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public ToDoApp() {
        setTitle("To-Do List App");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input field and Add button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        taskInput = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Delete button
        JButton deleteButton = new JButton("Delete Selected");

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);

        // Action listeners
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
    }

    private void addTask() {
        String task = taskInput.getText();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskInput.setText("");
        }
    }

    private void deleteTask() {
        int selected = taskList.getSelectedIndex();
        if (selected != -1) {
            taskListModel.remove(selected);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoApp().setVisible(true);
        });
    }
}
