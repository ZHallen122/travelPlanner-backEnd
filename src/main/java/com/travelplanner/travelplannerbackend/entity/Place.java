package com.travelplanner.travelplannerbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Place")
public class Place {

  //!!!!!!!!!!!!!!! Not sure yet dont do this table.
    @Id
    private String place;

}
