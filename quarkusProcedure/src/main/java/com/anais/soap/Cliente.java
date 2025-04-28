package com.anais.soap;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.StoredProcedureQuery;

//aca va la creacion del modelo con su metodo de 
// invocar el procedimiento almacenado y retornar la respuesta



@Entity
@NamedStoredProcedureQueries(
    @NamedStoredProcedureQuery(
        name = "sp_consultarTipo",
        procedureName = "sp_consultarTipo",
        parameters = {
            @StoredProcedureParameter(
                name = "clienteId",
                type = int.class,
                mode = ParameterMode.IN

            ),
            @StoredProcedureParameter(
                name = "clienteTipo",
                type = String.class,
                mode = ParameterMode.OUT
            )
        }
    )
)
public class Cliente extends PanacheEntity {


    public String nombre;
    public String correo;
    public int antiguedad;


    public static String consultarTipo(int id) {
        StoredProcedureQuery query = getEntityManager()
            .createNamedStoredProcedureQuery("sp_consultarTipo")
            .setParameter("clienteId", id);
            
            query.execute();
            String tipoCliente = (String) query.getOutputParameterValue("clienteTipo");

            if (tipoCliente == null) {
                return "No existe cliente con ese ID";
            }
            return tipoCliente;


    }
    
}
