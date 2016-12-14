import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BFS {

	public static class AdjacencyList
	{
		int n;
		ArrayList<ArrayList<Integer>> adjLists;
		ArrayList <Boolean> colour;
		
		public AdjacencyList()
		{
			n=0;
			adjLists=new ArrayList<ArrayList<Integer>>();
			colour=new ArrayList<Boolean>();
		}
		
		public void addVertex(int vertex,ArrayList <Integer>AL)
		{
			adjLists.add(AL);
			n++;
			colour.add(false);
		}
		
		public int getN()
		{
			return n;
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
	
	public static void BFS_Traversal(AdjacencyList graph)
	{
		Queue QGraph=new LinkedList();
		int n=graph.getN();
		ArrayList BFSList=new ArrayList<Integer>();
		QGraph.add(0);
		do
		{
			//System.out.println(QGraph.toString());
			
			int i=(int) QGraph.remove();
			if(graph.getColour(i)==false)
			{//System.out.print(i+" ");
			BFSList.add(i);
			ArrayList AL=new ArrayList <Integer>();
			AL=graph.getNeighbour(i);
			graph.setColour(i, true);
			for(Object v:AL)
			{
				//System.out.println(v);
				if(graph.getColour(v)==false)
				{QGraph.add(v);}
			}}
		}while(!QGraph.isEmpty());
		System.out.println(BFSList.toString());
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
		
		//BFS
		BFS_Traversal(graph);
	}

}
