package AbstractFactory.Apple;

import AbstractFactory.SmartLock;

public class AppleLock implements SmartLock {
    @Override
    public void open() {
        System.out.println("Apple lock is opened");
    }

    @Override
    public void closed() {
        System.out.println("Apple lock is closed");
    }
}
