package functionalMapper.model;

public class OutputDto {
    private String serviceIdentifier;
    private String voucherId;
    private String smartcardSerialNumber;
    private String returnShipmentId;


    public OutputDto() {
    }

    public OutputDto(String serviceIdentifier, String voucherId, String smartcardSerialNumber, String returnShipmentId) {
        this.serviceIdentifier = serviceIdentifier;
        this.voucherId = voucherId;
        this.smartcardSerialNumber = smartcardSerialNumber;
        this.returnShipmentId = returnShipmentId;
    }

    public String getServiceIdentifier() {
        return serviceIdentifier;
    }

    public void setServiceIdentifier(String serviceIdentifier) {
        this.serviceIdentifier = serviceIdentifier;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public String getSmartcardSerialNumber() {
        return smartcardSerialNumber;
    }

    public void setSmartcardSerialNumber(String smartcardSerialNumber) {
        this.smartcardSerialNumber = smartcardSerialNumber;
    }

    public String getReturnShipmentId() {
        return returnShipmentId;
    }

    public void setReturnShipmentId(String returnShipmentId) {
        this.returnShipmentId = returnShipmentId;
    }

    @Override
    public String toString() {
        return "OutputDto{" +
                "serviceIdentifier='" + serviceIdentifier + '\'' +
                ", voucherId='" + voucherId + '\'' +
                ", smartcardSerialNumber='" + smartcardSerialNumber + '\'' +
                ", returnShipmentId='" + returnShipmentId + '\'' +
                '}';
    }
}
