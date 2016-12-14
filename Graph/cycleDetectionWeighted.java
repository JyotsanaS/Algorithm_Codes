import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class cycleDetectionWeighted {

	public static class Edge{
		int target;
		int weight;
		public Edge(int t,int w)
		{
			target=t;
			weight=w;
		}
		
		public void set(int v,int w){
			target=v;
			weight=w;
		}
		public int getTarget(){
			return target;
		}
		public int getWeight(){
			return weight;
		}
		
	}
	
	public static class AdjacencyList
	{
		int n;
		ArrayList<ArrayList<Edge>> adjLists;
		ArrayList <Boolean> colour;
		ArrayList <Integer> parent;
		ArrayList <Integer> discoveryTime;
		ArrayList <Integer> finishTime;
		
		public AdjacencyList()
		{
			n=0;
			adjLists=new ArrayList<ArrayList<Edge>>();
			colour=new ArrayList<Boolean>();
			parent=new ArrayList<Integer>();
			discoveryTime=new ArrayList<Integer>();
			finishTime=new ArrayList<Integer>();
		}
		
		public void addVertex(int vertex,ArrayList <Edge>AL)
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
		
		public ArrayList<Edge> getNeighbour(int vertex)
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
				System.out.print(i+":");
				for(int j=0;j<getNeighbour(i).size();j++)
					System.out.println(getNeighbour(i).get(j).target+" ("+getNeighbour(i).get(j).weight+"),");
			}
		}
	
	}

	
 static class Node implements Comparable<Node>{
		public int node;
		public int distance;
		
		
		public int compareTo(Node other){
	        return this.distance - other.distance;
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
			for(Object e:AL)
			{
				Edge v=(Edge)e;
				if(graph.getColour(v.target)==false)
				{stackGraph.push(v.target);
				 graph.setParent(v.target, i);
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
			for(Object e:AL)
			{
				Edge v=(Edge)e;
				if(graph.finishTime.get(v.target)>graph.finishTime.get(u))
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
			ArrayList A=new ArrayList<Edge>();
			if(x>0){
			System.out.println("Enter neighbours of vertex and their weight "+i);
			
			for(int j=0;j<x;j++)
			{
				int vertex=sc.nextInt();
				int edge=sc.nextInt();
				Edge e=new Edge(vertex,edge);
				A.add(e);
			}
			
			}
			graph.addVertex(i, A);
		}
		graph.printGraph();
		System.out.println(cycledetect(graph));

	}

}

