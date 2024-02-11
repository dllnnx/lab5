package managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import commandManagement.Console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {
    private final Console console;
    private final CollectionManager collectionManager;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public FileManager(Console console, CollectionManager collectionManager) {
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public void saveObjects(){
        String filePath = System.getenv("file_path");
        if (filePath == null || filePath.isEmpty()){
            console.printError("Путь к файлу должен находиться в переменной окружения file_path! :((");
        } else {
            console.println("Путь к файлу получен успешно! :))");
        }
        try{
            FileOutputStream out = new FileOutputStream(filePath);
            out.write(gson.toJson(collectionManager.getCollection()).getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            console.printError("Такого файла не существует(((");
        } catch (IOException e) {
            console.printError("Ой, при сохранении данных в файл произошла ошибка( Проверьте данные!");
        }
    }
}
