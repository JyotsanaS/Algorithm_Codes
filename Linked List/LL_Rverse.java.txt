/*Reversing a link list using recursive and iterative way*/

Node Reverse(Node head) {
    Node prev,cur,nex;
    cur=head;
    prev=null;
    while(cur!=null)
    {
        nex=cur.next;
        cur.next=prev; 
        prev=cur;
        cur=nex;
    }
    return prev; 
}


Node Reverse(Node head) {
    
       if(head.next!=null)
       {
            Node n=head.next;
            Node c=head;
            head=Reverse(n);
            n.next=c;
            c.next=null;}
       return head;
}