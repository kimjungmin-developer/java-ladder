package laddergame.domain;

public class LadderValidator {
    static void checkConditionsForLadder(String height) {
        int newHeight = Integer.parseInt(height);
        if (newHeight < 1) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1이상이어야 합니다.\n다시 입력해주세요.");
        }
    }

}
