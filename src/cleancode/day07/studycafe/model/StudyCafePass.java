package cleancode.day07.studycafe.model;

public class StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafeLockerPass lockerPass;

    private StudyCafePass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafePass create(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafePass(passType, duration, price, discountRate);
    }

    public void useLockerPass(StudyCafeLockerPass lockerPass) {
        this.lockerPass = lockerPass;
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String display() {
        return passType.toDisplayString(duration, price);
    }

    public boolean isUseLockerPass() {
        return lockerPass != null;
    }

    public String lockerDisplay() {
        if (isUseLockerPass()) {
            return lockerPass.display();
        }
        throw new IllegalStateException("락커의 정보가 존재하지 않습니다.");
    }

    public int discountPrice() {
        return (int) (getPrice() * getDiscountRate());
    }

    public int getTotalPrice() {
        return getPrice() - discountPrice() + (lockerPass != null ? lockerPass.getPrice() : 0);
    }
}
