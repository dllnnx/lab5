import commandManagement.commands.*;
import managers.*;
import commandManagement.Console;

import java.util.List;

public class Main {
    public static void main(String[] args){
        System.setProperty("file_path", "C:\\Users\\alena\\IdeaProjects\\lab5\\data.json");
        Console console = new Console();
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(console,collectionManager);
        ScriptManager scriptManager = new ScriptManager();

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
                new SaveCommand(fileManager, console),
                new ExecuteScriptCommand(console, commandManager, scriptManager)
        ));
        new RuntimeManager(console, commandManager, fileManager).interactiveMode();
    }
}
