package student.assignment_4;

public class Property {
    private String propertyName = "";
    private String city = "";
    private double rentAmount = 0;
    private String owner = "";
    private Plot plot;


    public Property(String propName, String cit, double rentAmnt, String own, int X, int Y, int W, int D) {
        propertyName = propName;
        city = cit;
        rentAmount = rentAmnt;
        owner = own;
        this.plot = new Plot(X, Y, W, D);
    }

    public Property(String propName, String cit, double rentAmnt, String own) {
        propertyName = propName;
        city = cit;
        rentAmount = rentAmnt;
        owner = own;
        this.plot = new Plot();
    }

    public Property(Property P) {
        propertyName = P.getPropertyName();
        city = P.getCity();
        rentAmount = P.getRentAmount();
        owner = P.getOwner();
        plot = P.getPlot();
    }
    /*
     * Get property city
     */
    public String getCity() { return city; }

    /*
     * Get property owner
     */
    public String getOwner() { return owner; }

    /*
     * Get property plot
     */
    public Plot getPlot() { return this.plot; }

    /*
     * Get property name
     */
    public String getPropertyName() { return propertyName; }

    /*
     * Get property rent
     */
    public double getRentAmount() { return rentAmount; }

    /*
     * Set property city
     */
    public void setCity(String S) { city = city; }

    /*
     * Set property owner
     */
    public void setOwner(String O) { owner = owner; }

    /*
     * Set property name
     */
    public void setPropertyName(String N) { propertyName = propertyName; }

    /*
     * Set property rent amount
     */
    public void setRentAmount(double R) { rentAmount = rentAmount; }
    @Override
    public String toString() {
        return "Property{" +
                "propertyName='" + propertyName + '\'' +
                ", city='" + city + '\'' +
                ", rentAmount=" + rentAmount +
                ", owner='" + owner + '\'' +
                ", plot=" + plot +
                '}';
    }
}


