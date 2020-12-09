import java.util.*;

public class Configuration {

	//Long method(Extract)
	//Encapsulate fields

	private int interval;

	private int duration;

	private int departure;

	public void load(Properties props) throws ConfigurationException {

		interval(props);

		duration(props);

		departure(props);
	}

	private void departure(Properties props) throws ConfigurationException {
		String valueString;
		int value;
		valueString = props.getProperty("departure");
		if (valueString == null) {
			throw new ConfigurationException("departure offset");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("departure > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("departure % interval");
		}
		departure = value;
	}

	private void duration(Properties props) throws ConfigurationException {
		String valueString;
		int value;
		valueString = props.getProperty("duration");
		if (valueString == null) {
			throw new ConfigurationException("duration");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("duration > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("duration % interval");
		}
		duration = value;
	}

	private void interval(Properties props) throws ConfigurationException {
		String valueString;
		int value;
		valueString = props.getProperty("interval");
		if (valueString == null) {
			throw new ConfigurationException("monitor interval");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("monitor interval > 0");
		}
		interval = value;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDeparture() {
		return departure;
	}

	public void setDeparture(int departure) {
		this.departure = departure;
	}
}
