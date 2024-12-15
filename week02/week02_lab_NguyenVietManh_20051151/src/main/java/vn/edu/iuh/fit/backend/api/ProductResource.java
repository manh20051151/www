package vn.edu.iuh.fit.backend.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.business.ProductBO;
import vn.edu.iuh.fit.backend.entities.Product;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;

@Path("/products")
@RequestScoped
public class ProductResource {

//    @Inject
//    private ProductBO productBO;
    @Inject
    private ProductRepository productRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
        public Product getProductById(@PathParam("id") int id) {
//        Response.ResponseBuilder builder = Response.ok();
//        builder.entity(productRepository.find(id));
        return productRepository.find(id);
    }
//    public Response getAllProducts() {
//        Response.ResponseBuilder builder = Response.ok();
//        builder.entity(productBO.getProducts());
//        return builder.build();
//    }
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Response getProductById(@PathParam("id") long id) {
//        Response.ResponseBuilder builder = Response.ok();
//        builder.entity(productBO.getProductById(id));
//        return builder.build();
//    }
//
//    @POST
//    public Response addProduct(Product product) {
//        productBO.save(product);
//        Response.ResponseBuilder builder = Response.ok();
//        builder.entity(product);
//        return builder.build();
//    }
}
