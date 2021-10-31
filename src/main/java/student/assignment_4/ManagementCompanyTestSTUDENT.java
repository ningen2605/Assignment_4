package student.assignment_4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
    // Variables
    ManagementCompany mgmt;

    @Before
    public void setUp() throws Exception {
        // Variables
        mgmt = new ManagementCompany("MGMT Company 1", "The real company", 6);

        // Add properties
        mgmt.addProperty("Property 1", "Potomac", 600, "JC Tucker0", 2, 1, 2, 2);
        mgmt.addProperty("Property 2", "Rockville", 700, "JC Tucker1", 4, 1, 2, 2);
        mgmt.addProperty("Property 3", "Tysons Corner", 800, "JC Tucker2", 6, 1, 2, 2);
    }

    @After
    public void tearDown() {
        mgmt = null;
    }

    @Test
    public void testAddPropertyDefaultPlot() {
        assertEquals(mgmt.addProperty("Property 1", "North Bethesda", 888, "JC Tucker3"), 3);
        assertEquals(mgmt.addProperty("Property 1", "North Bethesda", 999, "JC Tucker4", 2, 1, 2, 2), 4);
        assertEquals(mgmt.addProperty("Property 1", "North Bethesda", 111, "JC Tucker5"), -1);
    }

    @Test
    public void testMaxPropertyRent() {
        String info = mgmt.maxRentPropInfo();
        assertTrue(info.contains("800"));
    }

    @Test
    public void testTotalRent() {
        assertEquals(mgmt.totalRent(), 2100, 0);
    }

}