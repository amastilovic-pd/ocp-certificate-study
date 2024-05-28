package combinator.mapperexample;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

import static combinator.mapperexample.MapperUtil.mapServiceIdentifier;

public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        InputDto inputDto = new InputDto("serviceIdentifier", "voucherId", "smartcardSerialNumber", "returnShipmentId");
        OutputDto outputDto = new OutputDto();

        mapServiceIdentifier()
                .and(MapperUtil.mapVoucherId())
                .and(MapperUtil.mapSmartcardSerialNumber())
                .and(MapperUtil.mapReturnShipmentId())
                .apply(inputDto)
                .accept(outputDto);

        System.out.println(outputDto);

        RuntimeException thisIsARuntimeException = new RuntimeException("This is a runtime exception");
        System.out.println(thisIsARuntimeException);
    }
}
