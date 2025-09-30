package todo;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TaskItem {
	
	private JPanel panel;
    private JCheckBox checkBox;
    private JLabel taskLabel;
    private JButton deleteButton;
    private boolean completed;
    private String priority;
    private int id;
    private TodoApp parentApp;
    
    public TaskItem(String taskText, String priority, int id, TodoApp parentApp) {
        this.priority = priority;
        this.id = id;
        this.completed = false;
        this.parentApp= parentApp;
        createPanel(taskText);
    }
    
    private void createPanel(String taskText) {
        panel = new JPanel(new BorderLayout(10, 0));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(230, 230, 230), 1, true),
            new EmptyBorder(12, 15, 12, 15)
        ));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        
        // Left section with checkbox and task
        JPanel leftPanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT, 10, 0));
        leftPanel.setOpaque(false);
        
        checkBox = new JCheckBox();
        checkBox.setOpaque(false);
        checkBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        checkBox.addActionListener(e -> toggleComplete());
        
        taskLabel = new JLabel(String.format("<html><b>#%d</b> %s</html>", id, taskText));
        taskLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        taskLabel.setForeground(AppColors.TEXT_COLOR);
        
        leftPanel.add(checkBox);
        leftPanel.add(taskLabel);
        
        // Right section with priority and delete
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightPanel.setOpaque(false);
        
        JLabel priorityLabel = new JLabel(priority);
        priorityLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
        priorityLabel.setBorder(new EmptyBorder(3, 8, 3, 8));
        priorityLabel.setOpaque(true);
        priorityLabel.setBackground(getPriorityColor());
        priorityLabel.setForeground(Color.WHITE);
        
        deleteButton = new JButton("X"); // nicer than plain "x"
        deleteButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        deleteButton.setPreferredSize(new Dimension(40, 22));
        deleteButton.setBackground(new Color(254, 226, 226)); // soft red background
        deleteButton.setForeground(new Color(220, 38, 38));   // strong red for text
        deleteButton.setFocusPainted(false);
        deleteButton.setBorderPainted(false);
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        

        // Rounded corners effect
        deleteButton.setBorder(new LineBorder(new Color(220, 38, 38), 1, true));

        // Hover effect (change color when mouse is over)
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                deleteButton.setBackground(new Color(252, 165, 165)); // lighter red
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                deleteButton.setBackground(new Color(254, 226, 226)); // original
            }
        });

        // Click action
        deleteButton.addActionListener(e -> deleteTask());
        
        rightPanel.add(priorityLabel);
        rightPanel.add(deleteButton);
        
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(rightPanel, BorderLayout.EAST);
        
        // Add spacing
        panel.setBorder(BorderFactory.createCompoundBorder(
            new EmptyBorder(0, 0, 8, 0),
            panel.getBorder()
        ));
    }
    
    private Color getPriorityColor() {
        if (priority.contains("High")) {
            return new Color(220, 38, 38);
        } else if (priority.contains("Medium")) {
            return new Color(245, 158, 11);
        } else {
            return new Color(34, 197, 94);
        }
    }
    
    private void toggleComplete() {
        completed = checkBox.isSelected();
        if (completed) {
            taskLabel.setForeground(Color.GRAY);
            panel.setBackground(new Color(248, 248, 248));
        } else {
            taskLabel.setForeground(AppColors.TEXT_COLOR);
            panel.setBackground(Color.WHITE);
        }
        parentApp.updateTaskCount();
    }
    
    private void deleteTask() {
        parentApp.removeTask(this);
    }
    
    public JPanel getPanel() {
        return panel;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public String getPriority() {
        return priority;
    }
    
    public int getId() {
        return id;
    }

}
