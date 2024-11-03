import java.util.ArrayList;


public class Epic extends Task {

    ArrayList<SubTask> subTasks = new ArrayList<>();

    public Epic (String title, String description) {

        super(title, description);
    }

    public ArrayList<SubTask> getSubTasks (){

        return subTasks;
    }



    public void addSubtask(SubTask subTask) {
        subTasks.add(subTask);
        updateStatus();
    }

    public void clearSubtasks(ArrayList<SubTask> subTasks) {
        subTasks.clear();
        updateStatus();

    }

    public void updateStatus() {
        if (subTasks.isEmpty()) {
            this.status=Status.NEW;
            return;
        }

        boolean allSubTasksIsDone = true;
        boolean anySubTaskInProgress = false;

        for (SubTask subtask: subTasks) {
            if (subtask.getStatus() == Status.IN_PROGRESS) {
                anySubTaskInProgress = true;
            }
                   }

        if (allSubTasksIsDone) {
            this.status = Status.DONE;
        } else if (anySubTaskInProgress) {
            this.status = Status.IN_PROGRESS;
        } else {
            this.status=Status.NEW;
        }
        }



    @Override
    public String toString() {
        return "Название эпика: " + title + ". Описание эпика: " + description + "ID эпика: " + id +
                 ". Статус "+ status;
    }
}
