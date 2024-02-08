package managers;

import commandManagement.Printable;

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
            this.launch(userCommand.split(" ", 2));
        }
    }

    public void launch(String[] userCommand){
        if (userCommand[0].isEmpty()) return;
        commandManager.execute(userCommand[0], userCommand[1]);
    }
}
