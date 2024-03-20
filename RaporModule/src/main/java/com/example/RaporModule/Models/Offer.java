package com.example.RaporModule.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Offer {
    @Id
    private Integer Id;
    private String offerName;
    private Date startingDate;
    private Date endingDate;
    private int discountRate;
    private boolean isDeleted=false;
}
