package student.assignment_4;

public class ManagementCompany {
    // Class Configuration
    private int MAX_PROPERTY = 5;
    private int MGMT_WIDTH = 10;
    private int MGMT_DEPTH = 10;

    // Class Variables
    private String Name = "";
    private String TaxID = "";
    private double ManagementFee = 0.00;
    private Plot ManagementPlot;
    private Property Properties[] = new Property[MAX_PROPERTY];
    private int currentPropertyIndex = -1; // Starts at 0

    /*
     * Default/Empty constructor
     * Returns nothing and defaults all values
     */
    public ManagementCompany() {
        ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    /*
     * Basic constructor
     * @param String Name
     * @param String Tax ID #
     * @param Double Management Fee
     */
    public ManagementCompany(String n, String tid, double mfee) {
        Name = n;
        TaxID = tid;
        ManagementFee = mfee;
        ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    /*
     * Basic constructor
     * @param String Name
     * @param String Tax ID #
     * @param Double Management Fee
     * @param Property X
     * @param Property Y
     * @param Property Width
     * @param Property Depth
     */
    public ManagementCompany(String n, String tid, double mfee, int x, int y, int w, int d) {
        Name = n;
        TaxID = tid;
        ManagementFee = mfee;
        ManagementPlot = new Plot(x, y, w, d);
    }

    /*
     * Returns the max amount of properties allowed
     * @return Int MAX_PROPERTY
     */
    public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }

    /*
     * Returns the management property plot
     * @return Plot plot
     */
    public Plot getPlot() { return ManagementPlot; }

    /*
     * Returns the management company name
     * @return String name
     */
    public String getName() { return Name; }

    /*
     * Returns the total rent due
     * @return Double rent total
     */
    public double totalRent() {
        // Variables
        double total = 0;

        // Loop
        for (int i = 0; i < Properties.length; i++) {
            // Checks
            if (Properties[i] == null) { continue; }

            // Variables
            Property p = Properties[i];
            total += p.getRentAmount();
        }

        // Return
        return (this.Properties.length > 0 ? total : 0.00);
    }

    /*
     * Returns the highest rent property
     */
    public String maxRentPropInfo() {
        // Variables
        double highest = 0;
        String stringified = "";

        // Loop
        for (int i = 0; i < Properties.length; i++) {
            // Variables
            Property p = Properties[i];

            if (p == null) { continue; }
            if (p.getRentAmount() > highest) {
                highest = p.getRentAmount();
                stringified = p.toString();
            }
        }


        // Return
        return (highest > 0 ? stringified : "");
    }

    /*
     * Returns the stringified version of Properties object
     */
    public String toString() {
        // Variables
        String r = "";

        // Append
        r += "List of properties for " + getName() + ", TaxID: " + this.TaxID;

        // Loop
        for (int i = 0; i < Properties.length; i++) {
            // Checks
            if (Properties[i] == null) { continue; }

            // Variables
            r += "\n" + Properties[i].toString();
        }

        // Append
        r += "\ntotal management Fee: " + (totalRent() * (ManagementFee * 0.01));

        // Return
        return r;
    }

    /*
     * Add property (Property)
     */
    public int addProperty(Property P) {
        // Variables
        int index = currentPropertyIndex;
        int newIndex = currentPropertyIndex + 1;

        // Checks
        if (newIndex >= MAX_PROPERTY) { return -1; }

        // Variables
        Properties [newIndex] = new Property(P);

        // Default
        currentPropertyIndex = newIndex;
        return newIndex;
    }

    /*
     * Add property (Name, City, Rent, Owner)
     */
    public int addProperty(String n, String c, double r, String o) {
        // Variables
        int index = currentPropertyIndex;
        int newIndex = currentPropertyIndex + 1;

        // Checks
        if (newIndex >= MAX_PROPERTY) { return -1; }

        // Variables
        Properties[newIndex] = new Property(n, c, r, o);

        // Default
        currentPropertyIndex = newIndex;
        return newIndex;
    }

    /*
     * Add property (Name, City, Rent, Owner, X, Y, Width, Depth)
     */
    public int addProperty(String n, String c, double r, String o, int x, int y, int w, int d) {
        // Variables
        int index = currentPropertyIndex;
        int newIndex = currentPropertyIndex + 1;
        Plot tempPlot = new Plot(x, y, w, d);

        // Checks
        if (newIndex >= MAX_PROPERTY) { return -1; }
        if (ManagementPlot.encompasses(tempPlot) == false) { return -3; }
        if (index >= 0) {
            for (int i = 0; i < this.Properties.length; i++) {
                // Checks
                if (Properties[i] == null) { continue; }
                if (Properties[i].getPlot().overlaps(tempPlot) == true) { return -4; }
            }
        }

        // Variables
        Properties[newIndex] = new Property(n, c, r, o, x, y, w, d);

        // Default
        currentPropertyIndex = newIndex;
        return newIndex;
    }



}