package services;

import models.persona;
import java.util.List;

public interface personaServicio {

    public List<persona> consultaGeneral();
    public persona consulta_por_id(persona Persona);
    public persona consulta_por_apellido(persona Persona);
    public void registrarPersona(persona Persona);
    public void modificarPersona(persona Persona);
    public void eliminarPersona(persona Persona);
}
