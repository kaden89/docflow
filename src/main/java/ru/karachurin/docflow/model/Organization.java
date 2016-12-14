package ru.karachurin.docflow.model;





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
    @OneToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;
    @Transient
    private boolean children = true;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "organization")
    private List<Division> divisions;

    public Organization(){
    }

    public Organization(Integer id, String name, String legalAddress, String physicalAddress, Employee manager) {
        super(id, name);
        this.legalAddress = legalAddress;
        this.physicalAddress = physicalAddress;
        this.manager = manager;
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

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "legalAddress='" + legalAddress + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                ", manager=" + manager +
                '}';
    }
}
