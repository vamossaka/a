public class ArrayDeque<T> {
    public T[] array;
    public int size;
    public int length;
    public int front;
    public int last;
    public ArrayDeque(){
        array=(T[])new Object[8];
        size=0;
        length=8;
        front=4;
        last=4;}
    public boolean isEmpty(){
        if(size==0)
        {
            return true;
        }
        else
            return false;
    }
    public int size(){
        return size;
    }
    private int minusone(int index){
        if(index==0)
        {
            return length-1;
        }
        return index-1;
    }
    private int plusone(int index,int module)
    {
        index%=module;
        if(index==module-1)
        {
            return 0;
        }
        return index+1;
    }

    public void grow(){
        T[] newarray=(T[])new Object[length*2];
        int ptr1=front;
        int ptr2=last;
        while(ptr1!=last){
            newarray[ptr2]=array[ptr1];
            ptr1=plusone(ptr1,length);
            ptr2=plusone(ptr2,length);
        }
        length*=2;
        front=ptr1;
        last=ptr2;
        array=newarray;


    }
    public void shrink(){
        T[]newarray=(T[])new Object[length/2];
        int ptr1=front;
        int ptr2=length/4;
        while(ptr1!=last){
            newarray[ptr2]=array[ptr1];
            ptr1=plusone(ptr1,length);
            ptr2=plusone(ptr2,length);
        }
        front=length/4;
        last=ptr2;
        length/=2;
        array=newarray;
    }
    public void addFirst(T item){
        if(size==length-1)
        {
            grow();
        }

        array[front]=item;
        front=minusone(front);
        size++;
    }
    public void addLast(T item){
        if(size==length-1){
            grow();
        }
        array[last]=item;
        last=plusone(last,length);
        size++;
    }
    public T removeFirst(){
        if(length>=16&&length/size>=4){
            shrink();}
        if(size==0){
            return null;
        }
        T ret=array[last];
        last=minusone(last);
        size--;
        return ret;
    }
    public T get(int index){
        if (index>=size){
            return null;

        }
        return array[index];
    }
    public void printDeque(){
        int ptr1=front;
        while (ptr1!=last){
            System.out.print(array[ptr1]+" ");
            ptr1=plusone(ptr1,length);
        }
    }
}

