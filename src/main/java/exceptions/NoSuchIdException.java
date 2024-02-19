package exceptions;

/**
 * Класс исключения. Выбрасывается, если объект с указанным id не найден.
 * @author dllnnx
 */
public class NoSuchIdException extends RuntimeException{

    @Override
    public String toString() {
        return "Нет элемента с таким id в коллекции!";
    }
}
