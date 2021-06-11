import java.util.List;

public class Usuario{
  private List<Guardarropas> guardarropas;
  private String alertaMetereologica;
  private Atuendo sugerenciaDiaria;
  private String currentAdress;
  
  public Usuario(List<Guardarropas> guardarropas) {
    this.guardarropas= guardarropas;
  }
  
  public void agregarGuardarropas(Guardarropas guardarropas){
       this.guardarropas.add(guardarropas);
  }
  
  public void removerGuardarropas(Guardarropas guardarropas){
    this.guardarropas.remove(guardarropas);
  }
  
  public void setSugerenciaDiaria(Atuendo sugerenciaDiaria) {
    this.sugerenciaDiaria = sugerenciaDiaria;
  }

  public Atuendo getSugerenciaDiaria() {
    return this.sugerenciaDiaria;
  }
  
  public String getAlertaMetereologica() {
    return this.alertaMetereologica;
  }
  
 public void setAlertaMetereologica(String nuevaAlerta) {
    this.alertaMetereologica= nuevaAlerta;
  }

public String getAdress() {
  return this.currentAdress;
}

}
