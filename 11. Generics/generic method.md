Explain to me generic method and it examples

---

In Java, a generic method is a method that introduces its own type parameters, allowing you to use generic types within the method's scope. 

This provides flexibility and type safety when working with different types without having to create multiple versions of the same method.

To define a generic method, you specify the type parameters before the method's return type. Here's the general syntax:

```java
public <T> returnType methodName(T parameter) {
    // Method body
}
```

Let's look at some examples of generic methods:

1. **Generic Method to Find the Maximum Element in an Array**

```java
public <T extends Comparable<T>> T findMax(T[] array) {
    if (array == null || array.length == 0) {
        return null;
    }
    
    T max = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i].compareTo(max) > 0) {
            max = array[i];
        }
    }
    
    return max;
}
```

In this example, the generic method `findMax` takes an array of type `T`, where `T` is required to implement the `Comparable` interface. It iterates over the elements of the array, compares them using the `compareTo` method, and returns the maximum element.

2. **Generic Method to Swap Two Elements in an Array**

```java
public <T> void swap(T[] array, int i, int j) {
    if (array == null || i < 0 || i >= array.length || j < 0 || j >= array.length) {
        return;
    }
    
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
```

In this example, the generic method `swap` takes an array of type `T` and two indices `i` and `j`. It swaps the elements at indices `i` and `j` in the array.

3. **Generic Method to Print Elements of a List**

```java
public <T> void printList(List<T> list) {
    for (T element : list) {
        System.out.println(element);
    }
}
```

In this example, the generic method `printList` takes a `List` of type `T` and prints each element of the list.

These are just a few examples of generic methods. Generic methods are powerful tools that allow you to write reusable and type-safe code by introducing type parameters specific to the method's scope. They provide flexibility in working with different types and enable you to write generic algorithms and utilities.