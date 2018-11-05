package com.softech.resource;

import com.softech.domain.Order;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class OrderResourceAssembler extends ResourceAssembler<Order, OrderResource>{

    @Autowired
    protected EntityLinks entityLinks;

    private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";

    @Override
    public OrderResource toResource(Order order) {

        OrderResource resource = new OrderResource(order);

        final Link seftLink = entityLinks.linkToSingleResource(order);

        resource.add(seftLink.withSelfRel());
        resource.add(seftLink.withRel(UPDATE_REL));
        resource.add(seftLink.withRel(DELETE_REL));


        return resource;
    }
}
