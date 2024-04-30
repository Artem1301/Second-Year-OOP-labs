package rps.info.game;


import java.util.Collection;


public interface IGameState {

    int getRoundNumber();

    void setRoundNumber(int roundNumber);

    Collection<Result> getHistoricResults();
}
