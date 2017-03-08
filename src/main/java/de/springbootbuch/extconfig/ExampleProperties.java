package de.springbootbuch.extconfig;

import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties("example")
@Validated
public class ExampleProperties {

	public static class Server {

		/** The name of the server. */
		private String name;

		/** The URL of the server. */
		private URL url;
		
		// Getter und Setter weggelassen

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
	private String theGreeting;

	/** Some arbitrary interval. */
	@Min(10)
	private Integer interval;

	/** An example of maps. */
	private Map<Environment, Map<String, Object>> 
		environments;

	/** The list of servers. */
	private List<Server> servers;

	/** A precision. */
	private Double precision;

	// Getter und Setter weggelassen
	// Sie müssen aber für die Konfiguration
	// vorhanden sein!
	
	public String getTheGreeting() {
		return theGreeting;
	}

	public void setTheGreeting(String theGreeting) {
		this.theGreeting = theGreeting;
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
			.append("\n\ttheGreeting=").append(theGreeting)
			.append(",\n\tinterval=").append(interval)
			.append(",\n\tprecision=").append(precision)
			.append(",\n\tservers=").append(servers)
			.append(",\n\tenvironments=").append(environments)
			.append("\n}");
		return rv.toString();
	}
}
