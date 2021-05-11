import lombok.Data;

@Data
public class Connection {
    private Double downlink;
    private Double downlinkMax;
    private String effectiveType;
    private Integer rtt;
    private String type;
}
