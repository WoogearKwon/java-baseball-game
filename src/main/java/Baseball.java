
public class Baseball {
    private final String answer;

    public Baseball() {
        answer = setRandomNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
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
        String test = InputView.inputNumbers();
        System.out.println("test is ... " + test);
    }
}
