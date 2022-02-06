#include <math.h>
#include <stdio.h>

void findSum(int *report, int length)
{
	// size_t length = sizeof(report) / sizeof(report[0]);
	for (int i = 0; i < length; i++)
	{
		for (int j = i + 1; j < length; j++)
		{
			if (report[j] + report[i] == 2020)
			{
				int sum = report[j] * report[i];
				printf("%i * %i = %i \n", report[j], report[i], sum);
			}
		}
	}
}

int main()
{
	int expenseReport[6] = {1721, 979, 366, 299, 675, 1456};
	findSum(expenseReport, 6);
	return 0;
}