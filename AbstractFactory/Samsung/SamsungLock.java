package AbstractFactory.Samsung;

import AbstractFactory.SmartLock;

public class SamsungLock implements SmartLock {
    @Override
    public void open() {
        System.out.println("Samsung Lock is opened");
    }


    @Override
    public void closed() {
        System.out.println("Samsung Lock is closed");
    }
}
