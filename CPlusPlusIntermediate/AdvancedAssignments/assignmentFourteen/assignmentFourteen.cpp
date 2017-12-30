#include <iostream>
#include <iomanip>
#include <string>
#include <cmath>

using namespace std;

class Point 
{

private:

	double xCoord;

	double yCoord;

public:

	// constructors

	Point() { };

	Point(double x, double y) 
	{

		xCoord = x;

		yCoord = y;

	}

	// accessor functions

	double getX() { return xCoord; }

	void setX(double x) { xCoord = x; }

	double getY() { return yCoord; }

	void setY(double y) { yCoord = y; }



	// methods

	string getQuadrant() 
	{

		if ((xCoord == 0.0) && (yCoord == 0.0))

			return "Origin";

		else if (xCoord == 0.0) return "Y-axis";

		else if (yCoord == 0.0) return "X-axis";

		else if ((xCoord > 0.0) && (yCoord > 0.0))

			return "Quadrant I";

		else if ((xCoord < 0.0) && (yCoord > 0.0))

			return "Quadrant II";

		else if ((xCoord < 0.0) && (yCoord < 0.0))

			return "Quadrant III";

		else return "Quadrant IV";

	}

	double distance(Point p) 
	{
		return pow(pow(p.xCoord - xCoord, 2.0) +
			pow(p.yCoord - yCoord, 2.0), 0.5);

	}

	Point midpoint(Point p) 
	{

		Point pAux;

		pAux.xCoord = (xCoord + p.xCoord) / 2.0;

		pAux.yCoord = (yCoord + p.yCoord) / 2.0;

		return pAux;

	}

};



class Line 
{

private:

	Point ptOne;

	Point ptTwo;

public:

	// constructors

	Line() { };

	Line(Point pt1, Point pt2) 
	{

		ptOne = pt1;

		ptTwo = pt2;

	}

	// accessor functions



	// methods

	void printTheFunction()

	{

		int m = ((ptOne.getY() - ptTwo.getY()) / (ptOne.getX() - ptTwo.getX()));

		if (ptOne.getX() == ptTwo.getX())

		{

			cout << "Slope is 0 for x at " << ptOne.getX() << endl;

		}

		else if (ptOne.getY() == ptTwo.getY())

		{

			cout << "Slope is undefined at " << ptOne.getY() << endl;

		}

		else

		{

			cout << "slope is " << m << endl;

			cout << "y-int of b is " << (ptOne.getY() - (m * ptOne.getX())) << endl;

		}

	}

};





int main() 
{

	double d;

	Point p1;

	Point p2(0.0, 0.0);

	p1.setX(1.0);

	p1.setY(1.0);



	cout << fixed << setprecision(4);

	cout << "p1 = (" << p1.getX() << "," << p1.getY()

		<< ")" << endl;

	cout << "Location: " << p1.getQuadrant() << endl;

	cout << "p2 = (" << p2.getX() << "," << p2.getY()

		<< ")" << endl;

	cout << "Location = " << p2.getQuadrant() <<

		endl;



	Point midP = p1.midpoint(p2);

	cout << "The midpoint is at (" << midP.getX() <<

		"," << midP.getY() << ")" << endl;



	d = p1.distance(p2);

	cout << "Distance = " << d << endl;



	Line equationOfLine (p1, p2);

	equationOfLine.printTheFunction();


	return 0;

}