package commandManagement;

/**
 * Класс для присваивания цвета тексту в консоли.
 * @author dllnnx
 */
public enum ConsoleColor {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    GREY("\u001B[37m");

    private final String color;

    private ConsoleColor(String color){
        this.color = color;
    }

    /**
     * Присваивает цвет тексту в консоли.
     * @param msg Строка для вывода
     * @param color Присваиваемый цвет
     */
    public static String setConsoleColor(String msg, ConsoleColor color){
        return color + msg + ConsoleColor.RESET;
    }


    @Override
    public String toString() {
        return color;
    }
}
