package commandManagement;

/**
 * Интерфейс для исполняемых команд.
 * @author dllnnx
 */
public interface CommandInterface {
    /**
     * Исполняет команду
     * @param args аргументы команды
     */
    void execute(String[] args);
}
