package com.softech.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.softech.domain.Order;
import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {

    private final long id;
    private final String description;
    private final long costInCents;
    private final boolean isComplete;

    public OrderResource(Order order) {
        id = order.getId();
        description = order.getDescription();
        costInCents = order.getCostInCents();
        isComplete = order.isComplete();
    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getCostInCents() {
        return costInCents;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
