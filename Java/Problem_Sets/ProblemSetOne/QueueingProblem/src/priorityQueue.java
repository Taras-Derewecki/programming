import java.util.ArrayList;
import java.util.HashMap;

public class priorityQueue<E extends Comparable<E> >
{

  
  private ArrayList<E> states;    // an unorganized list of states
  private ArrayList<Pair> heap;      // no duplicates allowed
  private HashMap<E, Integer> hashTable;  // no duplicates allowed

  
  public priorityQueue() {
    states = new ArrayList<E>();
    heap = new ArrayList<Pair>();
    heap.add(new Pair(null, -1));  
    hashTable = new HashMap<E, Integer>();       
  }
  
  public boolean isEmpty() {
    return states.isEmpty();                 
  }
  

  public int size() {
    return states.size();                                
  }
  
  
  public String toString() {
    return heap.toString();                              
  }

  
  public void add(E element) {
    
    Integer index = hashTable.get(element);
    
    if (index == null) {
      states.add(element);
      int setIndex = states.size()-1;
      int heapIndex = 
        insertIntoHeap(element, setIndex);
      hashTable.put(element, heapIndex);             
    } else {
        
      Pair oldPair = heap.get(index);
      E oldElement = oldPair.element;
      
      if (element.compareTo(oldElement) < 0) {
        int oldSetIndex = oldPair.setIndex;
        int heapIndex = updateInHeap(
              new Pair(element, oldSetIndex), 
              index);
        hashTable.put(element, heapIndex);         
      } else {
     } 
    }
  }
 
  
  public E remove() {

    Pair deletee = heap.get(1);
    int setIndex = deletee.setIndex;
    E movedElement = states.get(states.size()-1);
    states.set(setIndex, movedElement);
    states.remove(states.size()-1);
    int heapIndex = hashTable.get(movedElement);
    heap.set(heapIndex, new Pair(movedElement, setIndex));
    
    Pair p = heap.get(heap.size()-1);
    heap.set(1, p);
    hashTable.put(p.element, 1);
    
    heap.remove(heap.size()-1);
    hashTable.remove(deletee.element);

    if (heap.size() > 1) {
      moveDown(p, 1);                            
    }
      
    return deletee.element;
  }
  
  private int updateInHeap(Pair p, int heapIndex) {
    return moveUp(p, heapIndex);                        
  }
  
  
  private int insertIntoHeap(E element, int setIndex) {
    int heapIndex = heap.size();
    Pair pair = new Pair(element, setIndex); 
    heap.add(pair);                 
    return moveUp(pair, heapIndex);                       
  }
  
  private int moveUp(Pair pair, int heapIndex) {
    int tempIndex = heapIndex;
    E element = pair.element;
    boolean done = false;
    while (!done && tempIndex > 1) {
      Pair parentPair = heap.get(tempIndex/2);
      E parentElement = parentPair.element;
      if (element.compareTo(parentElement) >= 0)
        done = true;
      if (!done) {
        heap.set(tempIndex, parentPair); 
        hashTable.put(parentElement, tempIndex);
        tempIndex /= 2;                             
      } 
    } 
    heap.set(tempIndex, pair);
    hashTable.put(element, tempIndex);
    return tempIndex;                                   
  }                
    
  private int moveDown(Pair pair, int heapIndex) {
    int tempIndex = heapIndex;
    E element = pair.element;
    int childIndex = 2*heapIndex;
    boolean done = false;
    while (!done && childIndex < heap.size()) {
      if (childIndex+1 < heap.size() &&
          heap.get(childIndex+1).element.compareTo(
              heap.get(childIndex).element) < 0)
        childIndex++;
      if (heap.get(tempIndex).element.compareTo(
              heap.get(childIndex).element) < 0)
        done = true;
      if (!done) {
        heap.set(tempIndex, heap.get(childIndex)); 
        hashTable.put(heap.get(childIndex).element, 
                        tempIndex);
heap.set(childIndex, pair);
hashTable.put(pair.element, childIndex);
        tempIndex = childIndex;
        childIndex = 2*childIndex;                   
      } 
    } 
      heap.set(tempIndex, pair);
      hashTable.put(element, tempIndex);
      return tempIndex;                                   
  }

  private class Pair {
     public E element;     // the heap element
     public int setIndex;  // the position of the element
                           //   in the set
     
     Pair(E element, int setIndex) {
       this.element = element;
       this.setIndex = setIndex;                   
     }
     
     public String toString() {
       return element + "=" + setIndex;            
     }

  }  // end of Pair class

   public static void main(String[] args) {
     priorityQueue<Integer> pq =   
       new priorityQueue<Integer>();
     pq.add(2);  
     pq.add(3);  
     pq.add(4);  
     pq.add(5);  
     pq.add(6);  
     pq.remove();  
     System.out.println(pq);                                  
   }
}