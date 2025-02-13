import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JPanel {
    private int nodes = 100;
    int[] coords = new int[nodes * 2];

    private int x, y;
    private double dist, r;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.blue);
        
        for (int i = 0; i < coords.length; i++) {
            if (i % 2 == 0) {
                g.fillOval(coords[i], coords[i+1], 20, 20);
            }
        }
    }

    public void rePos() {
        for (int i = 2; i < coords.length; i++) {
            if (i % 2 == 0) {
                x = coords[i] - coords[i-2];
                y = coords[i+1] - coords[i-1];
                
                dist = Math.sqrt(x * x + y * y);
        
                r = 20/dist;
    
                x = (int)Math.round(x * r);
                y = (int)Math.round(y * r);
    
                coords[i] = x + coords[i-2];
                coords[i+1] = y + coords[i-1];
            }
        }
    }

    public void createAndShowGUI(){
        // Create the frame
        JFrame frame = new JFrame("Main Frame");
        frame.setPreferredSize(new Dimension(1920, 1080));
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        // Mouse move event
        frame.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent me) {
                coords[0] = me.getX() - 10;
                coords[1] = me.getY() - 30;
                rePos();
                repaint();
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main project = new Main();
                project.createAndShowGUI();
            }
        });
    }
}