 /* By: Ricardo L. Ortega | ric623@phoenix.edu | otgcardo@yahoo.com*/
package guiinventoryprogram;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
    The title of the program and a simple gui aside
*/

@SuppressWarnings("serial")
public class GuiLogo extends JPanel{
    @Override
    public void paint(Graphics g){
	g.setColor(Color.black);
	g.fillRect(-2, -2, getWidth(), getHeight());
	g.setColor(Color.red);
                
	for(int i = 0; i < 4; i += 2){
            g.drawRoundRect(10 + (5 * i), 19 + (4 * i), 10, 10, 6, 6);
        }
	g.setFont(getFont());
	g.drawString("Rics DVD Collection", 30, 35);
    }
}
