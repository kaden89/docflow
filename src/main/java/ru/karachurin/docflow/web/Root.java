package ru.karachurin.docflow.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Денис on 09.12.2016.
 */
public class Root {
    private String name = "Organizations";
    private String id = "root";
    private List<Children> children = Arrays.asList(new Children("Divisions", "divisionsId", true), new Children("Employees", "employeesId", true));
    public Root() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private class Children{
        private String name;
        private String id;
        private boolean children;

        public Children(String name, String id, boolean children) {
            this.name = name;
            this.id = id;
            this.children = children;
        }

        public Children() {
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

        public boolean isChildren() {
            return children;
        }

        public void setChildren(boolean children) {
            this.children = children;
        }
    }
}
