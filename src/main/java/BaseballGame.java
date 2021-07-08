
public class BaseballGame {
    private String answer;
    private String input;

    private int strikes;
    private int balls;

    public BaseballGame() {
        startGame();
    }

    private void startGame() {
        answer = setRandomNumbers();
        ResultView.startGame();
    }

    private String setRandomNumbers() {
        String numbers = "";

        while (numbers.length() < 3) {
            numbers += generateNumber(numbers);
        }

        return numbers;
    }

    private String generateNumber(String current) {
        int random = (int) (Math.random() * 10 + 1);
        String value = String.valueOf(random);

        if (random == 10 || current.contains(value)) {

            return generateNumber(current);
        }

        return value;
    }

    void runGame() {
        activateInput();

        while (!isInputCorrect(input, answer)) {
            activateInput();
        }
    }

    private void activateInput() {
        input = InputView.inputNumbers();

        if (!isInputValid(input)) {
            ResultView.invalidInput();
            activateInput();
        }
    }

    boolean isInputCorrect(String input, String answer) {
        strikes = 0;
        balls = 0;

        for (int i = 0; i < 3; i++) {
            countStrikesAndBalls(i, input, answer);
        }

        return getCheckResult();
    }

    private void countStrikesAndBalls(int i, String input, String answer) {
        if (input.charAt(i) == answer.charAt(i)) {
            strikes++;
            return;
        }

        if (answer.contains(String.valueOf(input.charAt(i)))) {
            balls++;
        }
    }

    private boolean getCheckResult() {
        String result = "";

        if (strikes == 3) {
            ResultView.allMatched();
            return stopGameOrRestart();
        }

        if (strikes == 0 && balls == 0) {
            ResultView.nothing();
            return false;
        }

        if (strikes != 0) {
            result += strikes + "스트라이크 ";
        }

        if (balls != 0) {
            result += balls + "볼";
        }

        System.out.println(result);

        return false;
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

    private boolean stopGameOrRestart() {
        String choice = InputView.stopOrRestart();
        if (!choice.equals("1") && !choice.equals("2")) {
            ResultView.invalidInput();
            return stopGameOrRestart();
        }

        if (choice.equals("1")) {
            ResultView.restartGame();
            startGame();
            return false;
        }

        ResultView.stopGame();
        return true;
    }
}
