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

    public void interactiveMode() throws Exception {
        Scanner userScanner = ScannerManager.getUserScanner();
        while (true){
            if (!userScanner.hasNext()) throw new Exception(); // здесь будет эксепшн
            String userCommand = userScanner.nextLine().trim() + " ";
            this.launch(userCommand.split(" "));
        }
    }

    public void launch(String[] userCommand) throws NoSuchIdException {
        if (userCommand[0].isEmpty()) return;
        String[] args = Arrays.copyOfRange(userCommand, 1, userCommand.length);
        commandManager.execute(userCommand[0], args);
    }
}
