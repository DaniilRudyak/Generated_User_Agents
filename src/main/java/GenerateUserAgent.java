import com.carrotsearch.sizeof.RamUsageEstimator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class GenerateUserAgent {
    public static UserAgent generate() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String link = "https://github.com/intoli/user-agents/raw/master/src/user-agents.json.gz";
            InputStream in = new URL(link).openStream();
            GZIPInputStream gzFile = new GZIPInputStream(in);
            List<UserAgent> users = Arrays.asList(mapper.readValue(gzFile, UserAgent[].class));
            System.out.println(users.size());
            int randomIndex = randomIndex(users);
            //System.out.println(InstrumentationFetcher.getObjectSize(users));
            System.out.println(RamUsageEstimator.shallowSizeOf(users));
            return users.get(randomIndex);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int randomIndex(List<UserAgent> userAgents) {
        double totalWeight = 0;
        Double[] arrayWeight = new Double[userAgents.size()];
        for (int i = 0; i < userAgents.size(); ++i) {
            totalWeight += userAgents.get(i).getWeight();
            arrayWeight[i] = userAgents.get(i).getWeight();
        }

        for (int i = 0; i < arrayWeight.length; ++i) {
            arrayWeight[i] = arrayWeight[i] / totalWeight;
        }

        for (int i = 1; i < arrayWeight.length; ++i) {
            for (int j = 0; j < i; ++j) {
                arrayWeight[i] += arrayWeight[j];
            }
        }
        int findIndex = 0;
        double randomNumber = Math.random();
        for (Double weight : arrayWeight) {
            if (weight > randomNumber) {
                break;
            } else {
                ++findIndex;
            }
        }
        return findIndex;
    }
}
