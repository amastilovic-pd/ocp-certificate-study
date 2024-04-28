package combinator.mapperexample;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

public interface MapperUtil extends Function<InputDto, Consumer<OutputDto>> {
    Logger log = Logger.getLogger(MapperUtil.class.getName());
    //    Logger log = LoggerFactory.getLogger(ResourceCharacteristicsUtil.class);

    static MapperUtil mapServiceIdentifier() {
        log.info("Mapping service identifier");
        return inputDto -> outputDto -> {
            if (Objects.nonNull(inputDto.getServiceIdentifier())) {
                outputDto.setServiceIdentifier(inputDto.getServiceIdentifier());
            }
        };
    }

    static MapperUtil mapVoucherId() {
        log.info("Mapping voucher id");
        return inputDto -> outputDto -> {
            if (Objects.nonNull(inputDto.getVoucherId())) {
                outputDto.setVoucherId(inputDto.getVoucherId());
            }
        };
    }

    static MapperUtil mapSmartcardSerialNumber() {
        log.info("Mapping smartcard serial number");
        return inputDto -> outputDto -> {
            if (Objects.nonNull(inputDto.getSmartcardSerialNumber())) {
                outputDto.setSmartcardSerialNumber(inputDto.getSmartcardSerialNumber());
            }
        };
    }

    static MapperUtil mapReturnShipmentId() {
        log.info("Mapping return shipment id");
        return inputDto -> outputDto -> {
            if (Objects.nonNull(inputDto.getReturnShipmentId())) {
                outputDto.setReturnShipmentId(inputDto.getReturnShipmentId());
            }
        };
    }

    default MapperUtil and(MapperUtil other) {
        log.info("Chaining resource characteristics");
        return inputDto -> outputDto -> {
            this.apply(inputDto).accept(outputDto);
            other.apply(inputDto).accept(outputDto);
        };
    }
}
