package point;

import tester.*;
import java.util.*;

import point.Point;


//This Test.java file is from Chinney Vixathep

public class Test 
{
	public static void main(String[] args) 
	{
		Tester.run(new Test());
	}

	public void testAccount(Tester t) 
	{
		try {
// Constructor & Getter Positive Tests
			Point a = new Point(5, 5);
			Point b = new Point(3, 4);
			Point c = new Point(4, 3);
			Point d = new Point(2, 5);
			Point e = new Point(5, 2);
			
			//test a
			System.out.println( "Point a" );
			t.checkExpect(a.xcoor(), 5.00);											//test 1
			System.out.println( a.xcoor() );
			t.checkExpect(a.ycoor(), 5.00);											//test 2
			System.out.println( a.ycoor() );
			t.checkExpect(a.rho(), Math.sqrt(50));									//test 3
			System.out.println( Math.sqrt(50) );
			t.checkExpect(a.distance(), a.rho());									//test 4
			System.out.println( a.distance() );
			t.checkExpect(a.theta(), Math.asin(5/Math.sqrt(50))*(180/Math.PI));		//test 5
			System.out.println( Math.asin(5/Math.sqrt(50))*(180/Math.PI) + "\n");
			
			//test b
			System.out.println( "Point b" );
			t.checkExpect(b.xcoor(), 3.00);											//test 6
			System.out.println( b.xcoor() );
			t.checkExpect(b.ycoor(), 4.00);											//test 7
			System.out.println( b.ycoor() );
			t.checkExpect(b.rho(), Math.sqrt(25));									//test 8
			System.out.println( Math.sqrt(25) );
			t.checkExpect(b.distance(), b.rho());									//test 9
			System.out.println( b.distance() );
			t.checkExpect(b.theta(), Math.asin(4/Math.sqrt(25))*(180/Math.PI));		//test 10
			System.out.println( Math.asin(4/Math.sqrt(25))*(180/Math.PI) + "\n");
			
			
			//test c
			System.out.println( "Point c" );
			t.checkExpect(c.xcoor(), 4.00);											//test 11
			System.out.println( c.xcoor() );
			t.checkExpect(c.ycoor(), 3.00);											//test 12
			System.out.println( c.ycoor() );
			t.checkExpect(c.rho(), Math.sqrt(25));									//test 13
			System.out.println( Math.sqrt(25) );
			t.checkExpect(c.distance(), c.rho());									//test 14
			System.out.println( c.distance() );
			t.checkExpect(c.theta(), Math.asin(3/Math.sqrt(25))*(180/Math.PI));		//test 15
			System.out.println( Math.asin(3/Math.sqrt(25))*(180/Math.PI) + "\n");
			
			
			//test d
			System.out.println( "Point d" );
			t.checkExpect(d.xcoor(), 2.00);											//test 16
			System.out.println( d.xcoor() );
			t.checkExpect(d.ycoor(), 5.00);											//test 17
			System.out.println( d.ycoor() );
			t.checkExpect(d.rho(), Math.sqrt(29));									//test 18
			System.out.println( Math.sqrt(29) );
			t.checkExpect(d.distance(), d.rho());									//test 19
			System.out.println( d.distance() );
			t.checkExpect(d.theta(), Math.asin(5/Math.sqrt(29))*(180/Math.PI));		//test 20
			System.out.println( Math.asin(5/Math.sqrt(29))*(180/Math.PI) + "\n");
			
			
			//test e
			System.out.println( "Point e" );
			t.checkExpect(e.xcoor(), 5.00);											//test 21
			System.out.println( e.xcoor() );
			t.checkExpect(e.ycoor(), 2.00);											//test 22
			System.out.println( e.ycoor() );
			t.checkExpect(e.rho(), Math.sqrt(29));									//test 23
			System.out.println( Math.sqrt(29) );
			t.checkExpect(e.distance(), e.rho());									//test 24
			System.out.println( e.distance() );
			t.checkExpect(e.theta(), Math.asin(2/Math.sqrt(29))*(180/Math.PI));		//test 25
			System.out.println( Math.asin(2/Math.sqrt(29))*(180/Math.PI) + "\n");
			
			System.out.println("Point to Point distance:");
			t.checkExpect(b.distance(c), Math.sqrt(2));								//test 26
			System.out.println( "B to C: " + b.distance(c) + "\n");
			t.checkExpect(c.distance(b), Math.sqrt(2));								//test 27
			System.out.println( "C to B: " + c.distance(b) + "\n");
			t.checkExpect(d.distance(e), Math.sqrt(18));							//test 28
			System.out.println( "D to E: " + d.distance(e) + "\n");
			t.checkExpect(e.distance(d), Math.sqrt(18));							//test 29
			System.out.println( "E to D: " + e.distance(d) + "\n");
			
			
			//theta testing
			
			Point f = new Point(-5,  5);
			Point g = new Point(-5, -5);
			Point h = new Point( 5, -5);
			
			System.out.println( "Theta testing");
			t.checkExpect(a.theta(), (Math.abs(Math.asin(a.ycoor()/a.rho())*(180/Math.PI))));			//test 30
			System.out.println( a.theta() );
			t.checkExpect(f.theta(), (Math.abs(Math.asin(f.ycoor()/f.rho())*(180/Math.PI))+90));		//test 31
			System.out.println( f.theta() );
			t.checkExpect(g.theta(), (Math.abs(Math.asin(g.ycoor()/g.rho())*(180/Math.PI))+180));		//test 32
			System.out.println( g.theta() );
			t.checkExpect(h.theta(), (Math.abs(Math.asin(h.ycoor()/h.rho())*(180/Math.PI))+270));		//test 33
			System.out.println( h.theta() );
			System.out.println( "\n");
			
			
			
			
			
// Constructor Negative Test (none)
			
// Getter Negative Tests (none)
		 

// Setter methods Positive tests (none)
	
			
//Setter methods Negative Tests (none)
//rotate POSITIVE
			
			double temp = 0.00;
			
			System.out.println("Rotation testing");
			
			temp = a.theta();
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor());
			System.out.print(a.theta()+"  ->  ");
			a.rotate(45);
			t.checkExpect(a.theta(), temp + 45);			//test 34
			System.out.println(a.theta());
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor() + "\n");
			
