import java.util.*;
public class LabeledPoint implements Comparable<LabeledPoint>
{
	private int x;
	private int y;
	private String label;
	
	public LabeledPoint()
	{
		x = 0;
		y = 0;
		label = "Untitled label";
	}

	public LabeledPoint(int newX, int newY, String newLabel)
	{
		x = newX;
		y = newY;
		label = newLabel;
	}

	@Override
	public int hashCode()
	{
		int labelHash = label.hashCode();
		int hashSum= 41 * (labelHash + (x + 7) + y);
		return hashSum;
		
	}
	
	@Override
	public int compareTo(LabeledPoint otherLabeledPoint)
	{
		if (this.hashCode() < otherLabeledPoint.hashCode())
			return -1;
		else if (this.hashCode() > otherLabeledPoint.hashCode())
			return 1;
		else
			return 0;				
	}
	
	@Override
	public boolean equals(Object otherLabel)
	{
		LabeledPoint anotherObject = (LabeledPoint)otherLabel;
		if ((this.x == anotherObject.x) &&
			(this.y == anotherObject.y) &&
			(this.label.equals(anotherObject.label)))
			return true;
		return false;
	}	
}