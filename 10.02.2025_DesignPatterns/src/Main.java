public class Main {
    public static void main(String[] args) {
        Animal animal = GenericBuilder.of(Animal::new)
                .with(Animal::setName, "Lion")
                .with(Animal::setAge, 5)
                .build();

        System.out.println("Animal Name: " + animal.getName());
        System.out.println("Animal Age: " + animal.getAge());
    }
}
