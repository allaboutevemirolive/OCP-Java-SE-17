Explain to me non generic method and it examples

___

In Java, a non-generic method is a *method that does not involve type parameters*. It operates on specific types and does not provide the flexibility of working with different types without modifying the method implementation.

Here's an example of a non-generic method:

```java
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}
```

In this example, the `add` method is a non-generic method. It takes two integer parameters `a` and `b`, performs the addition operation, and returns the result. The method operates specifically on `int` types and does not involve type parameters or generic features.

Non-generic methods are useful in scenarios where you need to perform operations or computations specific to a particular type without the need for generic flexibility. 

They are typically used when the method's behavior is tightly coupled with a specific type and does not need to be reused or adapted to different types.

Here's another example of a non-generic method that operates on a `String`:

```java
public class StringUtils {
    public static String reverse(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
```

In this example, the `reverse` method is a non-generic method that takes a `String` parameter `str` and reverses the characters in the string. The method is specifically designed to operate on `String` types and does not involve type parameters.

Non-generic methods are the default way of writing methods in Java and are used extensively to define operations that are specific to certain types. They are straightforward to understand and implement but lack the flexibility of generic methods when it comes to working with different types.
