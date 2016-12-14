import java.util.Scanner;


public class EditDistance {

	/**
	 * Subset-Sum problem i: item j:Sum
	 */
	public static int dp[][];
	
	public static void dp_table(String s1,String s2,int a,int d,int r)
	{
		dp=new int[s1.length()+1][s2.length()+1];
		
		for(int i=0;i<=s1.length();i++)
			for(int j=0;j<=s2.length();j++)
				dp[i][j]=0;
		for(int i=0;i<=s2.length();i++)
			dp[0][i]=i*a;
		for(int i=0;i<=s1.length();i++)
			dp[i][0]=i*a;
		
		//Base Condition
		for(int i=1;i<=s2.length();i++)
			{
				if(i==1)
					if(s1.charAt(0)==s2.charAt(i-1))
						dp[1][i]=0;
					else
						dp[1][i]=r;
				else
				{
					dp[1][i]=dp[1][i-1]+a;
				}
			}
		
		for(int i=1;i<=s1.length();i++)
		{
			if(i==1)
				if(s2.charAt(0)==s1.charAt(i-1))
					dp[i][1]=0;
				else
					dp[i][1]=r;
			else
			{
				dp[i][1]=dp[i-1][1]+a;
			}
		}
		
		for(int i=1;i<=s1.length();i++)
		{
			if(i==1)
				if(s2.charAt(0)==s1.charAt(i-1))
					dp[i][1]=0;
				else
					dp[i][1]=r;
			else
			{
				dp[i][1]=dp[i-1][1]+a;
			}
		}
		
		//Now Optimal Substructure
		for(int i=2;i<=s1.length();i++)
			for(int j=2;j<=s2.length();j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1];
				}
				else
				{
					int min=dp[i-1][j-1]+r;
					if(min>(dp[i][j-1]+a))
						min=dp[i][j-1]+a;
					System.out.println((i-1)+" "+j);
					if(min>(dp[i-1][j]+d))
						min=dp[i-1][j]+d;
					dp[i][j]=min;
				}
			}
		
		
		printArray(dp,s1.length(),s2.length());
		
		
	}
	

	
	
	public static void backtrack(String s1,String s2,int r,int a,int d)
	{
		int n=s1.length();
		int m=s2.length();
		int x=dp[n][m];
		int i=n;
		int j=m;
		while(x>0 && i>0 && j>0)
		{
			if(s1.charAt(i-1)==s2.charAt(j-1))
			{
				i=i-1;j=j-1;
			}
			else
			{
				if(dp[i][j]==dp[i-1][j-1]+r)
				{System.out.println("replace "+s1.charAt(i-1)+" with "+s2.charAt(j-1));
				 i=i-1;j=j-1;}
				else if(dp[i][j]==dp[i-1][j]+d)
				{System.out.println("delete "+s1.charAt(i-1));
				 i=i-1;j=j;}
				else{
				System.out.println("add "+s2.charAt(j-1));
				i=i;j=j-1;	
				}
			}
		}
	}
	
	public static void printArray(int a[][],int n,int m)
	{
		for(int i=0;i<=n;i++)
			{for(int j=0;j<=m;j++)
			System.out.print(a[i][j]+" ");
		System.out.println("");}
	}
	

	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1,s2=new String();
		System.out.println("Enter two strings");
		s1=sc.nextLine();
		s2=sc.nextLine();
		System.out.println("Enter cost of addition, deletion and replacement");
		int a=sc.nextInt();
		int d=sc.nextInt();
		int r=sc.nextInt();
		
		
		System.out.println("----------------------------------------------------------");
		dp_table(s1,s2,a,d,r);
		System.out.println("Minimum Edit Distance Cost:"+dp[s1.length()][s2.length()]);
		backtrack(s1,s2,r,a,d);
	}

}
