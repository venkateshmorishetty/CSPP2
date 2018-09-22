import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    todo.tostring();
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
class Task {
    String title;
    String assigned;
    int timelimit;
    String importance;
    String urgent;
    String status;
    public Task(String t, String assign, int limit, boolean important, boolean ur, String s)
    throws Exception {
        status = s;
        title = t;
        assigned = assign;
        timelimit = limit;
        if (important == true) {
            importance = "Important";
        } else {
            importance = "Not Important";
        }
        if(ur == true){
            urgent = "Urgent";
        } else {
            urgent = "Not Urgent";
        }
        if(title.isEmpty()) {
            throw new Exception("Title not provided");
        } else if(limit < 0){
            throw new Exception("Invalid timeToComplete "+limit);
        } else if(!(status.equals("done") || status.equals("todo"))) {
            throw new Exception("Invalid status "+status);
        }
    }
    public String toString(){
        return title+", "+assigned+", "+timelimit+", "+importance+", "+urgent+", "+status;
    }
}

/**
 * Class for todoist.
 */
class Todoist {
    Task[] tasks;
    int size;

    /**.
     * Constructs the object.
     */
    public Todoist() {
        tasks = new Task[100];
        size = 0;
    }

    /**.
     * { function_description }
     *
     * @param      tarray  The tarray
     *
     * @return     { description_of_the_return_value }
     */
    public Task[] resize(Task[] tarray) {
        tasks = Arrays.copyOf(tarray,2*size);
        return tasks;
    }

    /**
     * Adds a task.
     *
     * @param      t     { parameter_description }
     */
    public void addTask (Task t) {
        if(size == tasks.length){
            tasks = resize(tasks);
        }
        tasks[size++] = t;
    }

    /**
     * { function_description }.
     */
    public void tostring() {
        for(int i = 0; i < size; i++) {
            System.out.println(tasks[i].toString());    
        }
    }

    /**
     * Gets the next.
     *
     * @param      name  The name
     * @param      c     { parameter_description }
     *
     * @return     The next.
     */
    public Task[] getNextTask(String name, int c) {
        Task[] tarray = new Task[c];        
        int temp  = 0;
        for(int i = 0;i < size; i++) {
            if(temp!=c){
                if(tasks[i].assigned.equals(name)) {
                    tarray[temp] = tasks[i];
                    temp++;
                } else {
                    continue;
                }   
            } else {
                break;
            }
        }
        if(temp != c){
            for(int i = temp; i< c;i++){
                tarray[i] = null;
            }
        }
        return tarray;
    }

    /**
     * Gets the next task.
     *
     * @param      name  The name
     *
     * @return     The next task.
     */
    public Task getNextTask(String name) {
        Task temp = null;
        int k = 0;
        for(int i = 0; i < size; i++) {
            if(tasks[i].assigned.equals(name) && tasks[i].status.equals("todo")){
                if(tasks[i].importance.equals("Important")){
                    if(tasks[i].urgent.equals("Not Urgent")){
                        temp =  tasks[i];
                        return temp;
                    } else {
                        if(tasks[i].equals("Important")){
                            temp =  tasks[i];
                        }
                    }    
                }
            }
        }
        return temp;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion(){
        int totaltime = 0;
        for(int i = 0; i < size; i++) {
            if(tasks[i].status.equals("todo")) {
                totaltime = totaltime+tasks[i].timelimit;
            } else {
                continue;
            }
        }
        return totaltime;
    }
}