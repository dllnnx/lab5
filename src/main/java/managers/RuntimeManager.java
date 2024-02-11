package managers;

import commandManagement.Printable;
import exceptions.NoSuchIdException;

import java.util.Arrays;
import java.util.Scanner;

public class RuntimeManager {
    private final Printable console;
    private final CommandManager commandManager;

    public RuntimeManager(Printable console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
    }

    public void interactiveMode(){
        Scanner userScanner = ScannerManager.getUserScanner();
        while (true){
            //if (!userScanner.hasNext()) эксепшн
            String userCommand = userScanner.nextLine().trim() + " ";
            this.launch(userCommand.split(" "));
            commandManager.addToHistory(userCommand.split(" ")[0]);
        }
    }

    public void launch(String[] userCommand){
        if (userCommand[0].isEmpty()) return;
        String[] args = Arrays.copyOfRange(userCommand, 1, userCommand.length);
        commandManager.execute(userCommand[0], args);
    }
}
