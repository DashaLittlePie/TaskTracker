import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {

    private List<Task> tasks;
    private final LinkedList<Task> viewHistory = new LinkedList<>();
    private Map<Integer, DoubleLinkedList> historyMap;
    private DoubleLinkedList head;
    private DoubleLinkedList tail;

    public InMemoryHistoryManager () {
        tasks = new ArrayList<>();
        historyMap = new HashMap<>();
        head = null;
        tail = null;
    }

    public void viewTask (int taskId){
        Task task = tasks.get (taskId);
        //удаляем задачу если она уже есть в истории
        if (historyMap.containsKey(taskId)) {
            DoubleLinkedList existingNode = historyMap.get(taskId);
            if (existingNode.prev != null) {
                existingNode.prev.next = existingNode.next;
            }
            if (existingNode.next != null) {
                existingNode.next.prev = existingNode.prev;
            }
            if (existingNode == head) {
                head = existingNode.next;
            }
            if (existingNode == tail) {
                tail = existingNode.prev;
            }
        }
    //создаем новый узел и добавляем в историю
        DoubleLinkedList newNode = new DoubleLinkedList(task, taskId);
        if (head == null) {
            head =newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        //обновляем историю
        historyMap.put(taskId, newNode);
    }

    public void printHistory () {
        System.out.println ("История просмотров задач:");
        DoubleLinkedList current = head;
        while (current != null) {
            System.out.println (current.task);
            current = current.next;
        }
    }

    @Override
    public void trackView(Task task) {
        if (task == null) {
            return;
        }
        if (viewHistory.size() == 10) {
            viewHistory.removeFirst();
        }
        viewHistory.add(task);
    }

    @Override
    public ArrayList<Task> getHistory() {
        return new ArrayList<>(viewHistory);
    }

    HashMap <Integer, DoubleLinkedList> nodeInList = new HashMap<>();

    @Override
    public void add (Task task){

    }

    public void removeNode (DoubleLinkedList node) {
    nodeInList.remove(node);
    }

    @Override
    public void remove (int id){

    }
}
