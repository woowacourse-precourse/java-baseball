package basedomain.answer;

public abstract class Answer {

    public abstract String response(int candidate);
    public abstract boolean isCorrect(int candidate);
}
