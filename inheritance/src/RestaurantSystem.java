// File: RestaurantSystem.java


// Interface defines a contract
interface Worker {
    void performDuties();
}

// Superclass
class Persons {
    String name;
    int id;

    public Persons(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Subclass that extends Person and implements Worker
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking delicious food.");
    }
}

// Subclass that extends Person and implements Worker
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is taking orders and serving tables.");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101);
        Waiter waiter = new Waiter("James", 202);

        chef.performDuties();
        waiter.performDuties();
    }
}
