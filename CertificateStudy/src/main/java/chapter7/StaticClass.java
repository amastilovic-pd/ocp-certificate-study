package chapter7;

public class StaticClass {
    static class MyStaticClass{
        private int price = 6;

        public static void main(String[] args) {
            MyStaticClass myStaticClass = new MyStaticClass();

            System.out.println(myStaticClass.price);
        }
    }

    public void processData() {
        final int lenght = 5;
        int width =5;
        int height = 2;

        class VolumeCalculator {
            public int multiply() {
                return lenght*width*height;
            }
        }

//        width=3;
    }
}
