What is multiple bound in Java and its example?

___

In Java, multiple bounds refer to the `ability to specify multiple type bounds for a type parameter`. 

This allows you to impose restrictions on the types that can be used as type arguments.

To specify multiple bounds for a type parameter, you can use the following syntax:

```java
<T extends Type1 & Type2 & Type3>
```

Here, `T` is the type parameter, and `Type1`, `Type2`, and `Type3` are the types that `T` must be a subtype of.

Let's take an example to illustrate multiple bounds. Suppose you want to create a method that accepts a parameter of a type that implements both the `Comparable` interface and the `Serializable` interface. You can use multiple bounds to achieve this:

```java
public <T extends Comparable<T> & Serializable> void process(T obj) {
    // Process the object
}
```

In this example, the type parameter `T` is bounded by `Comparable<T>` and `Serializable`. This means that `T` must be both a subtype of `Comparable<T>` and implement the `Serializable` interface. By using multiple bounds, you ensure that the type argument passed to the `process` method satisfies these constraints.

Here's how you can use the `process` method with different types:

```java
Integer num = 10;
process(num); // Valid: Integer implements Comparable<Integer> and Serializable

String str = "Hello";
process(str); // Invalid: String does not implement Serializable

class MyClass implements Comparable<MyClass>, Serializable {
    // Implementation of Comparable and Serializable
}

MyClass obj = new MyClass();
process(obj); // Valid: MyClass satisfies both bounds
```

In the above example, `Integer` is a valid argument for the `process` method because it implements `Comparable<Integer>` and `Serializable`. However, `String` is not a valid argument because it does not implement `Serializable`. Finally, `MyClass` is a valid argument as it satisfies both bounds by implementing `Comparable<MyClass>` and `Serializable`.

Multiple bounds allow you to express more specific constraints on type parameters, enabling you to create more flexible and reusable code. They are particularly useful when you need to work with types that must fulfill multiple interface or class requirements.