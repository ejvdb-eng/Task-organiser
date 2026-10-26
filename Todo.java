import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Todo {

    private List<Task> Todo;

    public Todo(){
        this.Todo = new ArrayList<>();
    }
    
    public void addTask(String description, int priority, int minutes){
        if(priority < 1 || priority > 4){
            System.out.println(description + " has invalid priority");
            }
        else if(minutes < 0){
            System.out.println(description + " has invalid workload");
            }
        else{
            Todo.add(new Task(description, priority, minutes));
            }
        }
    
    public void print(){
        System.out.println("Todo:\n-----");
        if(Todo.isEmpty()){
            System.out.println("You're all done for today! #TodoZero");
        }
        else{
            for(Task todo : Todo){
                System.out.println(todo);
            }
        }
        if(totalworkcompleted > 0){
            System.out.println(totalworkcompleted + " minutes of work done!");
        }
    }

    int totalworkcompleted = 0;
    public void completeTask(int index){
        if(index < 0 || index >= Todo.size()){
            System.out.println("Invalid index");
        }
        else{
            Task t = Todo.get(index);
            totalworkcompleted += t.getMinutes();
            Todo.remove(index);
        }
    }

    public void printPriority(int limit){
        if(limit < 1 || limit > 4){
            System.out.println("invalid limit");
        }
        else{
        System.out.println("Filtered todo:\n--------------");
        boolean thereAreTasks = Todo.stream()
            .anyMatch(task -> task.getPriority() <= limit);

            if(thereAreTasks){
            Todo.stream()
                .filter(task -> task.getPriority() <= limit)
                .forEach(task -> System.out.println(task));
            }
            else{
                System.out.println("No tasks with given priority");
            }   
        }
    }

    public void printPrioritized(){
        System.out.println("Prioritized todo:\n-----------------");
        Todo.stream()
            .sorted(Comparator.comparing((Task task) -> task.getPriority())
            .thenComparing(task -> task.getMinutes()))
            .forEach(task -> System.out.println(task));
    }
}


