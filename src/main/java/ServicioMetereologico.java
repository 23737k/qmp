import java.util.Map;

public interface ServicioMetereologico {
	public double getTemperature(Ciudad ciudad);
	public String getAlerta(Ciudad ciudad);
	public Map<String, Object> getWeather(Ciudad city);
}
