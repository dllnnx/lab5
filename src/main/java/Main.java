import commandManagement.commands.*;
import managers.CollectionManager;
import managers.CommandManager;
import commandManagement.Console;
import managers.RuntimeManager;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Console console = new Console();
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();

        commandManager.addCommands(List.of(
                new Help(console, commandManager),
                new Info(console, collectionManager),
                new Add(console, collectionManager),
                new Show(console, collectionManager),
                new Update(console, collectionManager),
                new RemoveById(console, collectionManager),
                new Clear(console, collectionManager),
                new RemoveFirst(console, collectionManager),
                new FilterByHeight(console, collectionManager),
                new FilterContainsName(console, collectionManager)
        ));
        new RuntimeManager(console, commandManager).interactiveMode();
    }
}
