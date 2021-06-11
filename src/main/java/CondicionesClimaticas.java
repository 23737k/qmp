import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CondicionesClimaticas {
  private ServicioMetereologico servicio;
  private List<Observer> observers;
  private List<Map<String,LocalDate>> alertasHistoricas;
  
  public CondicionesClimaticas(ServicioMetereologico servicio, List<Observer> observers) {
    this.servicio= servicio;
    this.observers= observers;
    this.alertasHistoricas= new ArrayList<Map<String,LocalDate>>();
  }
  
  
  public List<Observer> getObservers() {
    return observers;
  }

  public void agregarObservers(Observer observer) {
    this.observers.add(observer);
  }
  
  
  public List<Map<String,LocalDate>> getAlertashistoricas(){
    return this.alertasHistoricas;
  }
  
  public void getAlertaMetereologica(Ciudad city) {
    String alerta = this.servicio.getAlerta(city);
    this.observers.forEach(obs -> obs.notificarTiempo(alerta));
    this.alertasHistoricas.add(new HashMap<String,LocalDate>().put(alerta, LocalDate.now()));
  }
  
  public void getTiempo(Ciudad city) {
    Map<String, Object> tiempo = this.servicio.getWeather(city);
    this.observers.forEach(obs -> obs.notificarTiempo(tiempo));
  }
  
}
