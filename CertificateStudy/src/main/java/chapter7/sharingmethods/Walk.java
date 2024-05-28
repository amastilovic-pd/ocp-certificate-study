package chapter7.sharingmethods;

public interface Walk {

    private void getWalk() {
        System.out.println("asd");
    }

    private void gg(){
        getWalk();
    }

    default int getSpeed() {
        getWalk();
        return 5;
    }
}
