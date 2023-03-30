package implementations;

import interfaces.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import models.persona;

import java.util.List;

@Stateless
public class personaServicioImp implements
        personaServicio {
    @Inject
    private personaDao PersonaDAO;
    @Override
    public List<persona> consultaGeneral() {
        return PersonaDAO.buscarTodos();
    }
    @Override
    public persona consulta_por_id(persona Persona) {
        return PersonaDAO.buscar_por_id(Persona);
    }
    @Override
    public persona consulta_por_apellido(persona Persona) {
        return PersonaDAO.consulta_por_apellido(Persona);
    }
    @Override
    public void registrarPersona(persona Persona) {
        PersonaDAO.agregarPersona(Persona);
    }
    @Override
    public void modificarPersona(persona Persona) {
        PersonaDAO.updatePersona(Persona);
    }
    @Override
    public void eliminarPersona(persona Persona) {
        PersonaDAO.eliminarPersona(Persona);
    }
}