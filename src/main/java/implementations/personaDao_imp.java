package implementations;

import jakarta.ejb.Stateless;
import models.persona;
import interfaces.personaDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class personaDAO_imp implements personaDao{
    @PersistenceContext(unitName = "PERSONA_PU")
    EntityManager em;
    @Override
    public List<persona> buscarTodos() {
        return em.createNamedQuery("Contacto.buscarTodos").getResultList();
    }

    @Override
    public persona buscar_por_id(persona Persona) {
        return em.find(persona.class, Persona.getId());
    }

    @Override
    public persona consulta_por_apellido(persona Persona) {
        Query query = em.createQuery("from persona p where apellido=:apellido");
        query.setParameter("apellido", Persona.getApellido());
        return (persona) query.getSingleResult();
    }

    @Override
    public void agregarPersona(persona Persona) {
        em.persist(Persona);
    }

    @Override
    public void updatePersona(persona Persona) {
        em.merge(Persona);
    }

    @Override
    public void eliminarPersona(persona Persona) {
        em.remove(Persona);
    }
}
