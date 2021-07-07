import java.util.Scanner;

public class InputView {

    static String inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }
}
