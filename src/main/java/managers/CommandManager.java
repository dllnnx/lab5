package managers;

import commandManagement.Command;
import exceptions.NoSuchIdException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CommandManager {
    /**
     * Коллекция для хранения команд в виде имя-команда
     */
    private final HashMap<String, Command> commands = new HashMap<>();
    private final ArrayList<String> commandHistory = new ArrayList<>();

    public void addCommand(Command command){
        this.commands.put(command.getName(), command);
    }

    public void addCommands(Collection<Command> commands){
        this.commands.putAll(commands.stream().collect(Collectors.toMap(Command::getName, s -> s)));
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void execute(String name, String[] args){
        Command command = commands.get(name);
        // if (command == null) выбросить ошибку
        command.execute(args);
    }

    public void addToHistory(String command){
        commandHistory.add(command);
    }

    public ArrayList<String> getCommandHistory() {
        return commandHistory;
    }
}
