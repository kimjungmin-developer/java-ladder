package laddergame.domain;

import java.lang.reflect.Array;
import java.util.*;

public class PlayerNamesValidator {
    static void checkConditions(String playersNames) {
        checkNullName(playersNames);
        List<String> names = new ArrayList<>(Arrays.asList(playersNames.split(",")));
        checkDuplicatedName(names);
        /*
        checkNameLength(names);
        checkEmptyName(playersNames);
         */
    }

    private static void checkDuplicatedName(List<String> names) {
        Set<String> namesWithoutDuplicates = new HashSet<>(names);
        if (names.size() != namesWithoutDuplicates.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.\n다시 입력해주세요.");
        }
    }

    private static void checkNameLength(List<String> names) {
        boolean wrongNameLength = false;
        for (int i = 0, n = names.size(); i < n && !wrongNameLength; i++) {
            wrongNameLength = checkCurrentNameLength(names.get(i));
        }
        if (wrongNameLength) {
            throw new IllegalArgumentException("선수의 이름은 1이상 5이하로 해주세요!");
        }
    }

    private static boolean checkCurrentNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            return true;
        }
        return false;
    }

    static void checkNullName(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력하신 이름이 null입니다.\n다시 입력해주세요.");
        }
    }

    private static void checkEmptyName(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력하신 이름이 없습니다.\n다시 입력해주세요.");
        }
    }
}
