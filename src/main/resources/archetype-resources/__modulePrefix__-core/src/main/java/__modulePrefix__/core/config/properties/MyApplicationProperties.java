package ${groupId}.${modulePrefix}.core.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MyApplicationProperties mapped by ${modulePrefix} inside application.yml
 */
@Component
@ConfigurationProperties("${modulePrefix}")
public class MyApplicationProperties {

    private Info info;

    private Cache cache;

    public Info getInfo() {

        return info;
    }

    public void setInfo(Info info) {

        this.info = info;
    }

    public Cache getCache() {

        return cache;
    }

    public void setCache(Cache cache) {

        this.cache = cache;
    }

    /**
     * Cache
     */
    public static class Cache {

        private List<String> names;

        private Timeout timeout;

        public List<String> getNames() {

            return names;
        }

        public void setNames(List<String> names) {

            this.names = names;
        }

        public Timeout getTimeout() {

            return timeout;
        }

        public void setTimeout(Timeout timeout) {

            this.timeout = timeout;
        }

    }

    /**
     * Timeout
     */
    public static class Timeout {

        private int defaultExpiration;

        public int getDefaultExpiration() {

            return defaultExpiration;
        }

        public void setDefaultExpiration(int defaultExpiration) {

            this.defaultExpiration = defaultExpiration;
        }

    }

    /**
     * Info class
     */
    public static class Info {

        private String projectName;

        private String version;

        private String timestamp;

        public String getProjectName() {

            return projectName;
        }

        public void setProjectName(String projectName) {

            this.projectName = projectName;
        }

        public String getVersion() {

            return version;
        }

        public void setVersion(String version) {

            this.version = version;
        }

        public String getTimestamp() {

            return timestamp;
        }

        public void setTimestamp(String timestamp) {

            this.timestamp = timestamp;
        }

    }

}
