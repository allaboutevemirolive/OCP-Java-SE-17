Explain to me about non-generic instance methods in Java with examples
___

In Java, a non-generic instance method is a method defined within a class that does not involve type parameters. 

It operates on specific types and does not provide the flexibility of working with different types without modifying the method implementation.

Non-generic instance methods are the default methods you define in a class without involving generic features. They operate specifically on the class's fields, utilize the class's specific behavior, and are not generic in nature.

Here's an example of a non-generic instance method:

```java
public class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }
}
```

In this example, the `Person` class has a non-generic instance method `sayHello()`. It does not involve type parameters and operates specifically on the `name` field of the `Person` instance. When invoked, the method prints a greeting message along with the name of the person.

Here's how you can use the `Person` class and its non-generic instance method:

```java
Person person1 = new Person("Alice");
person1.sayHello(); // Output: Hello, my name is Alice

Person person2 = new Person("Bob");
person2.sayHello(); // Output: Hello, my name is Bob
```

In the above code, we create instances of the `Person` class and invoke the `sayHello()` method on each instance. The method operates specifically on the `name` field of the instance and does not involve type parameters or generic features.

Non-generic instance methods are commonly used to define behavior that is specific to the instance's type and does not require the flexibility of working with different types. They are straightforward to define and understand, and they allow you to encapsulate specific operations within the class's methods.

Note: Non-generic instance methods are the default kind of methods you define in a class unless you explicitly use type parameters for generic methods or generic constructs.