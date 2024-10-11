package cleancode.day07.studycafe.model;

import cleancode.day07.studycafe.exception.AppException;

public enum LockerUsageType {
    USE("예", "1", true),
    NO("아니오", "2", false);

    private final String name;
    private final String inputNum;
    private final boolean isUsage;

    LockerUsageType(String name, String inputNum, boolean isUsage) {
        this.name = name;
        this.inputNum = inputNum;
        this.isUsage = isUsage;
    }

    public static boolean getIsUsageFrom(String inputNum) {
        for (LockerUsageType type : LockerUsageType.values()) {
            if (type.inputNum.equals(inputNum)) {
                return type.isUsage;
            }
        }

        throw new AppException("잘못된 입력입니다.");
    }
}
