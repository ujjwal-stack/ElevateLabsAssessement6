package todo;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GradientPanel extends JPanel{

	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        
	        // Enable anti-aliasing for smooth gradient
	        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        
	        int width = getWidth();
	        int height = getHeight();
	        
	        // Create gradient from secondary color to white
	        GradientPaint gradientPaint = new GradientPaint(
	            0, 0, AppColors.SECONDARY_COLOR,
	            0, height, Color.WHITE
	        );
	        
	        g2d.setPaint(gradientPaint);
	        g2d.fillRect(0, 0, width, height);
	    }
}
