package baseball.service;

import baseball.repository.ComputerRepository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    private ComputerRepository computerRepository = new ComputerRepository();

    public void setComputerNumber() {
        List<Integer> computerNumbers = Randoms.pickUniqueNumbersInRange(1,9,3);
        int firstNumber = computerNumbers.get(0);
        int secondNumber = computerNumbers.get(1);
        int thirdNumber = computerNumbers.get(2);
        computerRepository.setComputer(firstNumber,secondNumber,thirdNumber);
    }

    public ArrayList<Integer> getComputerNumber() {
        ArrayList<Integer> computerNumberList = new ArrayList<>();
        computerNumberList.add(computerRepository.getComputer().getFirstNumber());
        computerNumberList.add(computerRepository.getComputer().getSecondNumber());
        computerNumberList.add(computerRepository.getComputer().getThirdNumber());
        return computerNumberList;
    }
}
