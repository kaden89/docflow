package ru.karachurin.docflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
@Entity
@Table(name = "DIVISIONS")
public class Division extends NamedEntity{

    @OneToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;
    @Column(name = "CONTACTS")
    private String contacts;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "parentDivision")
    private List<Division> divisions;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "division")
    private List<Employee> employees;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PARENT_DIVISION_ID")
    private Division parentDivision;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;

    public Division(){

    }

    public Division(String contacts, Division parentDivision, Organization organization) {
        this.contacts = contacts;
        this.parentDivision = parentDivision;
        this.organization = organization;
    }

    public Division(Integer id, String name, String contacts, Division parentDivision, Organization organization) {
        super(id, name);
        this.contacts = contacts;
        this.parentDivision = parentDivision;
        this.organization = organization;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Division getParentDivision() {
        return parentDivision;
    }

    public void setParentDivision(Division parentDivision) {
        this.parentDivision = parentDivision;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
