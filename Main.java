import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Main {
    public static void main (String[] args){
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Task Management");
            System.out.println("1. Add a task");
            System.out.println("2. Edit a task");
            System.out.println("3. View all tasks");
            System.out.println("4. Delete a task");
            System.out.println("5. Mark a task as completed");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                System.out.println("Existing...");
                return;
                case 1:
                System.out.print("Enter the task title: ");
                String Title = scanner.nextLine();

                System.out.print("Enter the task description: ");
                String Description = scanner.nextLine();

                LocalDate dueDate=null;
                while (dueDate == null) {
                    System.out.print("Enter the task due date(yyyy-mm-dd): ");
                    String dueDateString =scanner.nextLine();

                    try{
                        dueDate = LocalDate.parse(dueDateString);
                    }
                    catch(DateTimeParseException e){
                        System.out.println("Invalid date formate");
                    }
                    
                }
                taskManager.addTask(Title, Description, dueDate);
                System.out.println("Task added successfully");
                break;

                case 2:
                System.out.print("Enter the task number to edit");
                int editIndex = scanner.nextInt();
                scanner.nextLine();

                if(editIndex <= 0 || editIndex > taskManager.getTasks().size()){
                    System.out.println("invalid task number");
                    break;
                }
                System.out.print("Enter the new task title");
                String newTitle = scanner.nextLine();   

                System.out.print("Enter the new task description: " );
                String newDescription = scanner.nextLine();
                LocalDate newDueDate = null;
                while(newDueDate == null){
                    System.out.print("Enter new task due date(yyyy-mm-dd): ");
                    String newDueDateString = scanner.nextLine();
                    
                    try{
                        newDueDate = LocalDate.parse(newDueDateString);

                    }
                    catch(DateTimeParseException e){
                        System.out.println("Invalid date formate");

                    }
                }
                taskManager.editTask(editIndex-1, newTitle, newDescription, newDueDate);
                System.out.println("task edited successfully"); 
                break;


                case 3:
                taskManager.viewTasks();
                break;


                case 4:
                System.out.print("Enter the task no to delete: ");
                int deleteIndex = scanner.nextInt();
                scanner.nextLine();

                if(deleteIndex <=0 || deleteIndex > taskManager.getTasks().size()){
                    System.out.println("Invalid task number");
                    break;
                }

                taskManager.deleteTask(deleteIndex-1);
                System.out.println("Task deleted successfully");
                break;

                case 5:
                System.out.print("Eneter the task number to mark as completed: ");
                int completeIndex = scanner.nextInt();
                scanner.nextLine();

                if(completeIndex <= 0 || completeIndex > taskManager.getTasks().size()){
                    System.out.println("Invalid  task number");
                    break;
                }
                taskManager.markTaskAsCompleted(completeIndex-1);
                System.out.println("task marked as completed");
                break;
                
                default:
                System.out.println("Invalid choice");
                break;
            }
            System.out.println();
        }

    }
    
}
