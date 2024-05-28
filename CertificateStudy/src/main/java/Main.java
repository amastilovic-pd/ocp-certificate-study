import chapter6.ChildDog;
import chapter6.DarkDog;
import chapter6.ParentDog;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    int instanceVariable;
    static int classVariable;

    public static void main(String[] args) {
//        sort(new ArrayList());
//
////        System.out.println(classVariable);
////        System.out.println("Hello world!");
        record Tree() {}
        ChildDog childDog = new ChildDog();
        ParentDog parentDog = childDog;
        childDog.printPoly();
        parentDog.printPoly();
        System.out.println(parentDog.name);
        System.out.println(childDog.name);
////
        new DarkDog().bark();
        new DarkDog();
////        int time = 3;
////        int day = 6;
////        Integer nts = 3;
////
////        boolean b = Boolean.valueOf("8").booleanValue(); // compiles
//////        Character.valueOf('x').byteValue(); // doesnt compile
////        Double.valueOf("9_.3").byteValue(); // compiles
////        Long.valueOf(88).byteValue();
////
//////        Collection objectObjectTreeMap = new TreeMap<>(); // doesnt compile
////
////        var dinner =
////                ++time >= 10 ?
////                        day-- <= 2 ?
////                                "Takeout" :
////                                "salad" :
////                        "Leftovers";
////
////        System.out.println(dinner);
////                        //  12         3
////        System.out.println((((1+1)) * ((1+2))));
//
////        Main main = new Main();
////        int instanceVariable1 = main.instanceVariable;
////        System.out.println(instanceVariable1);
////        System.out.println(classVariable);
//        int r = 6;
//        boolean b = (r<=6) && (++r <= 7);
//
//        System.out.println(r);
//        System.out.println(true & false ^ false);
//
//
//        var str1 = "mytest";
//        var str2 = "mytest".substring(4,3);
//        System.out.println(str1);
//        System.out.println(str2);
//        List<String> myl = new ArrayList<>();
//        ArrayList<String> ss = new ArrayList<>();
//
//        int[] nts = new int[] {1,2,3};
//
//        ZonedDateTime.now().toInstant();
////        LocalDateTime.now().toInstant();
//
//
//
//        System.out.println(str1==str2);
//        System.out.println(str1.equals(str2));

        List<LockedIso> iso = new ArrayList<>();

        LockedIso li = new LockedIso("name", "title");
        iso.add(li);
        PurchasedIso pi = new PurchasedIso("name", "title", List.of("asd"));
        iso.add(pi);

//        System.out.println(iso);

        String s = "ORGANIZATIONADMIN".split("-")[0];
        System.out.println(s);

        int preIncrement = 0;
        int postIncrement = 0;

//        for (int i = 0; i < 10; i++) {
//            System.out.println("current iteration: " + i);
//            System.out.println("preincrement: " + ++preIncrement);
//            System.out.println("postIncrement: " + postIncrement++);
//        }

//        for (int i = 0; i<10; i++){
//            System.out.println(i);
//        }
        List<Integer> arr = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        int lastIdx = arr.size() - 1;
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("lastidx: " + lastIdx);
            System.out.println(arr.get(lastIdx--));
//            lastIdx--;
        }
    }


//    public Flux<ProductResponseDto> getProductDtos(String billingAccount) {
//        if (Objects.isNull(billingAccount) || billingAccount.isBlank())
//            throw new IllegalArgumentException("Billing account can't be null!");
//
//        BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
//        TermQuery termQuery = new TermQuery(new Term("billingAccount", billingAccount));
//        queryBuilder.add(termQuery, BooleanClause.Occur.SHOULD);
//        String query = queryBuilder.build().toString();
//
//        return Flux.defer(() -> {
//            ProductinventoryV1DomainProductList products = productInventoryV1Api.getProductInventoryV1Products("hdp_b2c", query, 1, 50)
//                    .onErrorMap(WebClientResponseException.class, BssMessageException::new)
//                    .blockOptional()
//                    .orElseThrow(() -> new ObjectNotFoundException("Unable to find products with billing account: " + billingAccount));
//
//            return Flux.fromIterable(products.getList())
//                    .flatMap(product -> {
//                        return productInventoryV1Api.getProductInventoryV1ProductsProduct("hdp_b2c", product.getId())
//                                .onErrorResume(WebClientResponseException.class, ex -> Mono.empty())
//                                .flatMap(productDetail -> {
//                                    ProductResponseDto responseDto = toResponseDto(productDetail);
//
//                                    if (!CollectionUtils.isEmpty(productDetail.getSearchableResourceCharacteristicValues())) {
//                                        return Flux.fromIterable(productDetail.getResourceRelationships())
//                                                .flatMap(resourceRelationship -> {
//                                                    return resourceInventoryV1Api
//                                                            .getResourceInventoryV1ResourcesResource("hdp_b2c", resourceRelationship.getRelatedResource())
//                                                            .onErrorResume(WebClientResponseException.class, ex -> Mono.empty())
//                                                            .doOnNext(responseDto.getResources()::add);
//                                                })
//                                                .then(Mono.just(responseDto));
//                                    } else if (!CollectionUtils.isEmpty(productDetail.getSearchableServiceCharacteristicValues())) {
//                                        return Flux.fromIterable(productDetail.getServiceRelationships())
//                                                .flatMap(serviceRelationship -> {
//                                                    return serviceInventoryV1Api
//                                                            .getServiceInventoryV1ServicesService("hdp_b2c", serviceRelationship.getRelatedService())
//                                                            .onErrorResume(WebClientResponseException.class, ex -> Mono.empty())
//                                                            .doOnNext(responseDto.getServices()::add);
//                                                })
//                                                .then(Mono.just(responseDto));
//                                    } else {
//
//                                        return Mono.empty();
//                                    }
//                                });
//                    });
//        });
//    }
}