package commandManagement;

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

    private String color;

    private ConsoleColor(String color){
        this.color = color;
    }

    public static String setConsoleColor(String msg, ConsoleColor color){
        return color + msg + ConsoleColor.RESET;
    }


    @Override
    public String toString() {
        return color;
    }
}
