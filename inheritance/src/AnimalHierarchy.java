// File: AnimalHierarchy.java


// Superclass
class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass 1
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age); // Call superclass constructor
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }
}

// Subclass 2
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// Subclass 3
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Chirp Chirp!");
    }
}

// Main class to test the hierarchy
public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal myDog = new Dog("Buddy", 5);
        Animal myCat = new Cat("Whiskers", 3);
        Animal myBird = new Bird("Tweety", 1);

        // Polymorphism: Storing subclass objects in a superclass array
        Animal[] pets = {myDog, myCat, myBird};

        for (Animal pet : pets) {
            pet.makeSound(); // Calls the overridden method for each object
        }
    }
}