package commandManagement;

import lombok.Getter;
import lombok.Setter;

public class Console implements Printable{

    @Getter
    @Setter
    private static boolean fileMode = false;


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
