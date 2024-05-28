package functionalMapper;

import functionalMapper.model.InputDto;
import functionalMapper.model.OutputDto;

import java.util.logging.Logger;

import static functionalMapper.MapperUtil.mapServiceIdentifier;
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

//        mapToOutputDto(inputDto).accept(outputDto);
        OutputDto output = MapperUtilFunc.mapToOutputDto().apply(inputDto);

        System.out.println(output);
    }
}
