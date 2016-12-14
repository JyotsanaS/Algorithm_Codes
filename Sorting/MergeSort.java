import java.util.Scanner;

public class MergeSort{
	public static int n;
	public static int B[]=new int[1000];
	public static void Merge(int a[],int l,int k,int r)
	{
		int i=l,j=k+1,a1=l;
		
		while(i<=k && j<=r)
		{
			if(a[i]<a[j])
				{B[a1++]=a[i++];}
			else
				{B[a1++]=a[j++];}
		}
		while(i<=k)
			{B[a1++]=a[i++];}
		while(j<=r)
			{B[a1++]=a[j++];}
		a1=0;
		
		while(a1<=r)
			{a[a1]=B[a1];
			 a1++;}
				
	}

	public static void MergeSort(int a[],int l,int r)
	{
		if(l<r)
		{
		int k=(l+r)/2;
		MergeSort(a,l,k);
		MergeSort(a,k+1,r);
		Merge(a,l,k,r);
		}
	}

	public static void main(String args[])
	{
		
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		MergeSort(a,0,n-1);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");			
	}
}

