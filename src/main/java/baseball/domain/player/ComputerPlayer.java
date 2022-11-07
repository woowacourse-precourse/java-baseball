package baseball.domain.player;

import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerPlayer extends Player {

    @Override
    public void getNumber() {
        List<Integer> intList = new ArrayList<>();
        while (intList.size() < GameService.LENGTH_OF_NUM) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!intList.contains(randomNumber)) {
                intList.add(randomNumber);
            }
        }
        List<String> strList = intList.stream().map(Object::toString).collect(Collectors.toUnmodifiableList());
        number = Integer.parseInt(String.join("", strList));
    }

}
