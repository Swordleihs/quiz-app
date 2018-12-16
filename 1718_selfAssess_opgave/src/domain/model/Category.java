package domain.model;

import domain.Exceptions.DomainException;


public class Category {
    private String name, description, supercategory;

    public Category(String n, String d, String s) {
        setName(n);
        setDescription(d);
        setSupercategory(s);
    }

    public Category(String n, String d) {
        setName(n);
        setDescription(d);
        setSupercategory("-");
    }

    //=========================================
    //========== GETTERS AND SETTERS ==========
    //=========================================
    public String getName() {
        return name;
    }

    private void setName(String n) {
        if (n == null || n.trim().isEmpty()) {
            throw new DomainException("De naam van de categorie is niet in orde!");
        }
        this.name = n;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String d) {
        if (d == null || d.trim().isEmpty()) {
            throw new DomainException("De beschrijving van de categorie is niet in orde!");
        }
        this.description = d;
    }

    public String getSupercategory() {
        return supercategory;
    }

    private void setSupercategory(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new DomainException("De hoofdcategorie van de categorie is niet in orde!");
        }
        this.supercategory = s;
    }

    @Override
    public String toString(){
        return "Category: name:" + this.getName() + " | description:" + this.getDescription() + " | superCategory:" + this.getSupercategory();
    }
}
