What is type witness in Java and it example
___

In Java, a type witness is a way to explicitly specify the type argument(s) when invoking a generic method or constructor. It helps the compiler infer the appropriate type(s) and ensure type safety when dealing with generic code.

When invoking a generic method or constructor, the compiler typically performs type inference based on the provided arguments. However, in some cases, the type inference may not be able to determine the correct type argument(s) automatically. In such situations, a type witness can be used to explicitly specify the type(s).

Here's an example to illustrate the use of a type witness:

```java
import java.util.*;

public class TypeWitnessExample {
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
    
    public static void main(String[] args) {
        List<?> unknownList = new ArrayList<>();
        printList(unknownList); // Compilation error
        
        TypeWitnessExample.<String>printList(unknownList); // Using type witness
        
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        
        printList(stringList); // No type witness needed
    }
}
```

In this example, we have a generic method `printList()` that takes a `List<T>` as a parameter and prints its elements. In the `main()` method, we attempt to invoke the `printList()` method with an unknown list (`unknownList`) and a string list (`stringList`).

The first invocation `printList(unknownList)` without a type witness results in a compilation error because the compiler cannot determine the appropriate type argument for `unknownList`. To resolve this, we can use a type witness by explicitly specifying the type argument `<String>` as `TypeWitnessExample.<String>printList(unknownList)`.

On the other hand, when invoking `printList(stringList)`, the compiler can infer the type argument (`String`) based on the actual argument (`stringList`), so a type witness is not necessary in this case.

The use of a type witness provides a way to explicitly specify the type argument(s) when the compiler cannot infer them automatically. It ensures type safety and helps in resolving compilation errors related to type inference in generic code.