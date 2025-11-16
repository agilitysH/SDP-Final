package AbstractFactory.Xiaomi;

import AbstractFactory.SmartLock;

public class XiaomiLock implements SmartLock {
    @Override
    public void open() {
        System.out.println("Xiaomi is open");
    }

    @Override
    public void closed() {
        System.out.println("Xiaomi is closed");
    }
}
