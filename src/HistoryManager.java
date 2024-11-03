import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface HistoryManager {

     void trackView(Task task);

    ArrayList<Task> getHistory() ;

    void add(Task task);

    void remove(int id);

}
