package commandManagement;

public class Console implements Printable{

    private static boolean fileMode = false;

    public static boolean isFileMode(){
        return fileMode;
    }

    public static void setFileMode(boolean fileMode){
        Console.fileMode = fileMode;
    }

    @Override
    public void print(String s) {
        System.out.print(s);
    }

    @Override
    public void println(String s){
        System.out.println(s);
    }

    @Override
    public void printError(String s) {
        System.out.println(ConsoleColor.setConsoleColor(s, ConsoleColor.RED));
    }
}
