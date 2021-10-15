
public class rutasRest {

  
  /*
   * Como usuarie de QueMePongo quiero ver todas las prendas que tengo en mi guardarropas 
   * desde el navegador para poder administrarlas
   * 
   */
  
  GET /usuarios/{id}/guardarropas/{id}/prendas
  
  
 Posibles códigos de respuesta: 
   200 OK
   404 NOT FOUND
   500 INTERNAL SERVER ERROR
  
   {
     "id": "1",
     "tipo": "TipoPrenda.ZAPATO",
     "material": "Material.CUERO",
     "colorPrimario": "colorPrimario",
     "colorSecundario": "colorSecundario",
     "trama": "Trama.LUNARES"
    }
   
   
   Body respuesta
   {
    "id": "1",
    "tipo": "TipoPrenda.ZAPATO",
    "material": "Material.CUERO",
    "colorPrimario": "colorPrimario",
    "colorSecundario": "colorSecundario",
    "trama": "Trama.LUNARES"
   }
  
  {
    "id": "2",
    "tipo": "TipoPrenda.PANTALON",
    "material": "Material.ALGODON",
    "colorPrimario": "colorPrimario",
    "colorSecundario": "colorSecundario",
    "trama": "Trama.RAYAS"
   }
  
   
  
  /*
   * Como usuario de QueMePongo, quiero crear una prenda desde el navegador
   */
  
  POST /usuarios/{id}/prendas
  
  Posibles códigos de respuesta: 
    200 OK
    201 Created
    500 INTERNAL SERVER ERROR
 
    Body respuesta
    {
      "id": "1",
      "tipo": "TipoPrenda.ZAPATO",
      "material": "Material.CUERO",
      "colorPrimario": "colorPrimario",
      "colorSecundario": "colorSecundario",
      "trama": "Trama.LUNARES"
     }
  
  /*
   * Como usuarie de QueMePongo quiero ver una prenda en particular que tengo en mi guardarropas
   *  para poder editarla
   */
  
  GET /usuarios/{id}/prendas/{id}
  
  Posibles códigos de respuesta: 
    200 OK
    404 NOT FOUND
    500 INTERNAL SERVER ERROR
  
  
    Body respuesta
    {
      "id": "1",
      "tipo": "TipoPrenda.ZAPATO",
      "material": "Material.CUERO",
      "colorPrimario": "colorPrimario",
      "colorSecundario": "colorSecundario",
      "trama": "Trama.LUNARES"
     }
  /*
   * Como usuarie de QueMePongo, quiero poder eliminar una prenda de mi guardarropas
   */
  
  DELETE /usuarios/{id}/guardarropas{id}/prendas/{id}
  
  
  Posibles códigos de respuesta: 
    200 OK
    404 NOT FOUND
    500 INTERNAL SERVER ERROR
  
  /*
   * Como usuarie de QueMePongo, quiero poder ver mis eventos para administrarlos
   */
  
  GET  /usuarios/{id}/eventos
  
  Posibles códigos de respuesta: 
    200 OK
    404 NOT FOUND
    500 INTERNAL SERVER ERROR
  
    
    Body respuesta
    {
      "id": "1",
      "tipo": "TipoDeEvento.REUNION",
      "fechaInicio": "2021-12-03T01:00:00-03:00",
      "fechaFin": "2021-12-03T01:00:00-03:00"
     }
    
  /*
   * Como usuarie de QueMePongo, quiero poder abrir las sugerencias de prendas para un evento 
      en mi navegador
   */
  GET /usuarios/{id}/eventos/{id}/sugerencias
  
  Posibles códigos de respuesta: 
    200 OK
    404 NOT FOUND
    500 INTERNAL SERVER ERROR
  
    
    Body respuesta
    {
      "id": "1",
      "tipo": "TipoPrenda.ZAPATO",
      "material": "Material.CUERO",
      "colorPrimario": "colorPrimario",
      "colorSecundario": "colorSecundario",
      "trama": "Trama.LUNARES"
     }
  
  {
    "id": "2",
    "tipo": "TipoPrenda.PANTALON",
    "material": "Material.ALGODON",
    "colorPrimario": "colorPrimario",
    "colorSecundario": "colorSecundario",
    "trama": "Trama.RAYAS"
   }
    
  
  
  
}


