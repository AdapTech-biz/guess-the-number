package adaptech.biz.service;

public interface GameService {
    boolean isGameOver();

    String getMainMessage();

    String getResultMessage();

    void checkGameStatus();

    void setGuess(int guess);

    void resetGame();
}
