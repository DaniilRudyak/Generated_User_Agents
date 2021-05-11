import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class Main {


    public static void main(String[] args) throws IOException {
//        System.out.println("Hello Java!");
//
//        ObjectMapper mapper = new ObjectMapper();
//        String link = "https://github.com/intoli/user-agents/raw/master/src/user-agents.json.gz";
//        InputStream in = new URL(link).openStream();
//
//        GZIPInputStream gzFile = new GZIPInputStream(in);
//        List<UserAgent> users = Arrays.asList(mapper.readValue(gzFile, UserAgent[].class));
//        System.out.println(users.size());

        System.out.println(GenerateUserAgent.generate());
    }
}
