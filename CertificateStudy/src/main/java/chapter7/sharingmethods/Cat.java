package chapter7.sharingmethods;

public class Cat implements Run, Walk {

    @Override
    public int getSpeed() {
        return Walk.super.getSpeed();
    }

    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed());
    }
}
