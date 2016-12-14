import java.util.Scanner;


public class MCM {

	/**
	 * Matrix Chain Multiplication problem 
	 */
	public static int n;
	public static int item[];
	public static int dp[][];
	public static int s[][];
	
	public static void dp_table()
	{
		dp=new int[n+1][n+1];
		s=new int[n+1][n+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=n;j++)
				{dp[i][j]=0;s[i][j]=0;}
		
		//Base Condition
		for(int i=1;i<=n-1;i++)
			{dp[i][i+1]=item[i-1]*item[i]*item[i+1];
			 s[i][i+1]=i+1;
			}
		
		//Now Optimal Substructure
		
		
		for(int l=2;l<=n;l++)//length size
		{
			for(int i=1;i<=n-l+1;i++)
			{
				int j=i+l-1;
				dp[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<=j-1;k++)
				{
					 int q = dp[i][k] + dp[k + 1][j] + item[i-1]*item[k]*item[j];
                     if(q < dp[i][j]) {
                             dp[i][j] = q;
                             s[i][j]=k;
                     }
				}
			}
		}
		
		printArray(dp);
		System.out.println("-------------------------------------------------");
		printArray(s);
		
	}
	
	private static String printOptimalParens(int i, int j)
    {
        if (i == j)
            return "A[" + i + "]";
        else
            return "(" + printOptimalParens(i, s[i][j])
                    + printOptimalParens(s[i][j] + 1, j) + ")";
    }
 
    
	
	public static void printArray(int a[][])
	{
		for(int i=0;i<=n;i++)
			{for(int j=0;j<=n;j++)
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
		System.out.println("Enter no. of matrices");
		n=sc.nextInt();
		item=new int[n+1];
		System.out.println("Enter size of matrices in form of p0,p1,..,pn");
		for(int i=0;i<=n;i++)
		{
			item[i]=sc.nextInt();
		}
		printArray(item);
		
		System.out.println("----------------------------------------------------------");
		dp_table();
		System.out.println("Minimum Product:"+dp[1][n]);
		//backtrack();
		System.out.println(printOptimalParens(1, n));
	}

}
