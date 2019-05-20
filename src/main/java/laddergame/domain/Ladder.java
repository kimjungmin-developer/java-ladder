package laddergame.domain;

import java.lang.reflect.Array;
import java.util.*;

public class Ladder {
    private List<Line> ladderInformationAsTrueFalse = new ArrayList<>();
    private final int width;
    private final int height;

    public Ladder(final int width, final String height) {
        checkConditionsForLadder(height);

        this.width = width;
        this.height = Integer.parseInt(height);
        this.ladderInformationAsTrueFalse = generateLadderInformation(this.width, this.height);
    }

    public Ladder(List<Line> lines, int width, int height) {
        this.ladderInformationAsTrueFalse = lines;
        this.width = width;
        this.height = height;
    }

    private static void checkConditionsForLadder(String height) {
        int newHeight = Integer.parseInt(height);
        if (newHeight < 1) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1이상이어야 합니다.\n다시 입력해주세요.");
        }
    }

    private List<Line> generateLadderInformation(int width, int hegiht) {
        List<Line> ladderInformationAsTrueFalse = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderInformationAsTrueFalse.add(new Line(width));
        }
        return ladderInformationAsTrueFalse;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Line> getLadderInformationAsTrueFalse() {
        return ladderInformationAsTrueFalse;
    }

    public void makeThePlayersClimbDownTheLadder(Players players) {
        for (int i = 0; i < ladderInformationAsTrueFalse.size(); i++) {
            switchPosition(ladderInformationAsTrueFalse.get(i), players);
        }
    }

    private void switchPosition(Line line, Players players) {
        for (int i = 0; i < line.getLineSize(); i++) {
            swap(line, i, players);
        }
    }

    private void swap(Line line, int position, Players players) {
        if (line.getBooleanValue(position)) {
            Collections.swap(players.getPlayers(), position, position + 1);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return width == ladder.width &&
                height == ladder.height &&
                Objects.equals(ladderInformationAsTrueFalse, ladder.ladderInformationAsTrueFalse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderInformationAsTrueFalse, width, height);
    }
}
