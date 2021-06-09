import java.util.List;

public class Usuario {
  private List<Guardarropas> guardarropas;
  
  public Usuario(List<Guardarropas> guardarropas) {
    this.guardarropas= guardarropas;
  }
  
  public void agregarGuardarropas(Guardarropas guardarropas){
       this.guardarropas.add(guardarropas);
  }
  
  public void removerGuardarropas(Guardarropas guardarropas){
    this.guardarropas.remove(guardarropas);
}
}
