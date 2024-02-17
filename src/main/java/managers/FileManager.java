package managers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import commandManagement.Console;
import objects.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.*;

public class FileManager {
    private final Console console;
    private final CollectionManager collectionManager;
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(ZonedDateTime.class, new TypeAdapter<ZonedDateTime>() {
                @Override
                public void write(JsonWriter out, ZonedDateTime value) throws IOException {
                    out.value(value.toString());
                }

                @Override
                public ZonedDateTime read(JsonReader in) throws IOException {
                    return ZonedDateTime.parse(in.nextString());
                }
            })
            .create();

    public FileManager(Console console, CollectionManager collectionManager) {
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public void saveObjects(){
        String filePath = System.getProperty("file_path");
        if (filePath == null || filePath.isEmpty()){
            console.printError("Путь к файлу должен находиться в переменной окружения file_path! :((");
        } else {
            console.println("Путь к файлу получен успешно! :))");
        }
        try{
            FileOutputStream out = new FileOutputStream(filePath);
            out.write(gson.toJson(collectionManager.getCollection()).getBytes());
            out.close();
            console.println("Ура, сохранение данных произошло успешно!!");
        } catch (FileNotFoundException e) {
            console.printError("Такого файла не существует(((");
        } catch (IOException e) {
            console.printError("Ой, при сохранении данных в файл произошла ошибка( Проверьте данные!");
        }
    }

    public void fillCollection(){
        String filePath = System.getProperty("file_path");
        if (filePath == null || filePath.isEmpty()){
            console.printError("Путь к файлу должен находиться в переменной окружения file_path! :((");
        }
        try {
            StringBuilder jsonText = new StringBuilder();
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                jsonText.append(scanner.nextLine());
            }
            Person[] people = gson.fromJson(jsonText.toString(), Person[].class);
            for (Person person: people){
                collectionManager.addElement(person);
            }
        } catch (FileNotFoundException e){
            console.printError("Такого файла не существует(((");
        }
    }
}
