//BubbleSort works by checking each adjacent element. Places maximum element at its correct place at end of each iteration. 
//Time complexity: O(n^2) Comparisions: n(n-1)/2 Swaps is O(n^2)
//Extended Bubblesort reduces time complexity by maintaining a flag which checks no. of swaps in each iteration. At the end of iteration if flag
//is 0, then it means array is sorted and we come out of the bubble sort. Improves worst case to O(n). 

import java.util.Scanner;


public class ExtendedBubbleSort {

	private static void BubbleSort(int[] a, int n) {
		int flag=0;
		for(int i=0;i<n;i++)
		{	flag=0;
			for(int j=0;j<n-i-1;j++)
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					flag++;
				}
			if(flag==0)
				break;
		}
	}
	
	public static void main(String[] args) {
	int n=0;
	Scanner in=new Scanner(System.in);
	n=in.nextInt();
	int a[]=new int[n];
	for(int i=0;i<n;i++)
		a[i]=in.nextInt();
	BubbleSort(a,n);
	for(int i=0;i<n;i++)
		System.out.print(a[i]+" ");

	}
}

