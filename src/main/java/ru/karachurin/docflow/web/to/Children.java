package ru.karachurin.docflow.web.to;

/**
 * Created by Денис on 11.12.2016.
 */
public class Children {
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
