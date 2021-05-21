import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guardarropas {
	
	public Guardarropas(List<Prenda> prendasDisponibles, WeatherChecker checker) {
		this.prendasDisponibles = prendasDisponibles;
		this.checker = checker;
	}

	private List <Prenda> prendasDisponibles;
	private WeatherChecker checker;

	public List<Atuendo> Sugerencias(){
		return new GeneradorDeSugerencias().generarSugerencias(checker.prendasAptas(this.prendasDisponibles));  
	}
	
}




class WeatherChecker{
	
	
	public WeatherChecker(Ciudad ciudad) {
		this.ciudad= ciudad;
		this.condicionesClimaticasActuales= server.getWeather(ciudad.getNombre());
	}
	
	private Ciudad ciudad;
	private List<Map<String, Object>> condicionesClimaticasActuales;
	private WeatherServer server= new AccuWeatherAPI();
	
	public List<Prenda> prendasAptas(List<Prenda> prendas) {
		return prendas.stream().filter(prenda -> esApta(prenda)).collect(Collectors.toList());
	}

	private Boolean esApta(Prenda prenda) {
		return prenda.tipo.getTempMax()>= temperaturaActual();
		//acá se pueden agregar más criterios, como por ejemplo: estaLloviendo() 
	}

	
	private Integer temperaturaActual() {
		actualizarTiempo();
		return (Integer) condicionesClimaticasActuales.get(0).get("Temperature");
	}
	
	
	public void actualizarTiempo(){
		 LocalDateTime now = LocalDateTime.now();
		 LocalDateTime before = (LocalDateTime) condicionesClimaticasActuales.get(0).get("DateTime");
		 Duration duration= Duration.between(now, before);
		 long horas= Math.abs(duration.getSeconds()) /3600;
		 if (horas>= 12) {
			 this.condicionesClimaticasActuales= server.getWeather(this.ciudad.getNombre()); 
		 }			
	 }
	
	
}
