//Selection sort selects smallest element and pivot to its position. So for inner loop for finding minimum element takes O(n) and swaps takes 
//place only once every iteration:- O(n)
//SelectionSort is preferred when memory writes are more expensive than memory reads and array is small of 10-20 elements O(n). Eg. Sorting 
//files in-place in flash drive

import java.util.Scanner;

public class SelectionSort{
	public static void SelectionSort(int a[],int n)
	{
		int min;
		for(int i=0;i<n;i++)
			{
				min=i;
				for(int j=i+1;j<n;j++)
				{
					if(a[min]>a[j])
						min=j;
				}
				a[i]=a[i]+a[min];
				a[min]=a[i]-a[min];
				a[i]=a[i]-a[min];

			}
	}

	public static void main(String args[])
	{
		int n=0;
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		SelectionSort(a,n);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
	}
}
