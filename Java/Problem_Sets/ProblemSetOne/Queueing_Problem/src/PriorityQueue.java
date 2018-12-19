import java.util.ArrayList;
public class PriorityQueue
{
    private class Data
    {
        String data;
        int priority;

        private Data(String str, int p)
        {
            data = str;
            priority = p;
        }
    }

    ArrayList<Data> queue; // ArrayList simulating a queue

    private PriorityQueue()
    {
        queue = new ArrayList<Data>();
    }

    //Adds an item to the queue corresponding to the priority
    private void enqueue(String data, int p)
    {
        // Find a position based on the priority level to the new item to be enqueued
        int i;

        for(i = 0; i < queue.size(); i++)
            if(p < queue.get(i).priority)
                break;

        queue.add(i, new Data(data, p));
    }

    // dequeue highest priority level item
    private String dequeue()
    {
        String removedItem = queue.get(queue.size() - 1).data;
        queue.remove(queue.size()-1);
        System.out.println("Dequeued " + removedItem);
        return removedItem;
    }

    public static void main(String args[])
    {
        PriorityQueue q = new PriorityQueue();

        q.enqueue("X", 10);
        q.enqueue("Y", 1);
        q.enqueue("Z", 3);

        q.dequeue(); // Dequeued X
        q.dequeue(); // Dequeued Z
        q.dequeue(); // Dequeued Y
    }
}