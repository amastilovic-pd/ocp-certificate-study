package functionalMapper;

import functionalMapper.model.InputDto;
import functionalMapper.model.OutputDto;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import static functionalMapper.MapperUtilConsumer.mapToOutputDto;

public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        InputDto inputDto = new InputDto("1", "2", "3", "4");
        OutputDto outputDto = new OutputDto();

//        mapServiceIdentifier()
//                .and(MapperUtil.mapVoucherId())
//                .and(MapperUtil.mapSmartcardSerialNumber())
//                .and(MapperUtil.mapReturnShipmentId())
//                .apply(inputDto)
//                .accept(outputDto);

//        MapperUtilFunc.mapReturnShipmentId(outputDto)
//                .and(MapperUtilFunc.mapSmartcardSerialNumber(outputDto))
//                .and(MapperUtilFunc.mapServiceIdentifier(outputDto))
//                .and(MapperUtilFunc.mapVoucherId(outputDto))
//                .apply(inputDto);

//        MapperUtilConsumer.mapReturnShipmentId(inputDto)
//                .and(MapperUtilConsumer.mapSmartcardSerialNumber(inputDto))
//                .and(MapperUtilConsumer.mapServiceIdentifier(inputDto))
//                .and(MapperUtilConsumer.mapVoucherId(inputDto))
//                .accept(outputDto);

        mapToOutputDto(inputDto).accept(outputDto);
//        OutputDto output = MapperUtilFunc.mapToOutputDto().apply(inputDto);
//        System.out.println(outputDto);
//        moveLargestElementOfLinkedListToEnd(new LinkedList<>(List.of(1, 2, 3, 4, 5, 0)));
        String whonkows = "test %s".formatted("whonkows");
        String whonkows1 = String.format("test %s", "whonkows");
        System.out.println(whonkows);
        System.out.println(whonkows1);
    }

    static void findLargestNumberArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Largest number in array is: " + max);
    }

    static void moveLargestElementOfLinkedListToEnd(LinkedList<Integer> list) {
        // Move the largest element of a linked list to the end of the list
        if(list.isEmpty()) {
            // List is empty
            return;
        }

        int head = list.getFirst();
        int maxIndex = 0;

        if(list.size() == 1) {
            // If the list has only one element, return the list
            System.out.println(list);
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > head) {
                head = list.get(i);
                maxIndex = i;
            }
        }
        if (list.getLast() < head) {
            list.remove(maxIndex);
            list.addLast(head);
        }

        System.out.println(list);
    }
}
