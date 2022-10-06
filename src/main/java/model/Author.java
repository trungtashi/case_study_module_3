package model;

import java.time.LocalDate;
import java.util.List;

public class Author {
    private int id;
    private String name;
    private LocalDate yearBorn;
    private String national;
    private String description;
    List<Book> books;

    public Author() {
    }

    public Author(int id, String name, LocalDate yearBorn, String national, String description) {
        this.id = id;
        this.name = name;
        this.yearBorn = yearBorn;
        this.national = national;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(LocalDate yearBorn) {
        this.yearBorn = yearBorn;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearBorn=" + yearBorn +
                ", national='" + national + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
