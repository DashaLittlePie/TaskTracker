import org.junit.Test;

import static org.junit.Assert.*;

public class TaskManagerTest {
    @Test
    public void testTaskEqualityById() {
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");
        assertNotEquals("Экземпляры класса Task равны друг другу, если равен их id", task1, task2);
    }

    @Test
    public void testSubtaskEqualityById() {
        SubTask subtask1 = new SubTask("Subtask 1", "Description 1", 1);
        SubTask subtask2 = new SubTask("Subtask 2", "Description 2", 1);
        assertNotEquals("Экземпляры класса Task равны друг другу, если равен их id", subtask1, subtask2);
    }


    @Test
    public void testEpicCannotBeAddSubtask() {
        InMemoryTaskManager taskManager = new InMemoryTaskManager();
        Epic epic = new Epic("Test Epic", "Test of Epic");
        taskManager.addEpic(epic);
        SubTask subtask = new SubTask("Test Subtask", "Test of Subtask", epic.getID());
        taskManager.addSubTask(subtask);
        assertEquals(1, taskManager.getAllSubTasks().size());
        assertEquals(1, epic.getSubTasks().size());
    }

    @Test
    public void testInMemoryTaskManager() {
        InMemoryTaskManager taskManager = new InMemoryTaskManager();
        Task task = new Task("Task 1", "Description 1");
        taskManager.addTask(task);
        assertNotNull(String.valueOf(taskManager.getTaskByID(task.getID())), "Задачи должны быть доступны по ID");
    }

    @Test
    public void testAddingTaskPreservesImmutability() {
        InMemoryTaskManager taskManager = new InMemoryTaskManager();
        Task task = new Task("Task 1", "Description 1");
        taskManager.addTask(task);

        Task newTask = new Task("Task 1", "Description 1");
        taskManager.addTask(newTask);
        assertNotEquals("Задачи не должны меняться после добавления одного задания", task, newTask);
    }

    @Test
    public void testHistoryManagerPreservesPreviousVersions() {
        InMemoryHistoryManager historyManager = new InMemoryHistoryManager();
        Task task = new Task("Task 1", "Description 1");
        historyManager.trackView(task);

        assertEquals("Размер истории не должен поменяться после добавления одного задания", (1), historyManager.getHistory().size());
    }
}



