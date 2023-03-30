package servlets;

import com.google.gson.Gson;
import interfaces.personaServicio;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.persona;
import utils.ServletUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "persona", urlPatterns = {"/persona"})
public class personaServlet extends HttpServlet {
        @Inject
        personaServicio PersonaServicio;

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                List<persona> personas = PersonaServicio.consultaGeneral();
                String json = new Gson().toJson(personas);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                Gson gson = new Gson();
                String json = ServletUtils.getRequestBody(request);
                persona Persona = gson.fromJson(json, persona.class);
                PersonaServicio.registrarPersona(Persona);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(HttpServletResponse.SC_CREATED);
        }

        protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                Gson gson = new Gson();
                String json = ServletUtils.getRequestBody(request);
                persona Persona = gson.fromJson(json, persona.class);
                PersonaServicio.modificarPersona(Persona);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(HttpServletResponse.SC_OK);
        }

        protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                try {
                        Gson gson = new Gson();
                        String json = ServletUtils.getRequestBody(request);
                        persona Persona = gson.fromJson(json, persona.class);
                        PersonaServicio.eliminarPersona(Persona);
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.setStatus(HttpServletResponse.SC_OK);
                } catch (Exception e) {
                        // Log the exception for debugging purposes
                        e.printStackTrace();
                        // Set an error response code
                        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
        }

}