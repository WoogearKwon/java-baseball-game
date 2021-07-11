package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final List<Integer> answerNumbers;
    private final Balls balls;

    public Baseball() {
        answerNumbers = new ArrayList();
        for (int i = 0; i < 3; i++) {
            answerNumbers.add(generateNumbers());
        }

        balls = new Balls(answerNumbers);
    }

    public int generateNumbers() {
        int random = (int) (Math.random() * 10 + 1);
        if (random == 10 || answerNumbers.contains(random)) {
            return generateNumbers();
        }
        return random;
    }

    private void runGame() {
        
    }
}
