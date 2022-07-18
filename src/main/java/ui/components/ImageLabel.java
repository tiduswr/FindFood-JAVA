package ui.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class ImageLabel extends JLabel{
    private Image img = null;
    
    public ImageLabel(){
        setOpaque(false);
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
        img = ImageIO.read(new File(imgPath));
        repaint();
    }
}
