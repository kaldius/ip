import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Duke {
    private static TaskList taskList = new TaskList();;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage("./storage/save.txt");
        try {
            File saveFile = storage.retrieve();
            taskList = new TaskList(saveFile);
        } catch (IOException e) {
            System.out.println("ERROR! There was an issue retrieving the file. Creating" +
                    "new save file instead.");
        } catch (NoSuchCommandException e) {
            System.out.println("ERROR! Some commands in save.txt could not be recognised," +
                    "creating new save file.");
        } catch (NoTaskNameException e) {
            System.out.println("ERROR! Some tasks in save.txt had no name. Creating new" +
                    "save file.");
        }
        String command;
        String input;
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "What can I do for you?\n");

        while(true) {
            System.out.print("You: ");
            command = sc.next();
            input = sc.nextLine().trim();
            System.out.print("Duke: ");
            switch (command) {
            case "bye":
                try {
                    storage.save(taskList);
                } catch (IOException e) {
                    System.out.println("ERROR! TaskList could not be saved.");
                }
                System.out.println("Nice talking to you, goodbye!");
                return;
            case "list":
                try {
                    System.out.println("Checking your todo list...");
                    taskList.printList();
                    System.out.println();
                } catch (EmptyTaskListException e) {
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            case "done":
                taskList.doTask(Integer.parseInt(input) - 1);
                try {
                    taskList.printList();
                } catch (EmptyTaskListException e) {
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            case "delete":
                taskList.delete(Integer.parseInt(input) - 1);
                break;
            default:
                try {
                    taskList.add(Task.createTask(command, input));
                } catch (NoSuchCommandException e) {
                    System.out.println("ERROR! Command not recognised.");
                } catch (NoTaskNameException e) {
                    System.out.println("ERROR! No task name.");
                }
            }
        }
    }
}
