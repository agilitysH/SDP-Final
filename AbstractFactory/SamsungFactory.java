package AbstractFactory;

public class SamsungFactory implements Company {
    @Override
    public Device createTV() {
        return new SamsungTV();
    }

    @Override
    public Device createRefrigerator() {
        return new SamsungRefrigerator();
    }
}
