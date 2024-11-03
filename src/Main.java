public class Main {
    public static void main(String[] args) {
        InMemoryTaskManager taskManager = new InMemoryTaskManager();
        InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();


        // создаем 2 задачи
        Task task = new Task("Изучение Java", "научиться писать программы на языке программирования Java");
        Task taskNew = new Task("Посмотреть телевизор", "Теорию большого взрыва например");
        taskManager.addTask(task);
        taskManager.addTask(taskNew);
        System.out.println(taskManager.getAllTasks());

        // создаем эпик и 2 подзадачи

        Epic epic1 = new Epic("открыть книгу", "не увидеть фигу");
        int epicId = taskManager.addEpic(epic1);
        SubTask subtask1 = new SubTask("перевернуть страничку", "прочитать материал", epicId);
        SubTask subtask2 = new SubTask("перевернуть вторую страничку", "и там прочитать материал", epicId);
        taskManager.addSubTask(subtask1);
        taskManager.addSubTask(subtask2);

        subtask1.setStatus(Status.DONE);
        taskManager.updateSubTask(subtask1);


        System.out.println(taskManager.getAllTasks());
        System.out.println(taskManager.getAllEpics());
        System.out.println(taskManager.getAllSubTasks());

        //добавляем 15 задач, чтобы убедиться, что просмотрены будут только 10 последних
/*
        for ( int i = 1; i<= 15; i++) {
        taskManager.addTask(new Task ("Название задачи", "Описание задачи" + i));
        }

        // Просматриваем некоторые задачи
     taskManager.getTaskByID(6);
        taskManager.getTaskByID(13);
        taskManager.getTaskByID(3);
        taskManager.getTaskByID(5);
        taskManager.getTaskByID(2);
        taskManager.getTaskByID(7);
        taskManager.getTaskByID(6);
        taskManager.getTaskByID(8);
        taskManager.getTaskByID(4);
        taskManager.getTaskByID(10);
        taskManager.getTaskByID(9);
        taskManager.getTaskByID(15);
        taskManager.getTaskByID(11);

        // Отображаем историю просмотров
        System.out.println("История просмотров последних 10 задач:");
        for (Task taskForView : taskManager.getHistory()) {
            System.out.println(taskForView);
        }
*/
        InMemoryHistoryManager tracker = new InMemoryHistoryManager();

        Task epic = new Task("Epic 1", "An epic task");
        Task task1 = new Task("Task 1", "First task");
        Task task2 = new Task("Task 2", "Second task");
        Task subtask3 = new Task("Subtask 1", "First subtask");

        /*taskManager.addSubTask(subtask1);
       taskManager.addSubTask(task2);
        taskManager.addSubTask(subtask1);*/

        taskManager.addTask(epic);
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(subtask3);

        // Viewing tasks
        tracker.viewTask(0); // View epic
        tracker.viewTask(1); // View task 1
        tracker.viewTask(3); // View subtask 1
        tracker.viewTask(1); // View task 1 again
        tracker.viewTask(2); // View task 2

        // Print history
        tracker.printHistory();

        }
    }


