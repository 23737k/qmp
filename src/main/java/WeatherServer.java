import java.util.List;
import java.util.Map;

public interface WeatherServer {
	public List<Map<String, Object>> getWeather(String ciudad);
}
