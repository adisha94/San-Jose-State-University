import java.awt.Rectangle;

/**
 *  This method uses the excercises from E9.11
 * @author Adish
 *
 */
public class BetterRectangle extends Rectangle
{
	
	public BetterRectangle(int x, int y, int width, int height)
	{
		super(x, y, width, height);
	}
	
	public int getPerimeter()
	{
		return (width + height) * 2;
	}
	
	public int getArea()
	{
		return (width * height);
	}
}
