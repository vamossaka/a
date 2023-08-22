// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LinkedListDeque<T>  implements Deque<T> {
    private class node{
        private T item;
        private node pre;
        private node next;
        public node(T n,node ppre,node nnext){
            item=n;
            pre=ppre;
            next=nnext;
        }
        public node(node ppre,node nnext){
            pre=ppre;
            next=nnext;
        }
    }
    private node sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel=new node(null,null);
        sentinel.pre=sentinel;
        sentinel.next=sentinel;
        size=0;
    }
    public boolean isEmpty(){
        if(size==0)
        {return true;}

            return  false;
    }
    public void addFirst(T item)
    {
        node first=new node(item,sentinel,sentinel.next);
        sentinel.next.pre=first;
        sentinel.next=first;
        size++;
    }
    public void  addLast(T item)

    {
        node last=new node(item,sentinel.pre,sentinel);
        sentinel.pre.next=last;
        sentinel.pre=last;
        size++;

    }
    public T removeFirst(){
        if(size==0)
        {
            return  null;
        }
        T item=sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.next.pre=sentinel;

        size--;
        return item;


    }public T removeLast(){
        T item=sentinel.pre.item;
        if(size==0)
        {
            return  null;
        }
        sentinel.pre.pre.next=sentinel;
        sentinel.pre=sentinel.pre.pre;

        size--;
        return item;
    }
    public T get(int index){
        if(index>=size)
        {
            return null;
        }
        node tar=sentinel.next;
        for(int i=0;i<index;i++)
        {
            tar=tar.next;
        }
        return  tar.item;
    }
    public int size(){
        return size;
    }

    public void printDeque(){
        node tar=sentinel.next;
        for(int i=1;i<=size;i++)
        {
            System.out.print(tar.item+" ");

            tar=tar.next;
        }
    }
    public T getRecursive(int index){
        int i=0;
        node tar=sentinel;
        if(i==index){
            return tar.item;
        }
        tar=tar.next;
        return getRecursive(i+1);
    }


}

