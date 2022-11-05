package baseball.service;

import baseball.repository.ComputerBaseballGameNumberRepository;
import baseball.vo.enumtype.GameNumberInclusive;
import baseball.vo.enumtype.GameRule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerBaseballService {
    private ComputerBaseballGameNumberRepository computerBaseballGameNumberRepository;

    private ComputerBaseballService() {
    }

    private static class InnerComputerBaseballService {
        private static final ComputerBaseballService instance = new ComputerBaseballService();
    }

    public static ComputerBaseballService getInstance() {
        return InnerComputerBaseballService.instance;
    }

    public void createNewBaseballGameNumberList() {
        this.computerBaseballGameNumberRepository =
                ComputerBaseballGameNumberRepository.builder()
                        .getComputerBaseballGameNumberList(initBaseballGameNumberList())
                        .build();
    }

    private List<Integer> initBaseballGameNumberList() {
        final Set<Integer> baseballGameNumberSet = new HashSet<>();

        do {
            baseballGameNumberSet.add(Randoms.pickNumberInRange(GameNumberInclusive.START.getValue(),
                    GameNumberInclusive.END.getValue()));
        } while (baseballGameNumberSet.size() < GameRule.GAME_NUMBER_LEN.getValue());

        return new ArrayList<>(baseballGameNumberSet);
    }

    public List<Integer> getComputerBaseballGameNumberList() {
        if (this.computerBaseballGameNumberRepository == null) {
            this.createNewBaseballGameNumberList();
        }
        return computerBaseballGameNumberRepository.getComputerBaseballGameNumberList();
    }
}
