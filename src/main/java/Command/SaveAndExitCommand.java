package Command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Command executed when user exits the bot.
 *
 * @author Quan Teng Foong
 */
public class SaveAndExitCommand extends Command {

    /**
     * Prints a goodbye message.
     *
     * @param taskList the current list of tasks
     * @param ui the user interface object
     * @param storage the storage object
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.goodbye();
    }

    /**
     * Sends true to exit from the while loop in Duke.run()
     *
     * @return true
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
