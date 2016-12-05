package ru.karachurin.docflow.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Денис on 02.12.2016.
 */
@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity{
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "DEADLINE")
    private LocalDateTime deadline;
    @Column(name = "CONTROLLED")
    private boolean isControlled;
    @Column(name = "EXECUTED")
    private boolean isExecuted;
    @Column(name = "TEXT")
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    private Employee author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXECUTOR_ID", nullable = false)
    private Employee executor;

    public Order(){

    }
    public Order(String subject, LocalDateTime deadline, boolean isControlled, boolean isExecuted, String text, Employee author, Employee executor) {
        this.subject = subject;
        this.deadline = deadline;
        this.isControlled = isControlled;
        this.isExecuted = isExecuted;
        this.text = text;
        this.author = author;
        this.executor = executor;
    }

    public Order(Integer id, String subject, LocalDateTime deadline, boolean isControlled, boolean isExecuted, String text, Employee author, Employee executor) {
        super(id);
        this.subject = subject;
        this.deadline = deadline;
        this.isControlled = isControlled;
        this.isExecuted = isExecuted;
        this.text = text;
        this.author = author;
        this.executor = executor;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isControlled() {
        return isControlled;
    }

    public void setControlled(boolean controlled) {
        isControlled = controlled;
    }

    public boolean isExecuted() {
        return isExecuted;
    }

    public void setExecuted(boolean executed) {
        isExecuted = executed;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public Employee getExecutor() {
        return executor;
    }

    public void setExecutor(Employee executor) {
        this.executor = executor;
    }
}
