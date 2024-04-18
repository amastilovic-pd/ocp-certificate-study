package chpater11;

public class HandlingExceptions {

//    private void handleExceptions() {
//        try {
//            // protected code
//            throw new Error();
//        } catch (Exception e) {
//            // exception handler
//        } catch (NullPointerException e) { // wont work
//            // exception handler
//        }
//    }

//    private void multiCatch() {
//        try {
//            // protected code
//        } catch (NullPointerException | NoSuchElementException e) {
//            // exception handler
//        } catch (NullPointerException e1 | NoSuchElementException e2 | Exception e3) { // doesnt compile
//            // exception handler
//        }
//    }

    // finally block runs regardless
//    private void finallyStatement() {
//
//        try (FileInputStream is = new FileInputStream("test.txt")) {
//            // protected code
//        } catch (IOException e) {
//            // exception handler
//        } finally {
//            // always runs
//            System.out.println("prints always, unless...");
//        }
//    }

//    private void finallyStatementOmitted() {
//
//        try (FileInputStream is = new FileInputStream("test.txt")) {
//            // protected code
//            System.exit(0); // skips finally block
//        } catch (IOException e) {
//            // exception handler
//            System.exit(0); // skips finally block
//        } finally {
//            // always runs
//            System.out.println("prints always, unless...");
//        }

//    //other code
//    }
}
