What is Serializable in Java with example
___

In Java, `Serializable` is an interface that serves as a marker interface to indicate that a class can be serialized, 
- meaning its objects can be converted into a byte stream for storage or transmission and later `deserialized` back into objects. 

Serializable is part of the Java Serialization API and provides a way to achieve object persistence.

To make a class serializable, you need to implement the `Serializable` interface. It does not have any methods or fields and acts as a simple marker for the Java runtime to determine whether an object of a particular class can be serialized.

Here's an example that demonstrates the usage of `Serializable`:

```java
import java.io.*;

public class Person implements Serializable {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Getters and setters
    
    public static void main(String[] args) {
        Person person = new Person("Alice", 25);
        
        // Serialization
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(person);
            System.out.println("Person object serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialization
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Person deserializedPerson = (Person) objectIn.readObject();
            System.out.println("Deserialized Person object: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
```

In this example, the `Person` class implements the `Serializable` interface. It has two private fields, `name` and `age`, along with a constructor, getters, setters, and an overridden `toString()` method.

In the `main()` method, we create an instance of the `Person` class and perform serialization and deserialization. During serialization, the `Person` object is written to a file called "person.ser". The `ObjectOutputStream` is used to write the object. During deserialization, the `Person` object is read back from the file using the `ObjectInputStream`.

Note that for serialization to work correctly, all fields of the class must be serializable or marked as `transient` if they should be excluded from serialization.

The `Serializable` interface provides a convenient way to make objects serializable in Java. It allows objects to be easily stored, transmitted, or shared between different Java applications or platforms.