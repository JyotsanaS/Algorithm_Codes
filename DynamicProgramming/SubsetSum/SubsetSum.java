import java.util.Scanner;


public class SubsetSum {

	/**
	 * Subset-Sum problem i: item j:Sum
	 */
	public static int w,n;
	public static int item[];
	public static int dp[][];
	
	public static void dp_table()
	{
		dp=new int[n+1][w+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=w;j++)
				dp[i][j]=0;
		dp[0][0]=1;
		//Base Condition
		if(item[0]<=w)
		dp[1][item[0]]=1;
		
		//Now Optimal Substructure
		for(int i=2;i<=n;i++)
			for(int j=1;j<=w;j++)
			{
				
				//Picking ith item
				int m1=0;
				if(item[i-1]==j)
					m1=1;
				else if((j-item[i-1])>=0)
					m1=dp[i-1][j-item[i-1]];
						
			    //Not Picking ith item
				int m2=dp[i-1][j];
				
				if((m1|m2)==1)
					dp[i][j]=1;
				else
					dp[i][j]=0;
			}
		
		printArray(dp);
		
	}
	
	
	
	public static void backtrack()
	{
		int x=w;
		int i=n,j=w;
		while(x>0 && i>0 && j>0)
		{
			if(dp[i][j]==1)
				i=i-1;
			else
			{
				System.out.println(item[i]);
				j=j-item[i];
				x=x-item[i];
				i=i-1;
				
			}
				
		}
	}
	
	public static void printArray(int a[][])
	{
		for(int i=0;i<=n;i++)
			{for(int j=0;j<=w;j++)
			System.out.print(a[i][j]+" ");
		System.out.println("");}
	}
	
	public static void printArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println("");
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter array size");
		n=sc.nextInt();
		item=new int[n];
		System.out.println("Enter array elements");
		for(int i=0;i<n;i++)
		{
			item[i]=sc.nextInt();
		}
		System.out.println("Enter Sum=");
		w=sc.nextInt();
		printArray(item);
		
		System.out.println("----------------------------------------------------------");
		dp_table();
		if(dp[n][w]==1)
		System.out.println("The sum"+" "+w+" "+"can be made.");
		backtrack();

	}

}
