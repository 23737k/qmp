import java.util.Map;

public class AccuWeather implements ServicioMetereologico {
 
  private AccuWeatherAPI accuWeather= new AccuWeatherAPI();
  
  public double getTemperature(Ciudad city) {
    Map<String, Object> temperatura= (Map<String, Object>) this.accuWeather.getWeather(Ciudad.BSAS.getNombre()).get(0).get("Temperature");
   return (String) temperatura.get("Unit") == "F" ? CelsiusAFahr(temperatura) : (double) temperatura.get("Value");
  }

  private double CelsiusAFahr(Map<String, Object> temperatura) {
    return ((double)temperatura.get("Value") - 32) * 5/9;
  }

  public String getAlerta(Ciudad city) {
    return "STORM";
  }
 
  public Map<String, Object> getWeather(Ciudad city) {
    return this.accuWeather.getWeather(Ciudad.BSAS.getNombre()).get(0);
  }
  
  
  
}
