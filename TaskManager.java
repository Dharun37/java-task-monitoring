import  java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager(){ tasks = new ArrayList<>();}

    public void addTask(String Title,String Description,LocalDate dueDate){
        Task task = new Task(Title,Description,dueDate);
        tasks.add(task);
    }

    public void editTask(int index,String Title,String Description,LocalDate dueDate){
        Task task = tasks.get(index);
        task.setTitle(Title);
        task.setDescription(Description);
        task.setdueDate(dueDate);
    }
    public List<Task> getTasks(){
        return tasks;
    }
    public void viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("No task found");
            return;
        }
        for(int i=0;i<tasks.size();i++){
            System.out.println("Task #"+(i+1));
            System.out.println(tasks.get(i));
            System.out.println();
        }
    }

    public void deleteTask(int index){
        tasks.remove(index);
    }
    public void markTaskAsCompleted(int index){
        Task task = tasks.get(index);
        task.setCompleted(true );
    }
}
