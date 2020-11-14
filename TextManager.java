package ge;

import ge.core.SceneManager;

import javax.swing.*;
import java.awt.*;

public class TextManager extends JPanel {

    SceneManager sm;

    public TextManager(SceneManager sm) {

        this.sm = sm;

    }

    public void drawText(Graphics g) {

        Font bigFont = new Font("Verdana", Font.BOLD, 25);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(bigFont);
        g.setColor(Color.WHITE);
        g.drawString("Match the Sprites", 350, 100);

        g.setFont(bigFont);
        g.drawString("Controls: WASD or Arrow Keys", 50, 900);

        g.setFont(smallFont);
        g.drawString("Created by Rob Rose", 800, 900);

    }

}
