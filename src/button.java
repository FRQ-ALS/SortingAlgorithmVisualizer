import javax.swing.*;
import java.awt.*;

public class button extends JButton {
    int x;
    int y;

    button(int x, int y)
    {
        this.setBounds(x,y,100,30);
        this.x = x;
        this.y = y;

    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(new Point(0, 0), Color.WHITE, new Point(0,
                getHeight()), Color.PINK.darker()));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        g2.setPaint(Color.BLACK);
        g2.drawString(getText(), 30, 12);
        g2.dispose();
    }
}
