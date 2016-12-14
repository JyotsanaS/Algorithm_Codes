import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class PerfectHashingDuplicate {
	
	public static class Bucket
	{
		int a;
		int b;
		int p;
		int n;
		ArrayList AL;
		//Constructors
		public Bucket()
		{a=0;b=0;p=0;n=0;
		AL=new ArrayList<Integer>();}
		public Bucket(int x,int y,int z)
		{a=x;b=y;p=z;}
		
		//Getters And Setters
		public void setn(int x)
		{n=x;}
		public void seta(int x)
		{a=x;}
		public void setb(int x)
		{b=x;}
		public void setp(int x)
		{p=x;}
		public void setAL(ArrayList x)
		{AL=x;}
		public int getn()
		{return n;}
		public int geta()
		{return a;}
		public int getb()
		{return b;}
		public int getp()
		{return p;}
		public void set(Bucket buck)
		{
			this.a=buck.geta();
			this.b=buck.getb();
			this.AL=buck.getAL();
			this.n=buck.getn();
			this.p=buck.getp();
		}
		public ArrayList getAL()
		{return AL;}
		
	}
	
	public long[] createData(int n)
	{
		long ar[]=new long[n];
		for(int i = 0; i < n; i++) {
      		ar[i] = (long)(Math.random()*10000000 + 1);
    	   }
		return ar;
		
	}
	
	public static Bucket secondHashFunction(int a,int b,int m,int p,ArrayList AL)
	{
		Bucket bucket=new Bucket();
		p=179;
		Boolean flag=false;
		long newAL[]=new long[m];
		
		
		while(flag==false){
			Arrays.fill(newAL, 0);
			a=(int)(Math.random()*p + 1); 
			b=(int)(Math.random()*p + 1);
	
			for(int i=0;i<AL.size();i++)
			{
				int buck=(int) ((((a*(long)AL.get(i))+b)%p)%m);
				if(newAL[(int)buck]==0)
				{
					newAL[buck]=(long) AL.get(i);
					if(i==AL.size()-1){flag=true;}
				}
				else{
					break;
				}
				
			}
			
			
		}
		ArrayList BL=new ArrayList<Integer>();
		for(int i =0;i<newAL.length;i++)
        {

         /* We are adding each array's element to the ArrayList*/
		 BL.add(newAL[i]);
        }
		bucket.seta(a);
		bucket.setb(b);
		bucket.setAL(BL);
		bucket.setn(m);
		bucket.setp(p);
		return bucket;
		
	}
	
	static void printArray(long[] ar) {
         for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
         }
           System.out.println("");
      }
	
	public static void main(String[] args) {
		PerfectHashingDuplicate ph=new PerfectHashingDuplicate();
		//int ar[]={31,55,2,45,67,48,65,24,34,89,88,70,42,1,16,17,49,52,61,53};
		int x=1000000;
		long ar[]=ph.createData(x);
		//printArray(a);
		//int x=ar.length;
		Bucket[] hash=new Bucket[x*2];
		for(int i=0;i<x*2;i++)
			hash[i]=new Bucket();
		//generating primary hash function
		long p=1299877;
		//int p=53;
		int m=2*x;
		Boolean flag=false;
		int a=0,b=0;
		while(flag==false){
		a=(int)(Math.random()*p - 1); 
		b=(int)(Math.random()*p - 1);
		long sum=0;
		for(int i=0;i<ar.length;i++)
		{
			long buck=(((a*ar[i])+b)%p)%m;
			if(!hash[(int)buck].getAL().contains(ar[i]))
			{
				hash[(int)buck].getAL().add(ar[i]);
				int n=hash[(int)buck].getn();
				hash[(int)buck].setn(n+1);
			}
		}
		for(int i=0;i<m;i++)
		{	if(hash[i].getn()>1)
			{sum+=(hash[i].getn())*(hash[i].getn());}
		}
		
		if(sum<2*x) {flag=true; System.out.println("Sum="+sum);}
		}
		
		System.out.println("First Hash Function=(("+a+"x+"+b+")mod"+p+")mod"+m);
		
		//Calculating 2nd Hash Function
		for(int i=0;i<m;i++)
		{	if(hash[i].getn()>1)
			{
			int a1=hash[i].geta();
			int b1=hash[i].getb();
			int n1=hash[i].getn()*hash[i].getn();
			int p1=hash[i].getp();
			ArrayList A=hash[i].getAL();
			hash[i]=secondHashFunction(a1,b1,n1,p1,A);
			
			
			}
		System.out.println(i+"="+hash[i].getAL().toString());
		System.out.println("Second Hash Function=(("+hash[i].geta()+"x+"+hash[i].getb()+")mod"+hash[i].getp()+")mod"+hash[i].getn());
		
		}
		//Checking if duplicate value exist in any of the bucket
		int flagDuplicate=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<hash[i].getn();j++)
			{
				if((long)hash[i].getAL().get(j)==0)
					continue;
				for(int k=1;k<hash[i].getn();k++)
				{
					if(j==k)continue;
					if((long)hash[i].getAL().get(k)!=0)
					{
						if((long)hash[i].getAL().get(k)==(long)hash[i].getAL().get(j))
							{System.out.println(i+""+hash[i].getAL().toString());
							 System.out.println("Duplicate elements:"+hash[i].getAL().get(k)+" "+hash[i].getAL().get(j));flagDuplicate=1;}
					}
					if(flagDuplicate==1)
						break;
				}
				if(flagDuplicate==1)
					break;
			}
			if(flagDuplicate==1)
				break;
		}
		if(flagDuplicate==1) System.out.println("Duplicate Elements exist");
		else System.out.println("No Duplication occurs");
	}

}

