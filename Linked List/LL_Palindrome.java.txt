/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class GfG
{
    Node ReverseLL(Node head)
    {
        if(head.next==null)return head;
        Node p=head.next;
        Node newHead=ReverseLL(head.next);
        p.next=head;
        head.next=null;
        return newHead;
    }
    
    boolean isPalindrome(Node head) 
    {
        //Your code here
        Node mid=head;
        Node n=head;
        while(n!=null && n.next!=null)
        {
            n=n.next.next;
            mid=mid.next;
        }
        
        //Now reversing from Mid
        
        mid=ReverseLL(mid);
        while(mid!=null)
        {
            if(mid.data!=head.data)return false;
            mid=mid.next;
            head=head.next;
        }
        return true;
    }    
}