public class Task {

    protected String title;
    protected String description;
    protected Status status;
    protected int id;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription (){
        return description;
    }

    public void setDescription (String description) {
    this.description = description;
    }

    public Status getStatus () {
        return status;
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    //переопределить toString
    @Override
    public String toString() {
        return "Название задачи: " + title + ". Описание задачи: " + description + ". ID задачи: " + id + ". Статус "
                + status;
    }

}
