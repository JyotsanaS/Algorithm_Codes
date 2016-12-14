//Here no. of comparison depends on no. of inversions. Worst case O(n^2), Best case O(n)
//Time complexity: O(n+d)
//Useful in partially sorted arrays. Less no. of comparisons reqd.

import java.util.Scanner;

public class InsertionSort
{
	public static void InsertionSort(int a[],int n)
	{
		int t,j;
		for(int i=1;i<n;i++)
		{
			t=a[i];
			j=i-1;
			while(j>=0 && a[j]>t)
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=t;
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
		InsertionSort(a,n);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");in.nextInt();
		
	}
}
