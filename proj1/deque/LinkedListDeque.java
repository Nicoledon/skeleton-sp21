package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque <T>{
    private class Node {
         Node prev;
         Node next;;
         T item;
         public Node(T item, Node prev, Node next) {
             this.item = item;
             this.prev = prev;
             this.next = next;
         }
         public Node(){}

     }
     private Node Sentinelhead;
     private Node Sentineltail;
     private int size;
     public LinkedListDeque() {
         Sentinelhead = new Node();
         Sentineltail = new Node();
         Sentinelhead.next = Sentineltail;
         Sentinelhead.prev = null;
         Sentineltail.next = null;
         Sentineltail.prev = Sentinelhead;
         size = 0;
     }
    @Override
    public void addFirst(T item) {
         size ++ ;
       Node temp = Sentinelhead.next;
       Node node = new Node(item,Sentinelhead,temp);
       Sentinelhead.next = node;
       temp.prev =node;
    }

    @Override
    public void addLast(T item) {
          size ++;
          Node temp = Sentineltail.prev;
          Node node = new Node(item,temp,Sentineltail);
          temp.next = node;
          Sentineltail.prev= node;
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
         Node temp = Sentinelhead.next;
         if(temp !=Sentineltail){
             System.out.print(temp.item +" ");
             temp =temp.next;
         }
    }

    @Override
    public T removeFirst() {
         if(size == 0){
             return null;
         }
         T item = Sentinelhead.next.item;
        Node temp = Sentinelhead.next.next;
         Sentinelhead.next = temp;
         temp.prev = Sentinelhead;
         --size ;
         return item;
    }
   @Override
   public  T removeLast(){
         if(size == 0 ){
             return null ;
         }
         size--;
         T item = Sentineltail.prev.item;
         Node temp = Sentineltail.prev.prev;
         temp.next = Sentineltail;
         Sentineltail.prev = temp;
         return item;
   }
    @Override
    public T get(int index) {
        if(index <0 || index >=size){
            return null;
        }
        Node temp = Sentinelhead.next;
        for(int i =0 ;i <index ;i++){
            temp = temp.next;
        }
        return temp.item;
    }
    public T getRecursive(int index){
         if(index < 0 || index>=size){
             return null;
         }
         return getRecursiveHelper(index,Sentinelhead.next);
    }
    private  T getRecursiveHelper(int index,Node node){
         if(index ==0){
             return node.item;
         }
         return getRecursiveHelper(index-1,node.next);
    }
    public boolean equals(Object o){
         if(!(o instanceof  Deque)){
             return false;
         }
        Deque item = (Deque) o;
        if(item.size() != size()){
            return false;
        }
        for(int i =0 ;i < item.size();i++){
            if(item.get(i)!= ((Deque<?>) o).get(i)){
                return false;
            }
        }
       return true;
    }
}
