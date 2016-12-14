import java.util.*;
public class QSort_Pivot1stement {
          
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
    

 static void QuickSort(int[] ar,int l,int r)
 {
     if(l<r)
     {int p=ar[l];
      int k=partition(ar,l,r,p);
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


