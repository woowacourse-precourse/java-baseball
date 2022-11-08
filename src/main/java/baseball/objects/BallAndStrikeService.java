package baseball.objects;

import java.util.List;

public class BallAndStrikeService {

    private List<Integer> selectedNumbers;

    public BallAndStrikeService(List<Integer> computerNumbers) {
        this.selectedNumbers = computerNumbers;
    }


    public boolean containsExactly(Integer value, int index) {
        return selectedNumbers.contains(value) && selectedNumbers.get(index).equals(value);
    }

    public boolean contains(Integer value) {
        return selectedNumbers.contains(value);
    }

    public List<Integer> getSelectedNumbers() {
        return selectedNumbers;
    }
}
