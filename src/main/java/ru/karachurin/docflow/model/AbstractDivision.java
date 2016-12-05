package ru.karachurin.docflow.model;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Created by Денис on 03.12.2016.
 */
@MappedSuperclass
public class AbstractDivision extends NamedEntity {
    @OneToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;


    public AbstractDivision(){

    }

    public AbstractDivision(Integer id, String name) {
        super(id, name);
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
