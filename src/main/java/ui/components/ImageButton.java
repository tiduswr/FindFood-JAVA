package ui.components;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class ImageButton extends JButton{
    
    private Image img = null;
    private final Cursor hand = new Cursor(Cursor.HAND_CURSOR);
    private final Cursor def = new Cursor(Cursor.DEFAULT_CURSOR);
    
    public ImageButton(){
        setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                setCursor(hand);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(def);
            }
        });
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        int h = getHeight();
        int w = getWidth();
        int balance = w - h;
        int border = 0;
        if(w > h) {
            border = balance/2;
            w = h;
        }        
        
        if(img != null) g2.drawImage(img, border, 0, w, h, null);
    }
    
    public void setImage(String imgPath) throws IOException{
        img = ImageIO.read(getClass().getResourceAsStream("/" + imgPath));
        repaint();
    }
    
}
