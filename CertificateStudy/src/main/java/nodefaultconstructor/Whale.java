package nodefaultconstructor;

public abstract class Whale {

    public int MAX = 9;

    double dz = 2.0f;

    public abstract void dive();

    public void dive(int... depth) {
        System.out.println("Orca diving deepeeeeeeeeeeeeeeeeeeer " + MAX);
    }

    public void printContents() {
        System.out.println("inside class WHale");
    }

    protected Number myMethodToBeLoaded() {
        return 3;
    }

//    public static void main(String[] args) {
//        Whale whale = new Orca();
//
//        int[] ints = {1, 2, 3};
////        whale.dive(ints);
////        System.out.println();
//    }
}

class Orca extends Whale {

    public int MAX = 3;

    public void dive() {
        System.out.println("Orca diving");
    }

    public void dive(int... depth) {
        System.out.println("Orca diving deeper " + MAX);
    }

    @Override
    public void printContents() {
        System.out.println("inside Orca class");
    }

    @Override
    public Integer myMethodToBeLoaded() {
        return 3;
    }

    public void onlyInOrca() {
        System.out.println("inorca");
    }
}

class White extends Orca {

    public static void main(String[] args) {
        Whale whale = new Orca();

        Orca orc = new Orca();

        White orc1 = (White) orc;

//        Orca orca = (Orca) whale;

        int[] ints = {1, 2, 3};
//        whale.dive(ints);

        whale.printContents();
        System.out.println(new Orca().MAX);
        System.out.println(whale.MAX);
    }
}
