package l;


import java.util.Iterator;


public class ArrayDeque<T> implements Deque<T>{

    private T elem[];

    private int head;

    private int tail;

    private int size;

    public ArrayDeque(){

        elem =  (T[])  new Object[8];

        int head = elem.length-1;

        int tail =0;

        int size =0;

    }

    @Override

    public void addFirst(T item) {

        if(size == elem.length){

            expand();

        }
      if(size == 0){
          tail =0;
          head =0;
          elem[head]=item;
          size++;
      }
         else{
             head =prev(head);
             elem[head] =item;
             size++;
         }
    }

    private int prev(int pos){

        if(pos == 0){

            return elem.length -1;

        }

        else{

            return pos-1;

        }

    }

    private int next(int pos){

        if(pos == elem.length-1){

            return 0;

        }

        else{

            return  pos+1;

        }

    }

    @Override

    public void addLast(T item) {

        if(size == elem.length){

            expand();

        }
     if(size == 0){
         tail =0;
         head =0;
         elem[tail] =item;
         size++;
     }
        else{
            tail =next(tail);
            elem[tail] =item;
            size++;
        }
    }

    @Override

    public boolean isEmpty() {

        return size == 0;

    }


    @Override

    public int size() {

        return size;

    }

    @Override

    public void printDeque() {

    }


    @Override

    public T removeFirst() {

        if (isEmpty()) {

            return null;

        }
            T item =elem[head];
            size--;
            if(head ==0 &&size==0) {
                head =0;
            }
            else{
                head =next(head);
            }
            return item;


    }

    @Override

    public T removeLast() {

        if(isEmpty()){
            return null;

        }
           T item =elem[tail];
     //      elem[tail] =null;
           size --;
           if(tail == 0  && size ==0){
               tail =0;
           }
           else{
               tail = prev(tail);
           }
           return item;
    }

    @Override

    public T get(int index) {

        if(index < 0 || index >= size){

            return  null;

        }

        else{

            return elem[(head+index) % elem.length ];

        }

    }

    private void expand(){

        T [] Nelem =  (T[])  new Object[elem.length *2];

        int end = elem.length-1;

        for(int i =0;i< elem.length ;i++){

            Nelem[i] = elem[head];

            head =next(head);

        }

        elem = Nelem;

        head =0 ;

        tail = end;

    }

    public boolean equals(Object o ){

        return true;

    }

    public Iterator<T> iterator(){

        return null;

    }

}
