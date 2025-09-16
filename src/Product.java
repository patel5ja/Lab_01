/**
 * Represents a product with a stable ID, name, description, and cost.
 */
import java.util.Objects;


public class Product
{
    /**
     * @param name product name
     * @param description short description
     * @param ID stable identifier (should not change)
     * @param cost non-negative cost
     */
    private String name = "";
    private String description ="";
    private String ID ="";
    private double cost = 0;

    public Product(String name, String description, String ID, double cost)
    {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }


    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name=" + name +
                ", description=" + description +
                ", cost=" + cost +
                "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /** @return stable product ID */
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /** @return CSV: ID,name,description,cost */
    public String toCSVDataString() {
        return ID + "," + name + "," + description + "," + cost;
    }


    /** @return JSON string for this product */
    public String toJSONDataString() {
        return "{"
                + "\"ID\":\"" + ID + "\","
                + "\"name\":\"" + name + "\","
                + "\"description\":\"" + description + "\","
                + "\"cost\":" + cost
                + "}";
    }

    /** @return XML fragment for this product */

    public String toXMLDataString() {
        return "<Product>"
                + "<ID>" + ID + "</ID>"
                + "<name>" + name + "</name>"
                + "<description>" + description + "</description>"
                + "<cost>" + cost + "</cost>"
                + "</Product>";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0
                && Objects.equals(ID, product.ID)
                && Objects.equals(name, product.name)
                && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, description, cost);
    }

}