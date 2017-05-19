int CompareLists(Node headA, Node headB) {
    // This is a "method-only" submission. 
    // You only need to complete this method 
    Node p=headA;
    Node q=headB;
    int flag=1;
    while(p!=null && q!=null)
    {
        if (p.data!=q.data)
        {flag=0;break;}
        p=p.next;q=q.next;
    }
    if(!(p==null && q==null))
        flag=0;
    return flag;
}