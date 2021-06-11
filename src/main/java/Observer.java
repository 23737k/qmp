import java.util.List;
import java.util.Map;

public interface Observer {

  public void notificarTiempo(Object o);
  public void notificarAlerta(String alerta);
}




class UsuarioObserver implements Observer{
  private List<Usuario> usuarios;
  
  public void notificarTiempo(Object obj) {
  }

  public void notificarAlerta(String obj) {
    this.usuarios.forEach(user -> user.setAlertaMetereologica((String)obj));
  }
}



class SugerenciaDiariaObserver implements Observer{
  private List<Usuario> usuarios;

  public void notificarTiempo(Object obj) {
    Atuendo sugerencia= new GeneradorDeSugerencias().generarSugerenciaDiaria((Map<String,Object>)obj);
    this.usuarios.forEach(user -> user.setSugerenciaDiaria(sugerencia));
  }

  public void notificarAlerta(String obj) {
    // TODO Auto-generated method stub
    
  }
}

class NotificationObserver implements Observer{
  private NotificationService service;
  
  public NotificationObserver(NotificationService service) {
    this.service= service;
  }
  
  public void notificarTiempo(Object o) {
    // TODO Auto-generated method stub
    
  }
  
  public void notificarAlerta(String alerta) {
    if(alerta=="GRANIZO") {
      this.service.notify("NO SALGAS DEL AUTO");
    }
    
    if(alerta=="LLUVIA") {
      this.service.notify("LLEVA PARAGUAS");
    }
    
  }
  
    
}



class MailSenderObserver implements Observer{
  private List<Usuario> usuarios;
  private MailSender mailSender;
  private String mensaje= "NUEVA ALERTA METEREOLOGICA";
  
  public MailSenderObserver(List<Usuario> usuarios, MailSender mailSender) {
    this.usuarios = usuarios;
    this.mailSender = mailSender;
  }
  
  public void notificarTiempo(Object o) {
  }

 
  public void notificarAlerta(String alerta) {
    this.usuarios.forEach(user -> mailSender.send(user.getAdress(), this.mensaje + alerta));
  }
  
}