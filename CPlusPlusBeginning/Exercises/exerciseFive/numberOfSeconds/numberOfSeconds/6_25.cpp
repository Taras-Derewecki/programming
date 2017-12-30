#include <iostream>
using namespace std;

int passSecs(int, int, int); //prototype
int diff(int, int, int); //prototype

int main()
{
	int hour_One, minute_One, second_One;
	int hour_Two, minute_Two, second_Two;

	cout << "Enter the hours, minutes, and seconds (It must be between 00:00:00 - 23:59:59): ";
	cin >> hour_One >> minute_One >> second_One;
	cout << endl;

	while (hour_One > 23 || minute_One > 59 || second_One > 59)
	{
		if (hour_One > 24)
			cout << "Incorrect hours value!\n";
		if (minute_One > 24)
			cout << "Incorrect minutes value!\n";
		if (second_One > 24)
			cout << "Invalid seconds value!\n";

		cout << "Enter hours, minutes and seconds: ";
		cin >> hour_One >> minute_One >> second_One;
	}
	cout << "Passed seconds from last 12 (AM or PM): " << passSecs(hour_One, minute_One, second_One);

	cout << "Enter hours, minutes and seconds between 00:00:00 - 23:59:59: ";
	cin >> hour_Two >> minute_Two >> second_Two;

	while (hour_Two > 23 || minute_Two > 59 || second_Two > 59)
	{
		if (hour_Two > 24)
			cout << "Incorrect hours value!\n";
		if (minute_Two > 24)
			cout << "Incorrect minutes value!\n";
		if (second_Two > 24)
			cout << "Invalid seconds value!\n";

		cout << "Enter hours, minutes and seconds: ";
		cin >> hour_Two >> minute_Two >> second_Two;
	}

	cout << "Difference of times: "
		<< diff(hour_Two, minute_Two, second_Two) - diff(hour_One, minute_One, second_One) << " seconds.";

	system("PAUSE");
	return 0;
}

int passSecs(int hour, int minute, int second)
{
	if (hour >= 12)
		hour -= 12;

	return hour * 60 * 60 + minute * 60 + second;
}

int diff(int hour, int minute, int second)
{
	return hour * 60 * 60 + minute * 60 + second;
}