			temp = f.theta();
			System.out.println("X: " + f.xcoor() + "   Y: " + f.ycoor());
			System.out.print(f.theta()+"  ->  ");
			f.rotate(45);
			t.checkExpect(f.theta(), temp + 45);			//test 35
			System.out.println(f.theta());
			System.out.println("X: " + f.xcoor() + "   Y: " + f.ycoor() + "\n");
			
			temp = g.theta();
			System.out.println("X: " + g.xcoor() + "   Y: " + g.ycoor());
			System.out.print(g.theta()+"  ->  ");
			g.rotate(45);
			t.checkExpect(g.theta(), temp + 45);			//test 36
			System.out.println(g.theta());
			System.out.println("X: " + g.xcoor() + "   Y: " + g.ycoor() + "\n");
			
			temp = h.theta();
			System.out.println("X: " + h.xcoor() + "   Y: " + h.ycoor());
			System.out.print(h.theta()+"  ->  ");
			h.rotate(45);
			t.checkExpect(h.theta(), temp + 45 - 360);			//test 37
			System.out.println(h.theta());
			System.out.println("X: " + h.xcoor() + "   Y: " + h.ycoor() + "\n");
			
			System.out.println();
			
			a.rotate(-45);
			f.rotate(-45);
			g.rotate(-45);
			h.rotate(-45);
			
			System.out.println();
						
			System.out.println(a.theta());
			System.out.println(f.theta());
			System.out.println(g.theta());
			System.out.println(h.theta());
			
			System.out.println();
			System.out.println("Wrap around degree testing");
			
			temp = h.theta();
			System.out.println("X: " + h.xcoor() + "   Y: " + h.ycoor());
			System.out.print(h.theta()+"  ->  ");
			h.rotate(90);
			t.checkExpect(h.theta(), (temp + 90) - 360);			//test 38
			System.out.println(h.theta());
			System.out.println("X: " + h.xcoor() + "   Y: " + h.ycoor() + "\n");
			h.rotate(-90);
			
			System.out.println();
			
//rotate NEGATIVE (none)
			
			
			
//translate POSITIVE
			
			temp = 5.00;
			
			System.out.println("Translation testing");
			System.out.println("Basics");
			
			Point i = new Point( 5, 10);
			Point j = new Point(10,  5);
			Point k = new Point( 0,  5);
			Point l = new Point( 5,  0);
			
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor());
			a.translate(0, 5);
			t.checkExpect(a, i);							//test 39
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor() + "\n");
			a.translate(0, -5);
						
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor());
			a.translate(5, 0);
			t.checkExpect(a, j);							//test 40
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor() + "\n");
			a.translate(-5, 0);
			
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor());
			a.translate(-5, 0);
			t.checkExpect(a, k);							//test 41
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor() + "\n");
			a.translate(5, 0);
			
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor());
			a.translate(0, -5);
			t.checkExpect(a, l);							//test 42
			System.out.println("X: " + a.xcoor() + "   Y: " + a.ycoor() + "\n");
			a.translate(0, 5);
			
			
//translate NEGATIVE (none)
			
			

			
			
//distance(Point p) NEGATIVE (none)
			
		} 
		
//Come here for any unexpected Exceptions
		catch (Exception e) 
		{
			e.printStackTrace();
			t.fail();
		}
	}
}
