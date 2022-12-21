package org.hmo;

import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/persons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    public List<Person> list() {
        System.out.println("denemeler");
        return personRepository.findOrderedAdi();
        //return personRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response get(String id) {
        Person person = personRepository.findById(new ObjectId(id));
        return Response.ok(person).build();
    }

    @GET
    @Path("/search/{name}")
    public Response search(@PathParam("name") String adi) {
        Person person = personRepository.findByName(adi);
        return person != null ? Response.ok(person).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response create(Person person) throws URISyntaxException {
        System.out.println(person.ad);
        //System.out.println(person.toString());
        //System.out.println(person.id.toString() +" - "+ person.ad);
        personRepository.persist(person);
        return Response.created(new URI("/persons/"+person.id)).build();
    }

}