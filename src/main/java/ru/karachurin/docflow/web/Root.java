package ru.karachurin.docflow.web;

import ru.karachurin.docflow.model.Organization;
import ru.karachurin.docflow.service.OrganizationService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Денис on 09.12.2016.
 */
public class Root<T> {

    private String name;
    private String id;
    private List<T> children;
    public Root() {
    }

    public Root(String name, String id, List<T> children) {
        this.name = name;
        this.id = id;
        this.children = children;
    }

    public Root(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
