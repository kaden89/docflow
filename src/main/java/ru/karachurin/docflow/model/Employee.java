package ru.karachurin.docflow.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee extends BaseEntity {
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "POSITION")
    private String position;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DIVISION_ID", nullable = false)
    private Division division;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "executor")
    private List<Order> ordersToExecute;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "author")
    private List<Order> givenOrders;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String middleName, String position, Division division) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.division = division;
    }

    public Employee(Integer id, String firstName, String lastName, String middleName, String position, Division division) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.division = division;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Order> getOrdersToExecute() {
        return ordersToExecute;
    }

    public void setOrdersToExecute(List<Order> ordersToExecute) {
        this.ordersToExecute = ordersToExecute;
    }

    public List<Order> getGivenOrders() {
        return givenOrders;
    }

    public void setGivenOrders(List<Order> givenOrders) {
        this.givenOrders = givenOrders;
    }
}
