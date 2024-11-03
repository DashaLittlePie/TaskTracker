

public class SubTask extends Task {

   protected int epicID;


    public SubTask (String title, String description, int numberOfID) {
        super(title, description);
        this.epicID = numberOfID;

    }

    public int getEpicID () {

        return epicID;
    }

    public void setEpicID (int numberOfID) {

        this.epicID= numberOfID;
    }


    @Override
    public String toString() {
        return "Название подзадачи: " + title + ". Описание подзадачи: " + description + ". ID эпика: " +  epicID + ". Статус "
                + status;
    }

}
