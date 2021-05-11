import lombok.Data;

@Data
public class UserAgent {
    private String appName;
    private Connection connection;
    private String platform;
    private Integer pluginsLength;
    private String vendor;
    private String userAgent;
    private Integer viewportHeight;
    private Integer viewportWidth;
    private String deviceCategory;
    private Integer screenHeight;
    private Integer screenWidth;
    private Double weight;

}
