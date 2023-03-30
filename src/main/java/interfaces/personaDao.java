package repositories;

import models.persona;
import java.util.List;

public interface personaDao {
    public List<persona> buscarTodos();
    public persona buscar_por_id(persona Persona);
    public persona consulta_por_apellido(persona Persona);
    public void agregarPersona(persona Persona);
    public void updatePersona(persona Persona);
    public void eliminarPersona(persona Persona);

}
