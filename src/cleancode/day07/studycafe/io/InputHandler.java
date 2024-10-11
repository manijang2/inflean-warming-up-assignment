package cleancode.day07.studycafe.io;

import cleancode.day07.studycafe.exception.AppException;
import cleancode.day07.studycafe.model.LockerUsageType;
import cleancode.day07.studycafe.model.StudyCafePass;
import cleancode.day07.studycafe.model.StudyCafePassType;

import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String LOCKER_INPUT_NUM = "1";

    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();
        return StudyCafePassType.from(userInput);
    }

    public StudyCafePass getSelectPass(List<StudyCafePass> passes) {

        String userInput = SCANNER.nextLine();

        int inputNum;
        try {
            inputNum = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new AppException("숫자가 아닌 다른 값을 입력했습니다.");
        }

        int selectedIndex = inputNum - 1;
        return passes.get(selectedIndex);
    }

    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return LockerUsageType.getIsUsageFrom(userInput);
    }

}
