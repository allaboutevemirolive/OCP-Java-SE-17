What is formal type parameter in Java?
___

In Java, a [formal type parameter], also known as a type parameter or a generic parameter, is a placeholder used to represent a type within a generic class, interface, method, or constructor. It allows you to create generic constructs that can work with different types.

When defining a generic construct, you specify formal type parameters within angle brackets (`<>`). These formal type parameters act as variables that represent a type. By using formal type parameters, you can create reusable code that can be customized to work with different types.

Here's an example of a generic class with a formal type parameter:

```java
public class Box<T> {
    private T item;
    
    public void setItem(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
}
```

In this example, `T` is the formal type parameter declared within the angle brackets (`<>`) after the class name. It acts as a placeholder for a specific type that will be provided when creating an instance of the `Box` class. The formal type parameter `T` allows the `Box` class to work with different types in a generic manner.

Here's an example of using the `Box` class with different types:

```java
Box<Integer> intBox = new Box<>();
intBox.setItem(42);
int value = intBox.getItem(); // value will be 42

Box<String> strBox = new Box<>();
strBox.setItem("Hello");
String text = strBox.getItem(); // text will be "Hello"
```

In this code, `Integer` and `String` are the specific type arguments provided for the formal type parameter `T` when creating instances of the `Box` class. The formal type parameter `T` is replaced with the specific types (`Integer` and `String`) to customize the behavior of the `Box` class for those types.

In summary, a formal type parameter in Java is a placeholder used to represent a type within a generic construct. It allows you to create reusable code that can work with different types by providing specific type arguments for the formal type parameters.