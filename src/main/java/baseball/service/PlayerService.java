package baseball.service;

import baseball.repository.PlayerRepository;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class PlayerService {
    private GameService gameService = new GameService();
    private PlayerRepository playerRepository = new PlayerRepository();



    public ArrayList<Integer> inputPlayerNumber() {
        ArrayList<Integer> playerNumberList = new ArrayList<>();
        String playerNumbers = Console.readLine();
        gameService.checkInputPlayerNumber(playerNumbers);
        for (int i=0;i<3;i++) {
            playerNumberList.add(Character.getNumericValue(playerNumbers.charAt(i)));
        }
        return playerNumberList;
    }


    public void setPlayerNumber(ArrayList<Integer> playerNumberList){
        int firstNumber = playerNumberList.get(0);
        int secondNumber = playerNumberList.get(1);
        int thirdNumber = playerNumberList.get(2);
        playerRepository.setPlayer(firstNumber,secondNumber,thirdNumber);
    }

    public ArrayList<Integer> getPlayerNumber() {
        ArrayList<Integer> playerNumberList = new ArrayList<>();
        playerNumberList.add(playerRepository.getPlayer().getFirstNumber());
        playerNumberList.add(playerRepository.getPlayer().getSecondNumber());
        playerNumberList.add(playerRepository.getPlayer().getThirdNumber());
        return playerNumberList;
    }

    public Boolean inputRestartAnswer() {
        String answer = Console.readLine();
        if (answer.equals("1")) {
            return true;
        }else if (answer.equals("2")){
            return false;
        }else {
            throw new IllegalArgumentException();
        }
    }

}
