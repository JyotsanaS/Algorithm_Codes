import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class cycleDetection {

	public static class AdjacencyList
	{
		int n;
		ArrayList<ArrayList<Integer>> adjLists;
		ArrayList <Boolean> colour;
		ArrayList <Integer> parent;
		ArrayList <Integer> discoveryTime;
		ArrayList <Integer> finishTime;
		
		public AdjacencyList()
		{
			n=0;
			adjLists=new ArrayList<ArrayList<Integer>>();
			colour=new ArrayList<Boolean>();
			parent=new ArrayList<Integer>();
			discoveryTime=new ArrayList<Integer>();
			finishTime=new ArrayList<Integer>();
		}
		
		public void addVertex(int vertex,ArrayList <Integer>AL)
		{
			adjLists.add(AL);
			n++;
			colour.add(false);
			parent.add(-1);
			discoveryTime.add(-1);
			finishTime.add(-1);
		}
		
		public int getN()
		{
			return n;
		}
		public void setParent(int v,int x)
		{
			parent.set(v, x);
		}
		
		public int getParent(int v)
		{
			return parent.get(v);
		}
		
		public boolean getColour(Object v)
		{
			return colour.get((int) v);
		}
		
		public void setColour(int v,boolean b)
		{
			colour.set(v, b);
		}
		
		public ArrayList<Integer> getNeighbour(int vertex)
		{
			if(n>vertex)
			return adjLists.get(vertex);
			else
				return null;
		}
		
		public void printGraph()
		{
			System.out.println(n);
			for(int i=0;i<n;i++)
			{
				System.out.println(i+":"+getNeighbour(i).toString());
			}
		}
	}
	
	public static void DFS_Traversal(AdjacencyList graph)
	{
		Stack stackGraph=new Stack();
		int n=graph.getN();
		ArrayList DFSList=new ArrayList<Integer>();
		stackGraph.push(0);
		int time=0;
		do
		{
			//System.out.println(QGraph.toString());
			
			int i=(int) stackGraph.pop();
			if(graph.getColour(i)==false)
			{//System.out.print(i+" ");
			DFSList.add(i);
			ArrayList AL=new ArrayList <Integer>();
			AL=graph.getNeighbour(i);
			graph.setColour(i, true);
			time++;
			graph.discoveryTime.set(i, time);
			stackGraph.push(i);
			for(Object v:AL)
			{
				//System.out.println(v);
				if(graph.getColour(v)==false)
				{stackGraph.push(v);
				 graph.setParent((int)v, i);
				}
			}}
			else if(graph.getColour(i)==true && graph.finishTime.get(i)==-1)
			{
				time++;
				graph.finishTime.set(i, time);
			}
		}while(!stackGraph.isEmpty());
		System.out.println(DFSList.toString());
		System.out.println(graph.parent.toString());
		System.out.println(graph.discoveryTime.toString());
		System.out.println(graph.finishTime.toString());
	}
	
	public static boolean cycledetect(AdjacencyList graph)
	{
		DFS_Traversal(graph);
		System.out.println("-----------------------------------------------------------");
		for(int u=0;u<graph.adjLists.size();u++)
		{
			ArrayList AL=new ArrayList <Integer>();
			AL=graph.getNeighbour(u);
			for(Object v:AL)
			{
				if(graph.finishTime.get((int)v)>graph.finishTime.get(u))
					return true;
			}
		}return false;
	}
	
	public static void main(String[] args) {
		AdjacencyList graph=new AdjacencyList();
		Scanner sc=new Scanner(System.in);
		//Input graph
		System.out.println("Enter no. of vertex of graph");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{	System.out.println("Enter no. of neighbour of vertex "+i);
			int x=sc.nextInt();
			ArrayList A=new ArrayList<Integer>();
			if(x>0){
			System.out.println("Enter neighbours of vertex "+i);
			
			for(int j=0;j<x;j++)
			{
				A.add(sc.nextInt());
			}
			}
			graph.addVertex(i, A);
		}
		graph.printGraph();
		System.out.println(cycledetect(graph));
	}

}

