package baseball;

public class Configure {

    public Generator generator() {
        return new Generator();
    }

    public Validator validator() {
        return new Validator();
    }

    public Checker checker() {
        return new Checker();
    }

}
