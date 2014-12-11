import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball
{
	Color color;
	int score;
	double ballspeedx = 1;
	double ballspeedy = 1;
	Ellipse2D.Double ball;

	public Ball(double ballx, double bally, Color color)//constructor
	{
		ball = new Ellipse2D.Double(ballx, bally, 90, 90);
		this.color = color;
	}

	void paintSelf(Graphics2D g2)
	{
		g2.setColor(color);
		g2.fill(ball);
		g2.setFont(new Font("Bank Gothic", Font.BOLD, 70));
		g2.setColor(Color.BLACK);
		g2.drawString("" + score, (int) ball.x + 14, (int) ball.y + 80);
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
	}

	public void setScore(int score)
	{
		this.score = score;
	}
}
