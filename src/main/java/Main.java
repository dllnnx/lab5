import commandManagement.commands.*;
import managers.CollectionManager;
import managers.CommandManager;
import commandManagement.Console;
import managers.FileManager;
import managers.RuntimeManager;

import java.util.List;

public class Main {
    public static void main(String[] args){
        Console console = new Console();
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(console,collectionManager);

        commandManager.addCommands(List.of(
                new HelpCommand(console, commandManager),
                new InfoCommand(console, collectionManager),
                new AddCommand(console, collectionManager),
                new ShowCommand(console, collectionManager),
                new UpdateCommand(console, collectionManager),
                new RemoveByIdCommand(console, collectionManager),
                new ClearCommand(console, collectionManager),
                new RemoveFirstCommand(console, collectionManager),
                new FilterByHeightCommand(console, collectionManager),
                new FilterContainsNameCommand(console, collectionManager),
                new ExitCommand(console),
                new MaxByNationalityCommand(console, collectionManager),
                new ShuffleCommand(console, collectionManager),
                new HistoryCommand(console, commandManager),
                new SaveCommand(fileManager)
        ));
        new RuntimeManager(console, commandManager).interactiveMode();
    }
}
