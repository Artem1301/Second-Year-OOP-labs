package rps.info.player;

import rps.info.game.IGameState;
import rps.info.game.Move;

public interface IPlayer {

    public String getPlayerName();

    public PlayerType getPlayerType();

    public Move doMove(IGameState state);
}
