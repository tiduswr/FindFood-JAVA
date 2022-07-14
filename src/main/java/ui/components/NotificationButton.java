package ui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.NumberFormat;

public class NotificationButton extends ImageButton{
    private final int hOffset = 13;
    private final Font f = new Font("Arial", Font.BOLD, 11);
    private final Color myGreen = new Color(3, 252, 144, 127);
    private String value = "valor";
    
    public NotificationButton() {
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(myGreen);
        g2.fillRoundRect(2, getHeight()-(hOffset + 2), getWidth()-4, hOffset, 2, 2);
        
        g2.setColor(Color.BLACK);
        g2.setFont(f);
        g2.drawString(value, 4, getHeight()-4);
    }
    
    public void attValue(double value){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        this.value = formatter.format(value);
        repaint();
    }
    
}
