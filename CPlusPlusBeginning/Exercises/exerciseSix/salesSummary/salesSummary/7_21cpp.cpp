/*************************************************************************************
Programmer: Taras Derewecki
Date: 11/20/2015
Chapter 7, Section 21: Sales Summary
*************************************************************************************/


#include <iostream>
#include <iomanip>
using namespace std;

int main()

{

	int salesChart[150][5];
	char a = '1';
	int Number_of_Day = 0;
	int rowNumber = 0;
	int Total_of_Product;
	int Sale_of_Salesman[4];

	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			salesChart[i][j] = 0;
		}
	}

	do
	{

		cout << endl << "Enter the details of the day " << (Number_of_Day + 1);

		do
		{


			cout << endl << "Enter the salesperson number: ";
			cin >> salesChart[rowNumber][0];

			cout << endl << "Enter the product number: ";
			cin >> salesChart[rowNumber][0];

			cout << endl << "Enter the total dollar value " << "of that product sold that day: ";
			cin >> salesChart[rowNumber][2];

			salesChart[rowNumber][3] = Number_of_Day + 1;

			cout << endl << "Do you want to enter one more (Y/N): ";
			cin >> a;

			rowNumber++;

		} while (tolower(a) != 'n');
		Number_of_Day++;

	} while (Number_of_Day < 30);

	for (int i = 1; i <= Number_of_Day; i++)
	{




		for (int j = 0; j < 4; j++)
			Sale_of_Salesman[j] = 0;



		cout << endl << endl <<setw(10) << "Sales Summary for the dau" << i << endl;
		cout << "Product# Salesman1 Salesman2 Salesman3 Salesman4 Totals";
		cout << endl << "_____________________________________________________________";


		for (int p = 1; p < 6; p++)
		{


			Total_of_Product = 0;
			cout << endl << setw(5) << p;

			for (int salesOfWoperchild = 1; salesOfWoperchild < 5; salesOfWoperchild++)
			{

				bool found = false;
				for (int r = 0; r < rowNumber; r++)
				{

					if (salesChart[r][1] == p)
					{
						if (salesChart[r][0] == salesOfWoperchild)
						{
							if (salesChart[r][3] == i)

							{

								Total_of_Product += salesChart[r][2];
								Sale_of_Salesman[salesOfWoperchild - 1] += salesChart[r][2];
								cout << setw(13) << salesChart[r][2];
								found = true;
							}
						}
					}


				}

				if (found == false)
				{
					cout << setw(13) << "0";
				}
			}


			cout << setw(10) << Total_of_Product;

		}


		cout << endl << "__________________________________________________________________";
		cout << endl << "total";

		Total_of_Product = 0;

		for (int j = 0; j < 4; j++)

		{

			cout << setw(13) << Sale_of_Salesman[j];
			Total_of_Product += Sale_of_Salesman[j];

		}

		cout << setw(10) << Total_of_Product;
		cout << endl << "_________________________________________________________________";

	}


	system("pause");
	return 0;
}