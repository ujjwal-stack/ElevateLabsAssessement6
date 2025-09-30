package todo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TodoApp extends JFrame {
	
	// UI Components
    private JTextField taskInput;
    private JPanel taskPanel;
    private JLabel taskCountLabel;
    private JComboBox<String> priorityCombo;
    private ArrayList<TaskItem> tasks;
    private int taskCounter = 0;
   
    
    public TodoApp() {
        tasks = new ArrayList<>();
        initializeUI();
    }
    
    private void initializeUI() {
        // Frame setup
        setTitle("My ToDo List - Task Manager");
        setSize(650, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Main panel with gradient background
        JPanel mainPanel = new GradientPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Input Panel
        JPanel inputPanel = createInputPanel();
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        
        // Footer Panel
        JPanel footerPanel = createFooterPanel();
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new BorderLayout());
        
        // Title
        JLabel titleLabel = new JLabel(" My ToDo List");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(AppColors.PRIMARY_COLOR);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Subtitle with date
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        JLabel dateLabel = new JLabel(sdf.format(new Date()));
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dateLabel.setForeground(Color.GRAY);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel titleContainer = new JPanel(new GridLayout(2, 1, 0, 5));
        titleContainer.setOpaque(false);
        titleContainer.add(titleLabel);
        titleContainer.add(dateLabel);
        
        headerPanel.add(titleContainer, BorderLayout.CENTER);
        headerPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        
        return headerPanel;
    }
    
    private JPanel createInputPanel() {
        JPanel mainContainer = new JPanel(new BorderLayout(0, 15));
        mainContainer.setOpaque(false);
        
        // Task input section
        JPanel inputSection = new JPanel(new BorderLayout(10, 10));
        inputSection.setBackground(Color.WHITE);
        inputSection.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(220, 220, 220), 1, true),
            new EmptyBorder(20, 20, 20, 20)
        ));
        
        // Task input field
        JPanel taskInputPanel = new JPanel(new BorderLayout(10, 5));
        taskInputPanel.setOpaque(false);
        
        JLabel taskLabel = new JLabel("What needs to be done?");
        taskLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        taskLabel.setForeground(AppColors.TEXT_COLOR);
        
        taskInput = new JTextField();
        taskInput.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        taskInput.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1, true),
            new EmptyBorder(10, 12, 10, 12)
        ));
        
        // Add Enter key listener
        taskInput.addActionListener(e -> addTask());
        
        taskInputPanel.add(taskLabel, BorderLayout.NORTH);
        taskInputPanel.add(taskInput, BorderLayout.CENTER);
        
        // Priority and button panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        controlPanel.setOpaque(false);
        
        JLabel priorityLabel = new JLabel("Priority:");
        priorityLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        String[] priorities = {" High", " Medium", " Low"};
        priorityCombo = new JComboBox<>(priorities);
        priorityCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        priorityCombo.setPreferredSize(new Dimension(120, 35));
        priorityCombo.setBackground(Color.WHITE);
        
        JButton addButton = UIHelper.createStyledButton("+ Add Task", AppColors.PRIMARY_COLOR);
        addButton.setPreferredSize(new Dimension(120, 35));
        addButton.addActionListener(e -> addTask());
        
        JButton clearAllButton = UIHelper.createStyledButton("Clear All", AppColors.DANGER_COLOR);
        clearAllButton.setPreferredSize(new Dimension(120, 35));
        clearAllButton.addActionListener(e -> clearAllTasks());
        
        controlPanel.add(priorityLabel);
        controlPanel.add(priorityCombo);
        controlPanel.add(addButton);
        controlPanel.add(clearAllButton);
        
        inputSection.add(taskInputPanel, BorderLayout.NORTH);
        inputSection.add(controlPanel, BorderLayout.SOUTH);
        
        // Task list section
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(220, 220, 220), 1, true),
            new EmptyBorder(10, 10, 10, 10)
        ));
        scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        mainContainer.add(inputSection, BorderLayout.NORTH);
        mainContainer.add(scrollPane, BorderLayout.CENTER);
        
        return mainContainer;
    }
    
    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setOpaque(false);
        
        taskCountLabel = new JLabel("Total Tasks: 0");
        taskCountLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        taskCountLabel.setForeground(AppColors.PRIMARY_COLOR);
        taskCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        footerPanel.add(taskCountLabel, BorderLayout.CENTER);
        footerPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        return footerPanel;
    }
    
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new EmptyBorder(8, 15, 8, 15));
        
        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
    
    private void addTask() {
        String taskText = taskInput.getText().trim();
        
        if (taskText.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a task!", 
                "Empty Task", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String priority = (String) priorityCombo.getSelectedItem();
        TaskItem taskItem = new TaskItem(taskText, priority, ++taskCounter, this);
        tasks.add(taskItem);
        taskPanel.add(taskItem.getPanel());
        taskPanel.revalidate();
        taskPanel.repaint();
        
        taskInput.setText("");
        taskInput.requestFocus();
        updateTaskCount();
    }
    
    private void clearAllTasks() {
        if (tasks.isEmpty()) {
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete all tasks?",
            "Clear All Tasks",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            tasks.clear();
            taskPanel.removeAll();
            taskPanel.revalidate();
            taskPanel.repaint();
            taskCounter = 0;
            updateTaskCount();
        }
    }
    
    public void removeTask(TaskItem task) {
        tasks.remove(task);
        taskPanel.remove(task.getPanel());
        taskPanel.revalidate();
        taskPanel.repaint();
        updateTaskCount();
    }
    
    public void updateTaskCount() {
        int completed = 0;
        for (TaskItem task : tasks) {
            if (task.isCompleted()) {
                completed++;
            }
        }
        taskCountLabel.setText(String.format("Total Tasks: %d | Completed: %d | Pending: %d", 
            tasks.size(), completed, tasks.size() - completed));
    }
    
  
    
    
	
	public static void main(String args[]) {
		// Set system look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Launch application
		SwingUtilities.invokeLater(() ->{
			TodoApp app = new TodoApp();
			app.setVisible(true);
		});
	}

}
