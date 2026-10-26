public class Task{

    private String description;
    private int priority;
    private int minutes;

    public Task(String description, int priority, int minutes){
        this.description = description;
        this.priority = priority;
        this.minutes = minutes;
    }

    public String getDescription(){
        return description;
    }

    public int getPriority(){
        return priority;
    }

    public int getMinutes(){
        return minutes;
    }
    
    @Override
    public String toString(){
        String priorityText;
        if(priority == 1){
            priorityText = "very important";
        }
        else if(priority == 2){
            priorityText = "important";
        }
        else if(priority == 3){
            priorityText = "unimportant";
        }
        else{
            priorityText = "after learn Portuguese";
        }
        return description + " takes " + minutes + " minutes and has priority " + priorityText;
    }

    


}