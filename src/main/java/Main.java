import commandManagement.commands.Add;
import commandManagement.commands.Show;
import managers.CollectionManager;
import managers.CommandManager;
import commandManagement.Console;
import commandManagement.commands.Help;
import managers.RuntimeManager;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Console console = new Console();
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();

        commandManager.addCommands(List.of(
                new Help(console, commandManager),
                new Add(console, collectionManager),
                new Show(console, collectionManager)
        ));
        new RuntimeManager(console, commandManager).interactiveMode();
    }
}