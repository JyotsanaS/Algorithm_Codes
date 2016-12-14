import java.util.Scanner;


public class KnapSack {

	/**
	 * 0-1 knapsack problem i: item j:weight
	 */
	public static int w,n;
	public static int item_profit[],item_weight[];
	public static int dp[][];
	
	public static void dp_table()
	{
		dp=new int[n+1][w+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=w;j++)
				dp[i][j]=0;
		//Base Condition
		for(int i=1;i<=w;i++)
			{if(item_weight[0]>i)
			dp[1][i]=0;
			else
				dp[1][i]=item_profit[0];}
		
		//Now Optimal Substructure
		for(int i=2;i<=n;i++)
			for(int j=1;j<=w;j++)
			{
				//Picking ith item
				int m1=0;
						if((j-item_weight[i-1])>=0)
						m1=item_profit[i-1]+dp[i-1][j-item_weight[i-1]];
						
			    //Not Picking ith item
				int m2=dp[i-1][j];
				
				if(m1>m2)
					dp[i][j]=m1;
				else
					dp[i][j]=m2;
			}
		
		printArray(dp);
		
	}
	
	
	
	public static void backtrack()
	{
		int x=dp[n][w];
		int i=n,j=w;
		while(x>0 && i>0 && j>0)
		{
			if(x!=dp[i-1][j])
				{
				System.out.print(i+"  ");
				j=j-item_weight[i-1];
				i=i-1;
				if(j>=0 && i>=0)
				x=dp[i][j];
				else
					x=0;
				}
			else
			{
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
		System.out.println("Enter knapsack size");
		w=sc.nextInt();
		System.out.println("Enter item list size");
	    n=sc.nextInt();
		System.out.println("Enter weight & profit of each item");
		item_weight=new int[n];
		item_profit=new int[n];
		item_weight[0]=0;
		item_profit[0]=0;
		for(int i=0;i<n;i++)
		{
			item_weight[i]=sc.nextInt();
			item_profit[i]=sc.nextInt();
		}
		System.out.println("Weight");
		printArray(item_weight);
		System.out.println("Profit");
		printArray(item_profit);
		System.out.println("----------------------------------------------------------");
		dp_table();
		System.out.println("Max Profit:="+dp[n][w]);
		backtrack();

	}

}
