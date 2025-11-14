package Builder;

public class OwnerBuilder {
    private String name;
    private int age;

    public OwnerBuilder(String name) {
        this.name = name;
        return this;
    }

    public OwnerBuilder age(int age) {
        this.age = age;
        return this;
    }

    public Owner build() {
        return new Owner(name, age);
    }
}
