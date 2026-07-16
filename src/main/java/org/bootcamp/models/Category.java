package org.bootcamp.models;


import org.bootcamp.enums.Type;


public class Category {
    private int id;
    private String name;
    private Type type;

    public Category(int id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
