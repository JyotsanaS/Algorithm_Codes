/*
https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
*/


boolean hasCycle(Node head) {
if(head==null)return false;
Node n1,n2;
n1=head;
n2=head;
while(n2!=null && n2.next.next!=null)
    {
        n2=n2.next.next;
        if(n1==n2)
            return true;
        n1=n1.next;

    }
    return false;
}