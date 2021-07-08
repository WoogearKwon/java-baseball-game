import java.util.Scanner;

public class InputView {

    static String inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }

    static String stopOrRestart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        System.out.print("숫자 입력 : ");
        return scanner.nextLine();
    }

}
