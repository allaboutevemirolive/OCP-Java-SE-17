Explain to in simple term for the following statement 


Let's break down the statements into simpler terms:

1. If the raw type (a non-parameterized type) used in a bound is a superclass of the type parameter, it can only be specified as the first bound. There can only be one such bound because a subclass can only extend one immediate superclass.

    - This means that if you have a type parameter `T` and you want to specify a bound using a raw type that is a superclass of `T`, you can only do so as the first bound and only once.

2. The raw type used in a bound cannot be used with different type arguments. This is because a type parameter cannot be a subtype of more than one bound that has the same raw type.

    - This means that if you have a type parameter `T` and you specify a bound using a raw type, you cannot use that raw type with different type arguments in multiple bounds for the same type parameter.

In the given class header:

```java
class CmpNode<E extends Comparable<E> & Serializable & Comparable<String>>
```

The error is raised because `E` is attempting to be a subtype of two different parameterizations of the same interface type, which is `Comparable`. This is not allowed because a type parameter cannot be a subtype of more than one bound having the same raw type.

To simplify it further, in this class header, `E` is restricted from being both `Comparable<E>` and `Comparable<String>` at the same time. The restriction arises from the rule that the same raw type (in this case, `Comparable`) cannot be used with different type arguments for the same type parameter.

___
So what is the correct code?


To correct the code, you need to remove one of the `Comparable` bounds since you cannot have two different parameterizations of the same interface type in the bounds for a type parameter. 

If you want to keep the `Comparable<E>` bound, you can remove the `Comparable<String>` bound. Here's the corrected code:

```java
class CmpNode<E extends Comparable<E> & Serializable> {
    // Class implementation
}
```

In this corrected code, the type parameter `E` is bound by `Comparable<E>` and `Serializable`, which means `E` must be a type that implements the `Comparable` interface and is `Serializable`.

You can now use the `CmpNode` class with type arguments that fulfill the bounds, such as:

```java
class MyClass implements Comparable<MyClass>, Serializable {
    // Implementation of Comparable and Serializable for MyClass
}

CmpNode<MyClass> node = new CmpNode<>();
```

In this example, `MyClass` satisfies both bounds (`Comparable<MyClass>` and `Serializable`), so it can be used as the type argument for `CmpNode`.