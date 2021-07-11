package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baseball {
    private final List<Integer> answerNumbers;
    private final Balls balls;
    private String input;

    public Baseball() {
        answerNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            answerNumbers.add(generateNumbers());
        }

        balls = new Balls(answerNumbers);

        ResultView.startGame();
    }

    public int generateNumbers() {
        int random = (int) (Math.random() * 10 + 1);
        if (random == 10 || answerNumbers.contains(random)) {
            return generateNumbers();
        }
        return random;
    }

    public void runGame() {
        input = InputView.inputNumbers();
        if (!isInputValid(input)) {
            ResultView.invalidInput();
            runGame();
            return;
        }

        PlayResult result = balls.play(inputStringToList());

        if (!result.isGameEnd()) {
            runGame();
            return;
        }

        if (doRestartGame()) {
            ResultView.startGame();
            runGame();
        }
    }

    private boolean doRestartGame() {
        String choice = InputView.stopOrRestart();

        if (!choice.equals("1") && !choice.equals("2")) {
            ResultView.invalidInput();
            return doRestartGame();
        }

        if (choice.equals("1")) {
            ResultView.restartGame();
            runGame();
            return true;
        }

        ResultView.stopGame();
        return false;
    }

    private List<Integer> inputStringToList() {
        Integer[] array = new Integer[3];
        for (int i = 0; i < 3; i++) {
            array[i] = input.charAt(i) - '0';
        }

        return Arrays.asList(array);
    }

    public boolean isInputValid(String input) {
        if (input.isEmpty()) {
            return false;
        }

        if (input.length() != 3) {
            return false;
        }

        return isInputNumeric(input);
    }

    private boolean isInputNumeric(String input) {
        if (input == null) {
            return false;
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
