package com.anais.soap;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

//aca va la implementacion del metodo que recibe el dato del cliente, 
// llama al metodo de cliente que realiza 
//el procedimiento y enviar la respuesta como resultado del web service


@WebService(serviceName = "ClienteServiceSOAP")
public class ClienteServiceImpl implements ClienteServiceSOAP {

    @WebMethod
    @Override
    public String recibirId(int id) {
        return Cliente.consultarTipo(id);
        
    }
    
}
