package sogyo.wesley.ipsportdata.app.controllers;
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

import sogyo.wesley.ipsportdata.app.CountDTO;
import sogyo.wesley.ipsportdata.app.InputDTO;

import sogyo.wesley.ipsportdata.domain.IAnalysor;
import sogyo.wesley.ipsportdata.domain.IFactory;
import sogyo.wesley.ipsportdata.persistence.IMock;
import sogyo.wesley.ipsportdata.persistence.IRepository;

@Path("/sogyo/wesley/ipsportdata/app")
public class IPController {
    private IFactory factory;
    private IMock repository;

    public IPController(IFactory factory, IMock repository) {
        this.factory = factory;
        this.repository = repository;
    }

    @Path("/start")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response start(@Context HttpServletRequest request, InputDTO input) {
        HttpSession session = request.getSession(true);
        System.out.println(input.getUsername());
        IAnalysor inputname = factory.createNewAnalysis(input.getUsername());
        String gameId = UUID.randomUUID().toString();
        session.setAttribute("gameId", gameId);
        CountDTO count = new CountDTO();
        count.setCount(5);
        repository.save(gameId, inputname);
        System.out.println(repository.get(gameId));
        //repository.MysqlCon(inputname);
        return Response.status(200).entity(inputname).build();
    }

    @Path("/analyse")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response analyse(@Context HttpServletRequest request, InputDTO input) {
        HttpSession session = request.getSession(false);
        String Id = (String) session.getAttribute("gameId");
        IAnalysor analysor = factory.createNewAnalysis(input.getPower(), input.getLactate_one(), input.getLactate_two());
        //repository.MysqlCon(analysor);
        repository.save(Id, analysor);
        return Response.status(200).entity(analysor).build();
    }
}
//test commit