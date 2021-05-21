import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guardarropas {
	
	public Guardarropas(List<Prenda> prendasDisponibles, Ciudad ciudad) {
		this.prendasDisponibles = prendasDisponibles;
		this.ciudad = ciudad;
		this.condicionesClimaticasActuales = server.getWeather(this.ciudad.getNombre());
		}
	
	private List <Prenda> prendasDisponibles;
	private Ciudad ciudad;
	private List<Map<String, Object>> condicionesClimaticasActuales;
	private WeatherServer server= new AccuWeatherAPI();

	public List<Atuendo> Sugerencias(){
		return new GeneradorDeSugerencias().generarSugerencias(prendasAptas(this.prendasDisponibles));  
	}
	
	 public void actualizarTiempo(){
		 LocalDateTime now = LocalDateTime.now();
		 LocalDateTime before = (LocalDateTime) condicionesClimaticasActuales.get(0).get("DateTime");
		 Duration duration= Duration.between(now, before);
		 long horas= Math.abs(duration.getSeconds()) /3600;
		 if (horas>= 12) {
			 this.server= new AccuWeatherAPI(); 
		 }			
	 }
	
	
	
	private List<Prenda> prendasAptas(List<Prenda> prendas) {
		return prendas.stream().filter(prenda -> esApta(prenda)).collect(Collectors.toList());
	}


	private Boolean esApta(Prenda prenda) {
		return prenda.tipo.getTempMax()>= temperaturaActual();
	}

	private Integer temperaturaActual() {
		actualizarTiempo();
		return (Integer) condicionesClimaticasActuales.get(0).get("Temperature");
	}
	
}
