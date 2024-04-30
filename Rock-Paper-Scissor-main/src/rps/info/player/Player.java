package rps.info.player;

import rps.info.game.IGameState;
import rps.info.game.Move;
import rps.info.game.Result;

//Java imports
import java.util.ArrayList;

public class Player implements IPlayer {

    private String name;
    private PlayerType type;

    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public PlayerType getPlayerType() {
        return type;
    }

    @Override
    public Move doMove(IGameState state) {
        ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();

        return Move.Rock;
    }
}
