package point;

import java.util.*;

public class Point implements Cloneable
{
	private double xcoor;
	private double ycoor;
	private Point OLD;
	
	public Point(double a, double b) 
	{
		xcoor = a;
		ycoor = b;
	}

	/*
	public double getXcoor() {
		return xcoor;
	}
	 */
	
	public void setXcoor(double xcoor) {
		this.xcoor = xcoor;
	}

	/*
	public double getYcoor() {
		return ycoor;
	}
	 */
	
	public void setYcoor(double ycoor) {
		this.ycoor = ycoor;
	}

	public double xcoor() 
	{
		return xcoor;
	}
	
	public double ycoor() 
	{
		return ycoor;
	}

	public double theta() 
	{
		//the math logic here is to cross multiply from the know angle (90 degrees)
		//and the hypoteneuse (rho()) to the unknown angle and the length of the opposite side (ycoor)
		
		/*
		 sin(angle) = opp / hyp
		 sin(angle) = ycoor / rho()
		 
		 arcsin( opp / hyp ) = angle
		 arcsin( ycoor / rho() ) = angle
		 
		 convert from radians to degrees
		 
		 */
		double result = 0.00;
		
		//if the resulting angle will be in the two left quadrants
		if( xcoor < 0)
		{
			//if the resulting angle will be in the bottom left quadrant
			if( ycoor < 0 )
			{
				//adjust by 180 degrees
				//result = (Math.abs(Math.asin(ycoor/rho())*(180/Math.PI)) + 180);
				result = (Math.toDegrees(Math.abs(Math.asin(ycoor/rho())))+180);
			}
			else
			{
				//adjust by 90 degrees
					//inverse triangle by using x instead of y for sin
				//result = (Math.abs(Math.asin(xcoor/rho())*(180/Math.PI)) + 90);
				result = (Math.toDegrees(Math.abs(Math.asin(xcoor/rho())))+90);
			}
		}
		
		//if the resulting angle will in the bottom right quadrant
		else if( ycoor < 0 )
		{
			//adjust by 270 degrees
				//inverse triangle by using x instead of y for sin
			//result = (Math.abs(Math.asin(xcoor/rho())*(180/Math.PI) ) + 270);
			result = (Math.toDegrees(Math.abs(Math.asin(xcoor/rho())))+270);
		}
		else
		{
			//do not adjust
			//result = (Math.abs(Math.asin(ycoor/rho())*(180/Math.PI)));
			result = (Math.toDegrees(Math.abs(Math.asin(ycoor/rho()))));
		}
		
		while( result >= 360.00 )
		{
			result = result - 360.00;
		}
		
		return result;
		
	}

	public double rho() 
	{
		return Math.sqrt( Math.pow(xcoor, 2) + Math.pow(ycoor, 2) );
	}

	public void translate(double a, double b) 
	{
		xcoor = xcoor() + a;
		ycoor = ycoor() + b;
	}

	public void rotate(double a) 
	{
		//rotate the point an angle of a
		
		/*
		 * the sin(theta() + a) = opposite {new.ycoor} / hypoteneuse {new.rho}
		 * and
		 * the cosin(theta() + ) = adjacent {new.xcoor} / hypoteneuse {new.rho}
		 * finally
		 * given that old.rho = new.rho (or should approximately)
		 * 
		 * double tempx;
		 * double tempy;
		 * 
		 //find the new x coordinate based on the cosine of the new angle and rho
		 * tempx = cosin(theta() + a) * rho()
		 //find the new y coordinate based on the sine of the new angle and rho
		 * tempy = sin(theta() + a) * rho()
		 * 
		 //assign new values
		 * xcoor = tempx;
		 * ycoor = tempy;
		 */
		
		//xcoor = Math.cos((theta() + a)*(Math.PI/180)) * OLD.rho();
		//ycoor = Math.sin((theta() + a)*(Math.PI/180)) * OLD.rho();
		
		
		double tempx;
		double tempy;
		 
		//find new x
		//tempx = Math.cos((theta() + a)*(Math.PI/180)) * rho();	//right
		//tempx = Math.toRadians(Math.cos((theta() + a))) * rho();  //wrong
		tempx = Math.cos(Math.toRadians((theta() + a))) * rho();	//right
		//find new y
		//tempy = Math.sin((theta() + a)*(Math.PI/180)) * rho();	//right
		//tempy = Math.toRadians(Math.sin((theta() + a))) * rho();  //wrong
		tempy = Math.sin(Math.toRadians((theta() + a))) * rho();	//right
		
		
		xcoor = tempx;
		ycoor = tempy;
		
	}

	public double distance() 
	{
		return Math.sqrt( Math.pow(xcoor, 2) + Math.pow(ycoor, 2) );
	}

	public double distance(Point p) 
	{
		return Math.sqrt( Math.pow(xcoor-p.xcoor(), 2) + Math.pow(ycoor-p.ycoor, 2) );
	}

	protected boolean Point_Postcondition(double a, double b, Void RESULT) 
	{
		return xcoor == a && ycoor == b;
	}

	protected boolean translate_Postcondition(double a, double b, Void RESULT) 
	{
		return (xcoor == OLD.xcoor + a) && (ycoor == OLD.ycoor + b);
	}

	protected boolean rotate_Postcondition(double a, Void RESULT) 
	{
		return (theta() == OLD.theta() + a);
	}

	protected boolean distance_Postcondition(double RESULT) 
	
	{
		return distance() == rho();
	}

	protected boolean distance_Postcondition(Point p, double RESULT) 
	
	{
		return distance(p) == Math.sqrt( Math.pow(xcoor-p.xcoor(), 2) + Math.pow(ycoor-p.ycoor, 2) );
	}

	

}
