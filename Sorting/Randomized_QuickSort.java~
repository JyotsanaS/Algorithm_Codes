import java.util.*;
public class Randomized_QuickSort {
          
          static int partition(int[] ar,int i,int j,int pivot) {
                    int l=i,r=j;
                    while(l<=r)
                    {
                        while(l<=r && ar[l]<=pivot)l++;
                        while(r>=l && ar[r]>pivot)r--;
                        
                        if(l<r)
                        {int temp=ar[l];
                         ar[l]=ar[r];
                         ar[r]=temp;
                         l++;r--;
                        }                      
                    }
                         if(ar[i]>=ar[r])
                         {int temp=ar[i];
                          ar[i]=ar[r];
                          ar[r]=temp; }
                    
                    return r;//Return current position of pivot element
          }   
 
 static int pivot(int[] ar,int l,int r)
{
	Random rand=new Random();
	int x=l+rand.nextInt(r-l+1);
	return(x);
}

 static void QuickSort(int[] ar,int l,int r)
 {
     if(l<r)
     {int p=pivot(ar,l,r);
	//Select random pivot element and move it to leftmost position by swapping it with ar[l]
      int t=ar[p];
      ar[p]=ar[l];
      ar[l]=t;
      int k=partition(ar,l,r,ar[p]);
      QuickSort(ar,l,k);
      QuickSort(ar,k+1,r);
     }
 }
 
 static void printArray(int[] ar,int l,int r) {
         for(int i=l;i<=r;i++){
            System.out.print(ar[i]+" ");
         }
           System.out.println("");
      }
    
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
          QuickSort(ar,0,ar.length-1);
          printArray(ar,0,ar.length-1);
       }    
   }


