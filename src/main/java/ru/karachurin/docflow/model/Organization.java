package ru.karachurin.docflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
@Entity
@Table(name = "ORGANIZATION")
public class Organization extends NamedEntity{
    @Column(name = "LEGAL_ADDRESS")
    private String legalAddress;
    @Column(name = "PHYSICAL_ADDRESS")
    private String physicalAddress;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "organization")
    private List<Division> divisions;

    public Organization(){

    }

    public Organization(String legalAddress, String physicalAddress) {
        this.legalAddress = legalAddress;
        this.physicalAddress = physicalAddress;
    }

    public Organization(Integer id, String name, String legalAddress, String physicalAddress) {
        super(id, name);
        this.legalAddress = legalAddress;
        this.physicalAddress = physicalAddress;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }

}
