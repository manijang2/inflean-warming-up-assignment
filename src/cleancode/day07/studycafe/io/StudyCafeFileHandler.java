package cleancode.day07.studycafe.io;

import cleancode.day07.studycafe.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StudyCafeFileHandler {

    public static final String PASS_CSV_RESOURCE_PATH = "resources/studycafe/pass-list.csv";
    public static final String LOCKER_CSV_FILE_PATH = "resources/studycafe/locker.csv";
    public static final String PASS_CSV_DELIMITER = ",";
    public static final String LOCKER_CSV_DELIMITER = ",";

    public StudyCafePassList readStudyCafePasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(PASS_CSV_RESOURCE_PATH));
            return new StudyCafePassList(lines, PASS_CSV_DELIMITER);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    public StudyCafeLockerPassList readLockerPasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(LOCKER_CSV_FILE_PATH));
            return new StudyCafeLockerPassList(lines, LOCKER_CSV_DELIMITER);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

}
