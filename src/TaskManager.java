import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public interface TaskManager {


     //добавление задачи
     Integer addTask(Task task);

     // обновление задачи
    void updateTask(Task task);


    // добавление эпика
     Integer addEpic(Epic epic);

    // добавление подзадачи
     Integer addSubTask(SubTask subTask);


    // обновление подзадачи
     void updateSubTask(SubTask subTask);

    // обновление эпика
    void updateEpic(Epic epic);

    //печать задач
     ArrayList<Task> getAllTasks() ;

    //печать подзадач
     ArrayList<SubTask> getAllSubTasks() ;

    // печать эпиков
    ArrayList<Epic> getAllEpics();

    // удаление задач
    void clearTasks();

    // удаление эпика
    void clearEpics();

    // удаление подзадач
    void clearsubTask() ;

    // получение задачи по идентификатору
     Task getTaskByID(int taskIdToFind);

    // получение подзадачи по идентификатору
    SubTask getSubTaskByID(int subTaskIdToFind) ;

    // получение эпика по идентификатору
    Epic getEpicByID(int epicIdToFind) ;

    // удаление задачи по идентификатору
     Task removeTaskByID(int taskIdToRemove);

    // удаление подзадачи по идентификатору
    void removeSubTaskByID(int subTaskIdToFind) ;


    //удаление эпика по идентификатору
    void removeEpicByID(int epicIdToFind) ;

     List<Task> getHistory();

}
