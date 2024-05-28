package functionalMapper;

import functionalMapper.model.InputDto;
import functionalMapper.model.OutputDto;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.logging.Logger;

interface MapperUtilConsumer extends Consumer<OutputDto> {

    Logger log = Logger.getLogger(MapperUtilConsumer.class.getName());

    static MapperUtilConsumer mapServiceIdentifier(InputDto inputDto) {
        log.info("Mapping service identifier");
        return outputDto -> {
            if (Objects.nonNull(inputDto.getServiceIdentifier())) {
                outputDto.setServiceIdentifier(inputDto.getServiceIdentifier());
            }
        };
    }

    static MapperUtilConsumer mapVoucherId(InputDto inputDto) {
        log.info("Mapping voucher id");
        return outputDto -> {
            if (Objects.nonNull(inputDto.getVoucherId())) {
                outputDto.setVoucherId(inputDto.getVoucherId());
            }
        };
    }

    static MapperUtilConsumer mapSmartcardSerialNumber(InputDto inputDto) {
        log.info("Mapping smartcard serial number");
        return outputDto -> {
            if (Objects.nonNull(inputDto.getSmartcardSerialNumber())) {
                outputDto.setSmartcardSerialNumber(inputDto.getSmartcardSerialNumber());
            }
        };
    }

    static MapperUtilConsumer mapReturnShipmentId(InputDto inputDto) {
        log.info("Mapping return shipment id");
        return outputDto -> {
            if (Objects.nonNull(inputDto.getReturnShipmentId())) {
                outputDto.setReturnShipmentId(inputDto.getReturnShipmentId());
            }
        };
    }

    static MapperUtilConsumer mapToOutputDto(InputDto inputDto) {
        log.info("Mapping input dto to output dto");
        return outputDto -> {
            outputDto.setReturnShipmentId(inputDto.getReturnShipmentId());
            outputDto.setServiceIdentifier(inputDto.getServiceIdentifier());
            outputDto.setSmartcardSerialNumber(inputDto.getSmartcardSerialNumber());
            outputDto.setVoucherId(inputDto.getVoucherId());
        };
    }

    default MapperUtilConsumer and(MapperUtilConsumer other) {
        log.info("Chaining resource characteristics");
        return outputDto -> {
            this.accept(outputDto);
            other.accept(outputDto);
        };
    }
}
