package todo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UIHelper {

	/**
     * Creates a styled button with custom colors and hover effects
     * @param text The button text
     * @param bgColor The background color
     * @return A styled JButton
     */
    public static JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new EmptyBorder(8, 15, 8, 15));
        
        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
    
    /**
     * Creates a styled label with custom font and color
     * @param text The label text
     * @param fontSize The font size
     * @param isBold Whether the font should be bold
     * @return A styled JLabel
     */
    public static JLabel createStyledLabel(String text, int fontSize, boolean isBold) {
        JLabel label = new JLabel(text);
        int fontStyle = isBold ? Font.BOLD : Font.PLAIN;
        label.setFont(new Font("Segoe UI", fontStyle, fontSize));
        label.setForeground(AppColors.TEXT_COLOR);
        return label;
    }
    
    /**
     * Creates a styled text field with rounded border
     * @param columns The number of columns
     * @return A styled JTextField
     */
    public static JTextField createStyledTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(AppColors.BORDER_MEDIUM, 1, true),
            new EmptyBorder(10, 12, 10, 12)
        ));
        return textField;
    }
    
    // Private constructor to prevent instantiation
    private UIHelper() {
        throw new AssertionError("Cannot instantiate UIHelper class");
    }
}
