package AbstractFactory;

public class LGFactory implements Company {
    @Override
    public Device createTV() {
        return new LGTV();
    }

    @Override
    public Device createRefrigerator() {
        return new LGRefrigerator();
    }
}
