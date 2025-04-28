package com.anais.soap;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

    //aca va el servicio, va la interfaz del metodo recibe el dato del cliente

@WebService(name = "ClienteServiceSOAP", serviceName = "ClienteServiceSOAP")
public interface ClienteServiceSOAP {

    @WebMethod
    String recibirId(int id);
    
}
