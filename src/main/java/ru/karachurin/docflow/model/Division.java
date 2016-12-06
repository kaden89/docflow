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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;

    public Division(){

    }

    public Division(Integer id, String name, Employee manager, String contacts, Organization organization) {
        super(id, name);
        this.manager = manager;
        this.contacts = contacts;
        this.organization = organization;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Division{" +
                "manager=" + manager +
                ", contacts='" + contacts + '\'' +
                ", organization=" + organization +
                '}';
    }
}
