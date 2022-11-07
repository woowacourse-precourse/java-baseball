package baseball.gameconsole;

public interface ClientConsole {

    String readLine();

    void outEndingSentence();

    void outResultScoreSentence(String resultScoreSentence);

    void outRequestInputNumber();

    void outStartGameSentence();

    void outEndGame();
}
