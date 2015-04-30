/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author jcamilo.rivera
 */
@Path("/json/metallica")
public class JSONService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of JSONService
     */
    public JSONService() {
    }

    /**
     * Retrieves representation of an instance of com.udea.JSONService
     * @return an instance of java.lang.String
     */
     /**
     * PUT method for updating or creating an instance of JSONService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Pojo getTrackInJSON(){
        Pojo track = new Pojo();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");
        return track;
    }
    
    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Pojo track){
       String result = "track saved: "+track; 
       return Response.status(201).entity(result).build();
    }
}
