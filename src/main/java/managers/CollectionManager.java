package managers;

import exceptions.NoSuchIdException;
import lombok.Getter;
import objects.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Менеджер коллекции.
 * @author dllnnx
 */
@Getter
public class CollectionManager {
    /**
     * Хранимая коллекция
     */
    private static final List<Person> collection = new LinkedList<>();
    /**
     * Дата инициализации коллекции
     */
    private final Date initializationTime = new Date();

    /**
     * Возвращает коллекцию
     * @return Коллекция
     */
    public List<Person> getCollection() {
        return collection;
    }

    /**
     * Возвращает имя типа коллекции
     * @return Имя типа коллекции
     */
    public String getCollectionType(){
        return collection.getClass().getName();
    }

    /**
     * Возвращает размер коллекции
     * @return Размер коллекции
     */
    public int getCollectionSize(){
        return collection.size();
    }


    /**
     * Находит минимально возможный свободный id
     * @return минимально возможный свободный id
     */
    public static long getFreeId(){
        if (collection.isEmpty()) return 0;
        List<Long> ids = collection.stream()
                .map(Person::getId)
                .collect(Collectors.toList());
        for (long i = 0; i < Collections.max(ids); i++){
            if (!ids.contains(i)) return i;
        }
        return Collections.max(ids) + 1;
    }

    /**
     * Добавляет элемент в коллекцию
     * @param person Элемент для добавления.
     */
    public void addElement(Person person){
        collection.add(person);
    }


    /**
     * Получает элемент коллекции по заданному значению id
     * @param id id элемента
     * @return Элемент по заданному значению id или null, если не найдено
     */
    public Person getById(long id){
        return collection.stream()
                .filter(x -> x.getId() == id)
                .findAny()
                .orElse(null);
    }

    /**
     * Удаляет элемент коллекции по заданному значению id
     * @param id id элемента
     */
    public void removeById(long id){
        if (getById(id) != null){
            collection.remove(getById(id));
        } else {
            throw new NoSuchIdException();
        }
    }

    /**
     * Очищает коллекцию
     */
    public void clearCollection(){
        collection.clear();
    }

    /**
     * Удаляет первый элемент коллекции
     */
    public void removeFirst(){
        Person firstPerson = (Person) collection.toArray()[0];
        collection.remove(firstPerson);
    }

    /**
     * Находит элементы коллекции по заданному значению поля height
     * @param height height элементов
     * @return List из найденных элементов
     */
    public List<Person> getByHeight(int height){
        return collection.stream()
                .filter(x -> x.getHeight() == height)
                .collect(Collectors.toList());
    }

    /**
     * Нахоодит элементы коллекции, значение поля name которых содержит заданную подстроку
     * @param name Заданная подстрока
     * @return List из найденных элементов
     */
    public List<Person> filterContainsName(String name){
        return collection.stream()
                .filter(x -> x.getName().contains(name))
                .collect(Collectors.toList());
    }

    /**
     * Находит любой элемент коллекции, значение поля nationality которого является максимальным
     * @return любой элемент коллекции, значение поля nationality которого является максимальным
     */
    public Person maxByNationality(){
        return collection.stream()
                .max(Comparator.comparing(x -> x.getNationality().getThousandsOfArea()))
                .orElse(null);
    }

    /**
     * Перемешивает коллекцию.
     */
    public void shuffle(){
        Collections.shuffle(collection);
    }

}
