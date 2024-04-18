package chapter7.sharingmethods;

public interface Run {

    default int getSpeed() {
        return 10;
    }
}
