package managers;

import commandManagement.UserInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScriptManager implements UserInput{

    private static final ArrayDeque<String> pathQueue = new ArrayDeque<>();
    private static final ArrayDeque<Scanner> scanners = new ArrayDeque<>();

    public static void addFile(String path) throws FileNotFoundException {
        pathQueue.add(new File(path).getAbsolutePath());
        scanners.add(new Scanner(new File(path)));
    }

    public static boolean isRecursive(String path){
        return pathQueue.contains(new File(path).getAbsolutePath());
    }

    public static void popFile(){
        scanners.removeLast();
        pathQueue.removeLast();
    }

    @Override
    public String nextLine() {
        try{
            return scanners.getLast().nextLine();
        } catch (NoSuchElementException e){
            return "";
        }
    }
}
