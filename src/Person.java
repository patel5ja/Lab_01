/**
 * Represents a person with identifying information, including a unique ID number,
 * name, details, title and year of birth
 */

import java.util.Objects;

public class Person
{

    /**
     * Creates a Person.
     *
     * @param IDNum unique identifier that should not change
     * @param firstName given name
     * @param lastName last name
     * @param title prefix (e.g., "Mr.", "Dr.")
     * @param YOB year of birth
     */
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    public Person(String IDNum, String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    /** @return the ID number string. */
    public String getIDNum()
    {
        return IDNum;
    }


    @Override
    public String toString() {
        return "Person{" +
                "IDNum= " + IDNum + '\'' +
                ", firstName= " + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                ", YOB=" + YOB +
                "}";

    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    /** @return a CSV record: IDNum,firstName,lastName,title,YOB */
    public String toCSVDataString()
    {
        return IDNum + "," + firstName + "," + lastName + "," + title + "," + YOB;

    }

    /** @return  JSON string for person */
    public String toJSONDataString()
    {
        return "{" +
                "\"IDNum\":\"" + IDNum + "\", " +
                "\"firstName\":\"" + firstName + "\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"title\":\"" + title + "\"," +
                "\"YOB\":" + YOB +
                "}";
    }

    /** @return an XML fragment for person */
    public String toXMLDataString()
    {
        return "<Person>" +
                "<IDNum>" + IDNum + "</IDNum>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<title>" + title + "</title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</Person>";
    }


    /** @return firstName + " " + lastName */
    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    /** @return title + " " + getFullName() */
    public String getFormalName ()
    {
        return title + " " + getFullName();
    }

    /**
     * Calculates age for the current year.
     * @return age as a String
     */
    public String getAge() {
        int currentYear = java.time.Year.now().getValue();
        return String.valueOf(currentYear - YOB);
    }

    /**
     * Calculates age for a specific year.
     * @param year the year to compare against
     * @return age as a String
     */
    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB
                && Objects.equals(IDNum, person.IDNum)
                && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName)
                && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDNum, firstName, lastName, title, YOB);
    }





}