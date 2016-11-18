package BasicJava.lession_5_4;

import java.io.*;
import java.util.Objects;

/**
 * Cериализуемый класс Animal.
 * Created by btow on 18.11.2016.
 */
class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Animal) {
            result = Objects.equals(name, ((Animal) obj).name);
        }
        return result;
    }

    /**
     * Метод из переданного массива байт восстанавливает массив объектов Animal.
     * Массив байт устроен следующим образом: Сначала идет число типа int,
     * записанное при помощи ObjectOutputStream.writeInt(size).
     * Далее подряд записано указанное количество объектов типа Animal,
     * сериализованных при помощи ObjectOutputStream.writeObject(animal).
     * Если вдруг массив байт не является корректным представлением массива
     * экземпляров Animal, то метод должен бросить исключение java.lang.IllegalArgumentException.
     * @param data - byte[];
     * @return Animal[] - Animal.
     */
    public static Animal[] deserializeAnimalArray(byte[] data) {
        // your implementation here
        int instansesNumber;
        Animal[] animals;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))){
            instansesNumber = objectInputStream.readInt();
            if (instansesNumber < 0) {
                throw new IllegalArgumentException();
            }
            animals = new Animal[instansesNumber];
            for (int i = 0; i < instansesNumber; i++) {
                animals[i] = (Animal)objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        return animals;
    }
}