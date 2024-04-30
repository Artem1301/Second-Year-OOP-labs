package rps.gui.controller;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rps.info.game.*;
import rps.info.player.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameViewController implements Initializable {

    @FXML
    private Label welcomeLabel;
    @FXML
    private TextField playerNameField;
    @FXML
    private Label opponentLabel;
    @FXML
    private Label gameStatusLabel;

    private GameManager gameManager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void playRock() {
        playRound("Rock");
    }

    @FXML
    public void playPaper() {
        playRound("Paper");
    }

    @FXML
    public void playScissor() {
        playRound("Scissor");
    }

    @FXML
    public void exitGame() {

    }

    private void playRound(String playerMove) {
        if (gameManager == null) {
            String playerName = playerNameField.getText();
            IPlayer human = new Player(playerName, PlayerType.Human);
            IPlayer bot = new Player(getRandomBotName(), PlayerType.AI);
            gameManager = new GameManager(human, bot);
            opponentLabel.setText("Your opponent is " + bot.getPlayerName());
        }

        gameManager.playRound(Move.valueOf(playerMove));

        // Получение списка результатов игры
                List<Result> results = new ArrayList<>(gameManager.getGameState().getHistoricResults());

        // Получение последнего результата
        Result result = results.get(results.size() - 1);
        gameStatusLabel.setText(getResultAsString(result));
    }

    private String getResultAsString(Result result) {
        String statusText = result.getType() == ResultType.Win ? "wins over " : "ties ";

        return "Round #" + result.getRoundNumber() + ":" +
                result.getWinnerPlayer().getPlayerName() +
                " (" + result.getWinnerMove() + ") " +
                statusText + result.getLoserPlayer().getPlayerName() +
                " (" + result.getLoserMove() + ")!";
    }

    private String getRandomBotName() {
        String[] botNames = new String[]{
                "R2D2",
                "Bender"
        };
        int randomNumber = new Random().nextInt(botNames.length);
        return botNames[randomNumber];
    }
}

