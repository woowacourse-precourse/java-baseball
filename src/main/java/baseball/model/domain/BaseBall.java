package baseball.model.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {

    private Long id;
    private List<Integer> answer;

    public BaseBall() {
        this.answer = createAnswer();
    }

    public Long getId() {
        return id;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }
}
