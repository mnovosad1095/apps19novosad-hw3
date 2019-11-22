package ua.edu.ucu;


class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Student)obj).getName()) && 
        surname.equals(((Student)obj).getSurname()) &&
        ((Integer)year).equals(((Student)obj).getYear()) &&
        ((Double)GPA).equals(((Student)obj).getGPA());
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() + 43*surname.hashCode() + year + 7*(int)GPA;
    }

}
