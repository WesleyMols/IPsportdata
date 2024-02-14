package sogyo.wesley.ipsportdata.app.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sogyo.wesley.ipsportdata.app.InputDTO;

import sogyo.wesley.ipsportdata.domain.IAnalysor;
import sogyo.wesley.ipsportdata.domain.IFactory;
import sogyo.wesley.ipsportdata.persistence.IRepository;

@Path("/sogyo/wesley/ipsportdata/app")
public class IPController {
    private IFactory factory;
    private IRepository repository;

    public IPController(IFactory factory, IRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    @Path("/analyse")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response analyse(@Context HttpServletRequest request, InputDTO input) {
        HttpSession session = request.getSession(true);
        System.out.println(input.getUsername());
        String Id = (String) session.getAttribute("gameId");
        IAnalysor analysor = factory.createNewAnalysis(input.getUsername(), input.getPower(), input.getLactate_one(), input.getLactate_two());
        repository.MysqlSave(analysor);
        List<String> ouput = repository.MysqlGet(analysor);
        analysor.setResultList(ouput);
        return Response.status(200).entity(analysor).build();
    }
}
