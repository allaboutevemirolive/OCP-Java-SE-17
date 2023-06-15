Explain to me generic constructor and it examples

___

In Java, a generic constructor is a constructor that introduces its own type parameters, allowing you to create instances of a class with different types without having to create multiple constructors.

To define a generic constructor, you specify the type parameters before the constructor's parameter list. Here's the general syntax:

```java
public class ClassName<T> {
    public <U> ClassName(U parameter) {
        // Constructor body
    }
}
```

Let's look at an example of a generic constructor:

```java
public class Pair<T> {
    private T first;
    private T second;
    
    public <U> Pair(U first, U second) {
        this.first = (T) first;
        this.second = (T) second;
    }
    
    public T getFirst() {
        return first;
    }
    
    public T getSecond() {
        return second;
    }
}
```

In this example, the `Pair` class has a type parameter `T`, and the constructor introduces another type parameter `U`. The constructor takes two parameters of type `U` and assigns them to the `first` and `second` instance variables, respectively, after casting them to type `T`.

Now, you can create instances of the `Pair` class with different types:

```java
Pair<String> stringPair = new Pair<>("Hello", "World");
System.out.println(stringPair.getFirst());  // Output: Hello
System.out.println(stringPair.getSecond()); // Output: World

Pair<Integer> intPair = new Pair<>(10, 20);
System.out.println(intPair.getFirst());     // Output: 10
System.out.println(intPair.getSecond());    // Output: 20
```

In the above example, we create two instances of the `Pair` class—one with `String` type and another with `Integer` type. The type argument is specified during object creation, allowing us to create pairs of different types using the same generic constructor.

Generic constructors, like generic methods, provide flexibility and reusability by introducing type parameters specific to the constructor's scope. They allow you to create objects with different types while maintaining type safety.