package cs2263_hw03;

public class Course {
    private String department;
    private int number;
    private String name;
    private int credits;

    /**
     * Simple getter for the course department
     * @return String  The course's department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Simple setter for the course department
     * @param department String  The course's department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Simple getter for the course number
     * @return int  The course's number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Simple setter for the course number
     * @param number int  The course's number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Simple getter for the course name
     * @return String  The name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Simple setter for the course name
     * @param name String  The name of the course
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Simple getter for the course credits
     * @return int  The number of credits the course is worth
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Simple setter for the course credits
     * @param credits int  The number of credits the course is worth
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Constructor for Course
     * @param department String  The department this course is under
     * @param number int  The course number
     * @param name String  The name of the course
     * @param credits int  The number of credits this course is worth
     */
    public Course(String department, int number, String name, int credits) {
        this.department = department;
        this.number = number;
        this.name = name;
        this.credits = credits;
    }

    /**
     * Default constructor
     */
    public Course(){};

    public String toString() {
        return new String(this.department + ": " + this.number + ": " + this.name + ": " + credits);
    }
}
