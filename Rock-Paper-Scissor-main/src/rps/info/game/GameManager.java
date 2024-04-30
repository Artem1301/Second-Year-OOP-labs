package rps.info.game;


import java.util.ArrayList;

import rps.info.player.IPlayer;


public class GameManager {

    private IGameState gameState;
    private IPlayer bot;
    private IPlayer human;


    public GameManager(IPlayer human, IPlayer bot) {
        gameState = new GameState(new ArrayList<>(), 1);
        this.human = human;
        this.bot = bot;
    }


    public Result playRound(Move human_move) {
        Move bot_move = bot.doMove(gameState);
        Result result;
        int roundNumber = gameState.getRoundNumber();

        if (human_move == bot_move)
            result = new Result(human, human_move, bot, bot_move, ResultType.Tie, roundNumber);
        else if ((human_move == Move.Rock && bot_move == Move.Scissor) ||
                (human_move == Move.Scissor && bot_move == Move.Paper) ||
                (human_move == Move.Paper && bot_move == Move.Rock)) {
            result = new Result(human, human_move, bot, bot_move, ResultType.Win, roundNumber);
        } else {
            result = new Result(bot, bot_move, human, human_move, ResultType.Win, roundNumber);
        }

        gameState.setRoundNumber(++roundNumber);
        gameState.getHistoricResults().add(result);

        return result;
    }

    public IGameState getGameState() {
        return gameState;
    }
}
