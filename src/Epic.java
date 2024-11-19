import java.util.ArrayList;
import java.util.HashMap;

public class Epic extends Task {


    private HashMap<Integer, SubTask> subTasks = new HashMap<>();

    public Epic(String title, String description) {
        super(title, description);
    }

    public void addTask(SubTask subTask) {
        subTasks.put(subTask.getId(), subTask);
    }

    public void refreshStatus() {


        boolean allNew = true;
        boolean allDone = true;

        for (SubTask subTask : subTasks.values()
        ) {
            if (subTask.getStatus() != TaskStatus.NEW) {
                allNew = false;
            }
            if (subTask.getStatus() != TaskStatus.DONE) {
                allDone = false;
            }

        }
        // ���� � ����� ��� �������� ��� ��� ��� ����� ������ NEW, �� ������ ������ ���� NEW.
        if (subTasks.size() == 0 || allNew) {
            this.setStatus(TaskStatus.NEW);
            return;
        }

        // ���� ��� ��������� ����� ������ DONE, �� � ���� ��������� ����������� � �� �������� DONE.
        if (allDone) {
            this.setStatus(TaskStatus.DONE);
            return;
        }

        // �� ���� ��������� ������� ������ ������ ���� IN_PROGRESS.
        this.setStatus(TaskStatus.IN_PROGRESS);


    }

    public ArrayList<SubTask> getSubTasks() {
        ArrayList<SubTask> allSubTasks = new ArrayList<>(subTasks.values());
        return allSubTasks;
    }

    public void removeSubTask(Integer subTaskId) {
        subTasks.remove(subTaskId);
    }

    @Override
    public String toString() {
        return "Epic{" +

                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", status=" + super.getStatus() + '\'' +
                ", subTasks IDs=" + subTasks.keySet() +
                '}';
    }
}
