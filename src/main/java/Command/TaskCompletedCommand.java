package Command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Command to mark a task as complete.
 *
 * @author Quan Teng Foong
 */
public class TaskCompletedCommand extends Command {

    public TaskCompletedCommand(String taskIndex) {
        super(taskIndex);
    }

    /**
     * Marks a task as complete.
     *
     * @param taskList the current list of tasks
     * @param ui the user interface object
     * @param storage the storage object
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.doTask(Integer.parseInt(super.getExtraInput()) - 1);
        ui.showList(taskList);
    }
}
