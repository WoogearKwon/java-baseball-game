package baseball;

public class ResultView {

    static void startGame() {
        println("\n숫자 야구 게임을 시작합니다.");
    }

    static void threeStrike() {
        println("3개의 숫자를 모두 맞히셨습니다!");
    }

    static void nothing() {
        println("낫씽!");
    }

    static void stopGame() {
        println("게임을 종료합니다.");
    }

    static void restartGame() {
        println("게임을 새로 시작합니다.");
    }

    static void invalidInput() {
        println("입력값이 올바르지 않습니다.");
    }

    static void strikesAndBalls(PlayResult result) {
        String status = "";

        if (result.getStrike() != 0) {
            status += result.getStrike() + "스트라이크 ";
        }

        if (result.getBall() != 0) {
            status += result.getBall() + "볼";
        }

        println(status);
    }

    private static void println(String s) {
        System.out.println(s);
    }
}
