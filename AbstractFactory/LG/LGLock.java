package AbstractFactory.LG;

import AbstractFactory.SmartLock;

public class LGLock implements SmartLock {
    @Override
    public void open() {
        System.out.println("LGLock is open");
    }


    @Override
    public void closed() {
        System.out.println("LGLock is closed");
    }
}
