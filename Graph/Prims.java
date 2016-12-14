import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;



public class Prims {

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
		
		@Override
	    public boolean equals(Object e) {
			Edge o=(Edge) e;
			if(this.target==o.target && this.weight==o.weight)
				return true;
			else return false;
	    }
		
	}
	
	public static class AdjacencyList
	{
		int n;
		ArrayList<ArrayList<Edge>> adjLists;
		ArrayList <Boolean> colour;
		ArrayList <Integer> parent;
		
		public AdjacencyList()
		{
			n=0;
			adjLists=new ArrayList<ArrayList<Edge>>();
			colour=new ArrayList<Boolean>();
			parent=new ArrayList<Integer>();
		}
		
		public void addNeighbour(int vertex,Edge n)
		{
			ArrayList<Edge> ed=new ArrayList<Edge>();
			ed=getNeighbour(vertex);
			ed.add(n);
			adjLists.set(vertex,ed);
		}
		
		public void addVertex(int vertex,ArrayList <Edge>AL)
		{
			adjLists.add(AL);
			n++;
			colour.add(false);
			parent.add(-1);
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
	
	
	
	public static void Prims(AdjacencyList graph,int S)
	{
		
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>();
		Node[] n=new Node[graph.n];
		System.out.println();
		for(int i=0;i<n.length;i++)
		{
			n[i]=new Node();
			n[i].node=i;
			n[i].distance=Integer.MAX_VALUE;
		}
		n[S].distance=0;
		minHeap.add(n[S]);
		
		while(minHeap.isEmpty()==false)
		{
			
			Node u=minHeap.remove();
			
			if(graph.getColour(u.node)==false)
			{
				ArrayList<Edge> AL=new ArrayList<Edge>();
				AL=graph.getNeighbour(u.node);
				for(Edge v:AL)
				{
					if(graph.getColour(v.target)==false && n[v.target].distance>(v.weight))
					{
						if(minHeap.contains(n[v.target]))
						minHeap.remove(n[v.target]);
						//System.out.println("old distance:"+n[v.target].distance+" "+"new Distance:"+(n[u.node].distance+v.weight));
						n[v.target].distance=v.weight;
						graph.parent.set(v.target,u.node);
						minHeap.add(n[v.target]);
					}
				}
			}graph.setColour(u.node, true);
		}
		for(int i=0;i<n.length;i++)
			System.out.println(i+":"+n[i].distance+" ");
		System.out.println(graph.parent.toString());
		
	}
	
	public static AdjacencyList convertdirtoundir(AdjacencyList graph)
	{
		for(int i=0;i<graph.n;i++)
		{
			ArrayList<Edge> AL=new ArrayList<Edge>();
			AL=graph.getNeighbour(i);
			for(Edge v:AL)
			{
				Edge e=new Edge(i, v.weight);
				if(graph.getNeighbour(v.target).contains(e)==false)
				{
					
					graph.addNeighbour(v.target, e);
				}
			}
		}
		return graph;
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
		graph=convertdirtoundir(graph);
		//graph.printGraph();
		//Prims Algorithm
		Prims(graph,0);
	}

}

