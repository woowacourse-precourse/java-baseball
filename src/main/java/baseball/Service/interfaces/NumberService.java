package baseball.Service.interfaces;

import baseball.Model.NumberItem;

import java.util.List;

public interface NumberService {

    NumberItem createComputerNumber() throws IllegalArgumentException;

    NumberItem createUserNumber() throws IllegalArgumentException;


}
