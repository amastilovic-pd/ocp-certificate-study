package examOneTests.questionOne;

public class Tortoise {
    protected void race(Hare hare) {
        hare.init(); // x1
        hare.race(); // x2
        System.out.print("tortoise-");
    }
    public static void main(String[] args) {
        var tortoise = new Tortoise();
        var hare = new Hare();
        tortoise.race(hare);
    }
}
