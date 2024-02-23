package sogyo.wesley.ipsportdata.app.controllers;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sogyo.wesley.ipsportdata.app.InputDTO;

import sogyo.wesley.ipsportdata.domain.IAnalyser;
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
        IAnalyser analyser = factory.createNewAnalysis(input.getUsername(), input.getPower(), input.getLactate_one(), input.getLactate_two(), input.getHeartrate(), input.getWeigth(), input.getSize());
        repository.MysqlSave(analyser);
        List<String> ouput = repository.MysqlGet(analyser);
        analyser.setPowerInputList(ouput);
        return Response.status(200).entity(analyser).build();
    }
}
