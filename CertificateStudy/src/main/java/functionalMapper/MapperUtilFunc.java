package functionalMapper;

import combinator.CustomerRegistrationValidator;
import functionalMapper.model.InputDto;
import functionalMapper.model.OutputDto;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

interface MapperUtilFunc extends Function<InputDto, Boolean> {
    Logger log = Logger.getLogger(MapperUtilFunc.class.getName());

    static MapperUtilFunc mapServiceIdentifier(OutputDto outputDto) {
        log.info("Mapping service identifier");
        return inputDto -> {
            if (Objects.nonNull(inputDto.getServiceIdentifier())) {
                outputDto.setServiceIdentifier(inputDto.getServiceIdentifier());
            }
            return true;
        };
    }

    static MapperUtilFunc mapVoucherId(OutputDto outputDto) {
        log.info("Mapping voucher id");
        return inputDto -> {
            if (Objects.nonNull(inputDto.getVoucherId())) {
                outputDto.setVoucherId(inputDto.getVoucherId());
            }
            return true;
        };
    }

    static MapperUtilFunc mapSmartcardSerialNumber(OutputDto outputDto) {
        log.info("Mapping smartcard serial number");
        return inputDto -> {
            if (Objects.nonNull(inputDto.getSmartcardSerialNumber())) {
                outputDto.setSmartcardSerialNumber(inputDto.getSmartcardSerialNumber());
            }
            return true;
        };
    }

    static Function<InputDto, OutputDto> mapToOutputDto(){
        return inputDto -> {
            OutputDto outputDto = new OutputDto();
            outputDto.setReturnShipmentId(inputDto.getReturnShipmentId());
            outputDto.setServiceIdentifier(inputDto.getServiceIdentifier());
            outputDto.setSmartcardSerialNumber(inputDto.getSmartcardSerialNumber());
            outputDto.setVoucherId(inputDto.getVoucherId());
            return outputDto;
        };
    }

    static MapperUtilFunc mapReturnShipmentId(OutputDto outputDto) {
        log.info("Mapping return shipment id");
        return inputDto -> {
            if (Objects.nonNull(inputDto.getReturnShipmentId())) {
                outputDto.setReturnShipmentId(inputDto.getReturnShipmentId());
            }
            return true;
        };
    }

    default MapperUtilFunc and(MapperUtilFunc other) {
        log.info("Chaining resource characteristics");
        return inputDto -> {
            Boolean result = this.apply(inputDto);
            System.out.println(result);
            return Boolean.TRUE.equals(result) ? other.apply(inputDto) : result;
        };
    }
}
