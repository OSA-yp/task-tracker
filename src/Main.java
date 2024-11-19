public class Main {
    public static void main(String[] args) {


        // ������������ TaskManager

        TaskManager tm = new TaskManager();

        // �������� ��� ������, � ����� ���� � ����� ����������� � ���� � ����� ����������.
        Task task1 = new Task("������ ����� 1", "��� ������ �������� ������");
        Task task2 = new Task("������ ����� ���", "��� ������  �������� ������ ��� �����");
        Task task2copy = new Task("������ ����� ���", "��� ������  �������� ������ ��� �����");

        tm.addTask(task1);
        tm.addTask(task2);
        tm.addTask(task2copy);
        Integer task1Id = task1.getId();
        Integer task2Id = task2.getId();


        Epic epic1 = new Epic("��� ������ ����", "���� ���� ����� ��������� ������ ��� ������������");
        SubTask subTask1 = new SubTask("��������� ����� 1", "��� ������ �������� ��������� ��� ������ � ���� 1" );
        SubTask subTask2 = new SubTask("��������� ����� ���", "��� 2�  �������� ��������� ��� ������ � ���� 1 ");

        tm.addTask(epic1);
        tm.addTask(subTask1, epic1);
        tm.addTask(subTask2, epic1);
        Integer subTask1Id = subTask1.getId();
        Integer epic1Id = epic1.getId();

        Epic epic2 = new Epic("��� 2� ����", "���� ���� ����� ��������� 1 ������ ��� ������������");
        SubTask subTask3 = new SubTask("��������� ����� 3", "��� 3� �������� ��������� ��� ������ � ���� 2");

        tm.addTask(epic2);
        tm.addTask(subTask3, epic2);
        Integer subTask3Id = subTask3.getId();
        Integer epic2Id = epic2.getId();

        // ������������ ������ ������, ����� � �������� ����� System.out.println(..).
        printTasks(tm);

        // �������� ������� ��������� ��������, ������������ ��. ���������, ��� ������ ������ � ��������� ����������, � ������ ����� ����������� �� �������� ��������.
        Task oldTask = tm.getTaskById(task1Id);
        Task taskToUpdate1 = new Task(oldTask.getTitle(), oldTask.getDescription());
        taskToUpdate1.setId(tm.getTaskById(task1Id).getId());
        taskToUpdate1.setStatus(TaskStatus.IN_PROGRESS);
        tm.updateTask(taskToUpdate1);

        SubTask oldSubTask1 = (SubTask) tm.getTaskById(subTask1Id);
        SubTask subTaskToUpdate2 = new SubTask(oldSubTask1.getTitle(), oldSubTask1.getDescription());
        subTaskToUpdate2.setId(oldSubTask1.getId());
        subTaskToUpdate2.setParentEpic(oldSubTask1.getParentEpic());
        subTaskToUpdate2.setStatus(TaskStatus.DONE);
        tm.updateTask(subTaskToUpdate2);

        SubTask oldSubTask2 = (SubTask) tm.getTaskById(subTask3Id);
        SubTask subTaskToUpdate3 = new SubTask(oldSubTask2.getTitle(), oldSubTask2.getDescription());
        subTaskToUpdate3.setId(oldSubTask2.getId());
        subTaskToUpdate3.setParentEpic(oldSubTask2.getParentEpic());
        subTaskToUpdate3.setStatus(TaskStatus.DONE);
        tm.updateTask(subTaskToUpdate3);

        printTasks(tm);


        // �, �������, ���������� ������� ���� �� ����� � ���� �� ������.
        System.out.println("�������� ��������� � id="+ subTask3Id + " �������:" + tm.removeTaskById(subTask3Id));
        System.out.println("�������� ������ � id="+ task2Id + " �������:" + tm.removeTaskById(task2Id));
        System.out.println("�������� ���� � id="+ epic1Id + " �������:" + tm.removeTaskById(epic1Id));


        printTasks(tm);


        // �������� ��������� �����
        System.out.println("��������� ����� " + epic1.getTitle() + " � id=" + epic1.getId() +  ":");
        for (SubTask subTask : tm.getTasks(epic1)
        ) {
            System.out.println(subTask);
        }

        System.out.println("�������� ���� � id="+ epic2Id + " �������:" + tm.removeTaskById(epic2Id));

        // ������� ��� ������
        System.out.println("�������� ���� �����");
        tm.removeAllTasks();

        printTasks(tm);

    }

    private static void printTasks(TaskManager tm) {
        for (Task task : tm.getTasks()
        ) {
            System.out.println(task);
        }
        System.out.println("_".repeat(60));
    }
}