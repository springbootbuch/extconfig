package de.springbootbuch.extconfig;

import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("example")
public class ExampleProperties {
    public static class Server {
        /** The name of the server. */
        private String name;

        /** The URL of the server. */
        private URL url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public URL getUrl() {
            return url;
        }

        public void setUrl(URL url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Server{" + "name=" + name + ", url=" + url + '}';
        }
    }

    public static enum Environment {
        dev, prod, cloud
    }

    /** The greeting used. */
    @NotNull
    @Size(min = 1)
    private String greeting;

    /** Some arbitrary interval. */
    @Min(10)
    private Integer interval;

    /** An example of maps. */
    private Map<Environment, Map<String, Object>> environments;

    /** The list of servers. */
    private List<Server> servers;

    /** A precision. */
    private Double precision;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Map<Environment, Map<String, Object>> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<Environment, Map<String, Object>> environments) {
        this.environments = environments;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        final StringBuilder rv = new StringBuilder();
        rv
                .append("ExampleProperties{")
                .append("\n\tgreeting=").append(greeting)
                .append(",\n\tinterval=").append(interval)
                .append(",\n\tprecision=").append(precision)
                .append(",\n\tservers=").append(servers)
                .append(",\n\tenvironments=").append(environments)
                .append("\n}");
        return rv.toString();
    }
}