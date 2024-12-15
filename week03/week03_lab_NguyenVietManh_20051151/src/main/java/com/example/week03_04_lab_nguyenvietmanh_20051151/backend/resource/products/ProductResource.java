package com.example.week03_04_lab_nguyenvietmanh_20051151.backend.resource.products;

import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.business.ProductLocal;
import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.entities.Product;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;


@Path("/products")
public class ProductResource {
    @EJB
    private ProductLocal productLocal;

    @GET
    public Response getProducts() {
        return Response.ok(productLocal.getProducts()).build();
    }
    @GET
    @Path("/{id}")
    public Response getProduct( @PathParam("id") int id) {
        return Response.ok(productLocal.getProduct(id)).build();
    }

    @POST
    public Response addProduct(Product product) {
        productLocal.add(product);
        return Response.ok(product).build();
    }
}
