package web.Model;

public class Car {
    private int id;
    private String name;
    private int year;
    private int count;

    public Car(int id, String name, int year, int count){
        this.id = id;
        this.count = count;
        this.name = name;
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
