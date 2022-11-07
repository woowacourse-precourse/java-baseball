package baseball.system.voter;

public interface Voter<F, T> {
    T vote(F target);
}
