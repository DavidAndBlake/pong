import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.Timer;

import javax.management.timer.TimerMBean;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

public class Pong extends JComponent implements ActionListener,
		MouseMotionListener
{
	String ballspeed = JOptionPane.showInputDialog("What level do you want?");
	int level = Integer.parseInt(ballspeed);
	double ballspeedy = level;
	double ballspeedx = level;
	double paddlespeedy;
	double oldy;
	double currenty;
	int x = 44;
	int y = 4;
	int score = 0;
	AudioClip lauging;
	
	javax.swing.Timer ticker = new javax.swing.Timer(1, this);
	Ellipse2D.Double ball = new Ellipse2D.Double(x, y, 90, 90);
	Rectangle2D.Double paddle = new Rectangle2D.Double(30, y, 10, 70);

	public static void main(String[] args)
	{
		Pong ping;
		ping = new Pong();
		ping.getGoing();
	}// go back where you came from

	void getGoing()
	{
		JFrame pongTable;
		pongTable = new JFrame();
		pongTable.setSize(1250, 780);
		pongTable.add(this);
		pongTable.setVisible(true);
		pongTable.setDefaultCloseOperation(pongTable.EXIT_ON_CLOSE);
		pongTable.addMouseMotionListener(this);
		ticker.start();
		
	} // Go back where you came from

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2;
		g2 = (Graphics2D) g;
		g2.setColor(Color.green);
		g2.fill(ball);
		g2.setColor(Color.blue);
		g2.fill(paddle);
		g2.setFont(new Font("Bank Gothic", Font.BOLD, 45));
		g2.drawString( "" + score ,(int) ball.x + 10,(int) ball.y + 65);
		
	} // go back where you came from

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		repaint();
		ball.x += ballspeedx;
		ball.y += ballspeedy;
		if (ball.y > 700)
		{
			ballspeedy = -ballspeedy;
		}
		if (ball.x > 1200)
		{
			ballspeedx = -ballspeedx;
		}
		if (ball.y < 1)
		{
			ballspeedy = -ballspeedy;
		}
		
		
		if (ball.intersects (paddle))
		{
			score = score +=1;
			ballspeedx = -ballspeedx;
			ball.x = 40;
			//ballspeedy = (ballspeedy - paddlespeedy)/10;
		}
		if (ball.x < -100){
			lauging = JApplet.newAudioClip(getClass().getResource("150968__unchaz__laughing-audience.wav"));
			lauging.play();
			JOptionPane.showMessageDialog(null, "You're fat.");
			System.exit(0);
		}
		oldy = currenty;
		currenty = paddle.y;
		
		paddlespeedy = oldy - currenty ;
		
		
		
		
		
	} // go back where you came from

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		paddle.y = arg0.getY();
	}
}
