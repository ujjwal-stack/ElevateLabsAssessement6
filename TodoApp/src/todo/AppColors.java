package todo;

import java.awt.Color;

public class AppColors {

	// Primary color scheme
    public static final Color PRIMARY_COLOR = new Color(79, 70, 229);
    public static final Color SECONDARY_COLOR = new Color(244, 244, 255);
    public static final Color ACCENT_COLOR = new Color(129, 140, 248);
    
    // Status colors
    public static final Color SUCCESS_COLOR = new Color(34, 197, 94);
    public static final Color DANGER_COLOR = new Color(239, 68, 68);
    public static final Color WARNING_COLOR = new Color(245, 158, 11);
    
    // Text colors
    public static final Color TEXT_COLOR = new Color(51, 51, 51);
    public static final Color TEXT_GRAY = new Color(107, 114, 128);
    
    // Background colors
    public static final Color BG_WHITE = Color.WHITE;
    public static final Color BG_GRAY = new Color(248, 248, 248);
    
    // Border colors
    public static final Color BORDER_LIGHT = new Color(220, 220, 220);
    public static final Color BORDER_MEDIUM = new Color(200, 200, 200);
    
    // Private constructor to prevent instantiation
    private AppColors() {
        throw new AssertionError("Cannot instantiate AppColors class");
    }
    
}
