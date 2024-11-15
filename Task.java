import java.time.LocalDate;

public class Task{
    private String Title;
    private String Description;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String Title,String Description,LocalDate duDate){
        this.Title=Title;
        this.Description=Description;
        this.dueDate=duDate;
        this.completed=false;
    }
    public String getTitle(){
        return Title;
    }
    public void setTitle(String Title){
        this.Title=Title;
    }
    public String getDescription(){
        return Description;
    }
    public void setDescription(String Description){
        this.Description=Description;
    }
    public LocalDate getdueDate(){
        return dueDate;
    }
    public void setdueDate(LocalDate dueDate){
        this.dueDate=dueDate;
    }
    public boolean isCompleted(){
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed=completed;
    }
    @Override
    public String toString(){
        return Title+"("+(completed ? "completed":"not completed")+")"+"\nDescription:"+Description+"\nDue date:"+dueDate;
    }
}

