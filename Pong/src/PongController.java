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

public class PongController extends JComponent implements ActionListener,
		MouseMotionListener
{
	String ballspeed = JOptionPane.showInputDialog("What level do you want?");
	int level = Integer.parseInt(ballspeed);
	double ballspeedy = level;
	double ballspeedx = level;
	double ball1Speed = level;
	double ball2Speed = level;
	double paddlespeedy;
	double oldy;
	double currenty;
	Ball ball1;
	Ball ball2;
	int x = 44;
	int y = 4;
	int score1 = 0;
	int score2 = 0;
	AudioClip lauging;

	javax.swing.Timer ticker = new javax.swing.Timer(5, this);
	Rectangle2D.Double paddle = new Rectangle2D.Double(30, y, 10, 70);

	public static void main(String[] args)
	{
		PongController ping;
		ping = new PongController();
		ping.getGoing();
	}// go back where you came from

	void getGoing()
	{
		ball1 = new Ball(90, 670, Color.red);
		ball2 = new Ball(800, 600, Color.blue);
		ball1.setBallSpeed(level);
		ball2.setBallSpeed(level);
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
		ball1.paintSelf(g2);
		ball2.paintSelf(g2);
		g2.setColor(Color.blue);
		g2.fill(paddle);
		g2.setFont(new Font("Bank Gothic", Font.BOLD, 45));
		g2.setColor(Color.black);
		g2.drawRect(1050, 13, 300, 60);
		g2.setFont(new Font("Bank Gothic", Font.BOLD, 50));
		g2.drawString("" + (score1 + score2), 1060, 60);
	} // go back where you came from

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		repaint();

		if (ball1.ball.intersects(paddle))
		{
			score1 = score1 += 1;
			ball1.setScore(score1);
			ball1.ball.x = 40;
			ball1.ballspeedx = -ball1.ballspeedx;
		}
		if (ball1.ball.x < -100)
		{
			lauging = JApplet.newAudioClip(getClass().getResource(
					"150968__unchaz__laughing-audience.wav"));
			lauging.play();
			JOptionPane.showMessageDialog(null, "You're fat.");
			System.exit(0);
		}
		if (ball2.ball.intersects(paddle))
		{
			score2 = score2 += 1;
			ball2.setScore(score2);
			ball2.ball.x = 40;
			ball2.ballspeedx = -ball2.ballspeedx;
			ballspeedx = ballspeedx + 1;
			ballspeedy = ballspeedy + 1;

		}
		if (ball2.ball.x < -100)
		{
			lauging = JApplet.newAudioClip(getClass().getResource(
					"150968__unchaz__laughing-audience.wav"));
			lauging.play();
			JOptionPane.showMessageDialog(null, "You're fat.");
			lauging.stop();
			System.exit(0);
		}
	}

	// } // go back where you came from

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		paddle.y = arg0.getY() - 60;
	}
}
