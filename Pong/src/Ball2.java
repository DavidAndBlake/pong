import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball2
{
	double ballx;
	double bally;
	double ballspeedx = -1;
	Ellipse2D.Double ball = new Ellipse2D.Double(ballx, bally, 90, 90);
	double ballspeedy = -1;

	void paintSelf(Graphics2D g2)
	{
		g2.fill(ball);
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
}