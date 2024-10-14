package strategy_pattern;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    static boolean b;
    public static void main(String[] args) {
//        ShoppingCart cart = new ShoppingCart(new PayPalPayment("test", "test"));
//        cart.checkout(50);
//
//        printDate();
//        System.out.println(UUID.randomUUID());
//        Prod prod = new Prod();
//        prod.setParams(null);
////
//        extracted(prod);
//        System.out.println(prod.getParams());

//        Map<String, String> map = new HashMap<>();
//        map.put("1", "one");
//        String s = map.get("5");
//        String s1 = Optional.ofNullable(s)
//                .orElseThrow(() -> new IllegalArgumentException("No value found"));
//        System.out.println(s1);

        // --------------------------------------------------------
        Map<String, Prod> prodMap = new HashMap<>();
        List<String> strings = List.of("1", "2", "3");

        prodMap.putAll(strings
                .stream().collect(Collectors.toMap(s2 -> s2, s2 -> new Prod())));
        prodMap.put("1", new Prod());
        System.out.println(prodMap);
        Prod prod = prodMap.get("1");
        prod.setName("test");
//        prodMap.put("1", prod);
        System.out.println(prodMap);
        System.out.println(b);

//        System.out.println(prodMap.entrySet());
//        System.out.println(UUID.randomUUID());
        // --------------------------------------------------------
        Instant date = Instant.now();
        System.out.println(date);
        System.out.println(processTerminationDate(date, 1012));
//        Map<String, String> m = new HashMap<>();
//        m.put("1", null);
//        m.put("2", "two");
//        m.putIfAbsent("1", "three");
//        m.putIfAbsent("2", "three");
//        m.putIfAbsent("3", "three");
//        String s1 = m.get("5");
//        System.out.println(m);
//        System.out.println(s1);
        String username = "username";
        printme(validateUsername(username));
    }



    private static String validateUsername(String s) {
        return Objects.nonNull(s)
                ? printme(s)
                : s;
    }

    private static String printme(String s){
        return s;
    }

    private static String processTerminationDate(Instant date, int incrementMonths) {
        ZonedDateTime zonedDateTime = date.atZone(ZoneId.systemDefault());

        String incDate = zonedDateTime.plusMonths(incrementMonths).toInstant().toString();
        return incDate;
    }

    private static void extracted(Prod prod) {
        HashMap<String, String> params = prod.getParams();
        if(Objects.isNull(prod.getParams())) {
            params = new HashMap<>();
            prod.setParams(params);
        }
        System.out.println(params);
        params.put("key2", "value2");

        System.out.println(params);
    }

    //print date with only date
    public static void printDate() {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(LocalDate.now());
    }
    static class Prod {
        private String name;
        private HashMap<String, String> params = new HashMap<>();

        public Prod() {
            params.put("key", "value");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HashMap<String, String> getParams() {
            return params;
        }

        public void setParams(HashMap<String, String> params) {
            this.params = params;
        }

        @Override
        public String toString() {
            return "Prod{" +
                    "name='" + name + '\'' +
                    ", params=" + params +
                    '}';
        }
    }
}
