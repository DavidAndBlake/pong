import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Main extends JComponent
{
	JFrame playingField;

	public static void main(String[] args)
	{
		new Main().getGoing();
	}

	void getGoing()
	{
		playingField = new JFrame();
		playingField.setVisible(true);
		playingField.setSize(850, 750);
		playingField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playingField.add(this);
	}

	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.cyan);
		g2.setStroke(new BasicStroke(6));
		g2.drawOval(400, 300, 100, 100);
		g2.setColor(Color.DARK_GRAY);
		g2.fillOval(400, 300, 100, 100);
	}
}
