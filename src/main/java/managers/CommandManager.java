package managers;

import commandManagement.Command;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Командный менеджер.
 * @author dllnnx
 */
@Getter
public class CommandManager {
    /**
     * Поле для хранения команд в формате Имя: Команда
     */
    private final HashMap<String, Command> commands = new HashMap<>();
    /**
     * Поле для хранения истории команд
     */
    private final ArrayList<String> commandHistory = new ArrayList<>();


    /**
     * Добавляет новые команды в список исполняемых команд.
     * @param commands Команды для добавления
     */
    public void addCommands(Collection<Command> commands){
        this.commands.putAll(commands.stream().collect(Collectors.toMap(Command::getName, s -> s)));
    }

    /**
     * Выполняет команду
     * @param name название команды
     * @param args аргументы команды
     */
    public void execute(String name, String[] args){
        Command command = commands.get(name);
        command.execute(args);
    }

    /**
     * Добавляет команду в историю команд
     * @param command Имя команды
     */
    public void addToHistory(String command){
        commandHistory.add(command);
    }

}
