package cleancode.day07.studycafe.model;

public class StudyCafeLockerPass {

    private final StudyCafePassType type;
    private final int duration;
    private final int price;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.type = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    public StudyCafePassType getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public String display() {
        return type.toDisplayString(duration, price);
    }

}
