/*https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists*/


int FindMergeNode(Node headA, Node headB) {
    // Complete this function
    // Do not write the main method. 
    Node p=headA;
    Node q=headB;
    while(p!=null && q!=null)
    {
            if(p==q){return p.data;}
        if(p.next==null){p=headB;q=q.next;}
        else if(q.next==null){q=headA;p=p.next;}
        else{p=p.next;q=q.next;}
    }return 0;
}