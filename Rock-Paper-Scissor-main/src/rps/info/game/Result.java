package rps.info.game;

import rps.info.player.IPlayer;

public class Result {
    private ResultType type;
    private Move winnerMove;
    private IPlayer winnerPlayer;
    private Move loserMove;
    private IPlayer loserPlayer;
    private int roundNumber;

    public Result(IPlayer winnerPlayer, Move winnerMove, IPlayer loserPlayer, Move loserMove, ResultType type, int roundNumber) {
        this.winnerPlayer = winnerPlayer;
        this.winnerMove = winnerMove;
        this.loserPlayer = loserPlayer;
        this.loserMove = loserMove;
        this.type = type;
        this.roundNumber = roundNumber;
    }

    public Move getWinnerMove() {
        return winnerMove;
    }

    public IPlayer getWinnerPlayer() {
        return winnerPlayer;
    }

    public Move getLoserMove() {
        return loserMove;
    }

    public IPlayer getLoserPlayer() {
        return loserPlayer;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public ResultType getType() {
        return type;
    }
}
