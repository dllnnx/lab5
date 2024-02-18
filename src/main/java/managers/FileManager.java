package managers;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import commandManagement.Console;
import lombok.RequiredArgsConstructor;
import objects.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

@RequiredArgsConstructor
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
            console.printError("Путь к исходному файлу должен находиться в переменной окружения file_path! :((");
        }
        try {
            StringBuilder jsonText = new StringBuilder();
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                jsonText.append(scanner.nextLine());
            }
            Person[] people = gson.fromJson(jsonText.toString(), Person[].class);
            Validator validator = new Validator();
            for (Person person: people){
                if (validator.validatePerson(person)) {
                    collectionManager.addElement(person);
                }
                else {
                    console.printError("Данные в файле невалидны! Коллекция не заполнена :((");
                }
            }
        } catch (FileNotFoundException e){
            console.printError("Такого файла не существует(((");
        } catch (IllegalArgumentException e){
            console.printError("Данные в файле невалидны! Коллекция не заполнена :((");
        }
    }
}
