package baseball.domain.entity;


import java.util.List;

public interface NumberRepository {

    List<Integer> getNumbers();
    void setNumbers(List<Integer> numbers);
}
