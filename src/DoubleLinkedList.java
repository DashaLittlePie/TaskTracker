public class DoubleLinkedList {

        int taskId;
        DoubleLinkedList next;
        DoubleLinkedList prev;
        Task task;

        public DoubleLinkedList (Task task, int taskId) {
            this.taskId = taskId;
            this.task = task;

        }
    }




