import java.util.ArrayList;
import java.util.HashMap;


public class InMemoryTaskManager implements TaskManager {
    protected HashMap<Integer, Task> taskHashMap = new HashMap<>();
    protected HashMap<Integer, SubTask> subTaskHashMap = new HashMap<>();
    protected HashMap<Integer, Epic> epicHashMap = new HashMap<>();
    private int nextID = 1;

   protected InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();

    public ArrayList<Task> getHistory() {
            return inMemoryHistoryManager.getHistory();
    }

    //добавление задачи
    @Override
    public Integer addTask(Task task) {
        task.setID(nextID++);
        taskHashMap.put(task.getID(), task);
        return task.getID();
    }

    // обновление задачи
    @Override
    public void updateTask(Task task) {
        taskHashMap.put(task.id, task);
    }

    // добавление эпика
    @Override
    public Integer addEpic(Epic epic) {
        epic.setID(nextID++);
        epicHashMap.put(epic.getID(), epic);
        return epic.getID();
    }

    // добавление подзадачи
    @Override
    public Integer addSubTask(SubTask subTask) {
        Epic epic = epicHashMap.get(subTask.epicID); // получили эпик по ИД
        if (epic != null) { // если эпик существует
            subTask.setID(nextID);
            subTaskHashMap.put(subTask.getID(), subTask);
            epic.addSubtask(subTask);
            return subTask.getID();
        }
        return null;  // если эпик не найден
    }


    // обновление подзадачи
    @Override
    public void updateSubTask(SubTask subTask) {
        subTaskHashMap.put(subTask.id, subTask);
        Epic epic = epicHashMap.get(subTask.id);
        if (epic != null) {
            epic.updateStatus();
        }
    }

    // обновление эпика
    @Override
    public void updateEpic(Epic epic) {
        epicHashMap.put(epic.id, epic);
    }

    //печать задач
    @Override
    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> taskArrayList = new ArrayList<>(taskHashMap.values());
        return taskArrayList;
    }

    //печать подзадач
    @Override
    public ArrayList<SubTask> getAllSubTasks() {
        ArrayList<SubTask> subTaskArrayList = new ArrayList<>(subTaskHashMap.values());
        return subTaskArrayList;
    }

    // печать эпиков
    @Override
    public ArrayList<Epic> getAllEpics() {
        ArrayList<Epic> epicArrayList = new ArrayList<>(epicHashMap.values());
        return epicArrayList;
    }


    // удаление задач
    @Override
    public void clearTasks() {
        taskHashMap.clear();
    }

    // удаление эпика
    @Override
    public void clearEpics() {
        epicHashMap.clear();
        subTaskHashMap.clear();
    }

    // удаление подзадач
    @Override
    public void clearsubTask() {
        subTaskHashMap.clear();
        for (Epic epic : epicHashMap.values()) {
            ArrayList<SubTask> subTasks = new ArrayList<>();
            epic.clearSubtasks(subTasks);
            epic.updateStatus();

        }
    }

    // получение задачи по идентификатору
    @Override
    public Task getTaskByID(int taskIdToFind) {
        Task getTask = taskHashMap.get(taskIdToFind);
           inMemoryHistoryManager.trackView(getTask);
        return getTask;
    }

    // получение подзадачи по идентификатору
    @Override
    public SubTask getSubTaskByID(int subTaskIdToFind) {
        SubTask getSubtask = subTaskHashMap.get(subTaskIdToFind);
        inMemoryHistoryManager.trackView(getSubtask);
        return getSubtask;
    }

    // получение эпика по идентификатору
    @Override
    public Epic getEpicByID(int epicIdToFind) {
        Epic getEpic = epicHashMap.get(epicIdToFind);
        inMemoryHistoryManager.trackView(getEpic);
        return getEpic;
    }

    // удаление задачи по идентификатору
    @Override
    public Task removeTaskByID(int taskIdToRemove) {
        return taskHashMap.remove(taskIdToRemove);
    }

    // удаление подзадачи по идентификатору
    @Override
    public void removeSubTaskByID(int subTaskIdToFind) {
        SubTask subtask = subTaskHashMap.remove(subTaskIdToFind);
        if (subtask != null) {
            Epic epic = epicHashMap.get(subtask.getEpicID());
            subTaskHashMap.remove(subTaskIdToFind);
            if (epic != null) {
                epic.getSubTasks().remove(subtask);
                epic.updateStatus();
            }
        }
    }

    //удаление эпика по идентификатору
    @Override
    public void removeEpicByID(int epicIdToFind) {
        Epic epic = epicHashMap.remove(epicIdToFind);
        if (epic != null) {
            for (SubTask subTask : epic.getSubTasks()) {
                subTaskHashMap.remove(subTask.getID());
            }
        }
    }

}
