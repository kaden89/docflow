package ru.karachurin.docflow.model;

import org.springframework.format.annotation.DateTimeFormat;
import ru.karachurin.docflow.util.json.LocalDateTimeAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;


import static ru.karachurin.docflow.model.State.*;

/**
 * Created by Денис on 02.12.2016.
 */
@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity{
    @Column(name = "SUBJECT")
    private String subject;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "DEADLINE")
    private LocalDateTime deadline;
    @Column(name = "CONTROLLED")
    private boolean isControlled;
    @Column(name = "EXECUTED")
    private boolean isExecuted;
    @Column(name = "TEXT")
    private String text;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    private Employee author;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EXECUTOR_ID", nullable = false)
    private Employee executor;
    @Enumerated(EnumType.STRING)
    private State state;
    @Transient
    private String name;

    public Order(){

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

    public void nextStep(){
        switch (getState())
        {
            case PREPARE:
                setState(EXECUTION);
                break;
            case EXECUTION:
                setState(CONTROL);
                break;
            case CONTROL:
                if (isControlled())
                    setState(RECEPTION);
                else
                    setState(REWORK);
                break;
            case REWORK:
                setState(EXECUTION);
                break;
            case RECEPTION:
                setExecuted(true);
                setState(END);
                break;
        }


    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return subject;
    }

    public void setName(String name) {
        this.name = name;
    }
}
