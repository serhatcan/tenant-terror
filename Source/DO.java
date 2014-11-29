import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * @author Serhat CAN
 *
 *         Description: DisplayOptions
 *
 */
public class DO {

	public final static int windowHeight = 600;
	public final static int windowWidth = 1000;
	public final static int infoPanelWidth = 200;

	public final static int radius = 30;
	public final static int fontSize = 15;
	public final static int stroke = 4;

	public final static String backgroundImage = "/100yil.jpg";
	public final static String smallImage = "/rent.jpg";

	public Random random;
	public final static int randomSpeedBase = 15;
	public final static int randomSpeedVariation = 10;

	public final static double deltaStepTime = 0.1;
	public final static double defaultRestTime = 8.0;

	public DO() {
		random = new Random();
	}

	public int randomXInGridArea() {

		return random.nextInt(windowWidth - infoPanelWidth) + infoPanelWidth;
	}

	public int randomYInGridArea() {
		return random.nextInt(windowHeight);
	}

	public int randomSpeed() {
		int speed = randomSpeedBase + random.nextInt(randomSpeedVariation);
		return speed;

	}

	public void drawCenteredText(Graphics2D g, int x, int y, String text) {
		// Create a new font with the desired size
		Font newFont = g.getFont().deriveFont(fontSize);
		g.setFont(newFont);
		// Find the size of string s in font f in the current Graphics context
		FontMetrics fm = g.getFontMetrics();
		java.awt.geom.Rectangle2D rect = fm.getStringBounds(text, g);

		int textHeight = (int) (rect.getHeight());
		int textWidth = (int) (rect.getWidth());

		// Find the top left and right corner
		int cornerX = x - (textWidth / 2);
		int cornerY = y - (textHeight / 2) + fm.getAscent();

		// Draw the string
		g.drawString(text, cornerX + (DO.radius / 2), cornerY + (DO.radius / 2));
	}
}
