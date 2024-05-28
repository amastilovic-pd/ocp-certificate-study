import java.util.logging.Logger;

public class ChapterFour {

    public static final Logger log = Logger.getLogger(ChapterFour.class.getName());

    public static int mytst = 3;

    public static void main(String[] args) {

        ChapterFour cf = new ChapterFour();
        cf.eat();
        cf.newStringMethod(3);
//        eat();
        int[][] matrix = new int[1][];
//        matrix[0] = new int [5];
//        matrix[1] = new int [3];

        Object obj;

        String myst = "asd";
        String mystrg = new String("asd");
        String myexistingstr = "asd";
        int tuna = 4;

//        String newstr = tuna+1;

        String alpha = "";
        StringBuilder beta = new StringBuilder();

        for (char current = 'a'; current <= 'z'; current++) {
            alpha += current;
        }
        log.info(alpha); // creates 27 string objects

        for (char current = 'a'; current <= 'z'; current++) {
            beta.append(current);
        }

        log.info("String builder beta: " + beta); // creates one object

        StringBuilder strBuilder = new StringBuilder("StrBuilder");
        String strNotBuilder = "StrBuilder";

//        strBuilder
        System.out.println("Comparing string builder and string: " + strBuilder.equals(strNotBuilder));
        System.out.println(myst == mystrg);
        System.out.println("comparing String literal with String object: " + myst.equals(mystrg));
//
//        System.out.println("before");
        System.out.println("myst and myexistingstr hashcode comparison: " + myst.hashCode() + " " + myexistingstr.hashCode());
//        System.out.println("after");
//        System.out.println(myst.hashCode() +" "+ mystrg.hashCode());
//
//        int tst = 2;
//        newStringMethod(tst);
//        System.out.println(tst);
//        rest(1);
//        System.out.println(matrix.length);
//        System.out.println(matrix[1].length);
    }


    public static void rest(Long x) {
        System.out.println("test");
    }

    public static void newStringMethod(int str) {
//        eat();
        str += 4;
    }

    public void eat() {
        mytst++;
        System.out.println("FROM EAT: " + mytst);
        rest(3l);
    }
}
