package commandManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * Абстрактный класс для всех команд
 * @author dllnnx
 */
@AllArgsConstructor
public abstract class Command implements CommandInterface {
    @Getter
    private final String name;
    private final String description;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return this.name.equals(command.name) && this.description.equals(command.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return name + description;
    }
}
