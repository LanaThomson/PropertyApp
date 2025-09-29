package propertyrentaapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropertiesTest {

    private Properties PropertyApp;

    @BeforeEach
    public void setUp() {
        PropertyApp = new Properties();

        PropertyModel sampleOfTheProperty = new PropertyModel();
        sampleOfTheProperty.PropertyId = "101";
        sampleOfTheProperty.PropertyAddress = "10 Main Road, 6001";
        sampleOfTheProperty.PropertyRentalAmount = 3500;
        sampleOfTheProperty.AgentName = "Joe Bloggs";

        PropertyApp.getPropertyList().add(sampleOfTheProperty);
    }

    @Test
    void SearchProperty_ReturnsProperty() {
        PropertyModel result = PropertyApp.searchPropertyById("101");
        assertNotNull(result);
        assertEquals("101", result.PropertyId);
        assertEquals("Joe Bloggs", result.AgentName);
    }

    @Test
    public void SearchProperty_NotFound() {
        PropertyModel result = PropertyApp.searchPropertyById("999");
        assertNull(result);
    }

    @Test
    public void UpdateProperty_ReturnsSuccess() {
        boolean updated = PropertyApp.updatePropertyById("101", "20 Main Road", 4000, "Jane Doe");
        assertTrue(updated);

        PropertyModel result = PropertyApp.searchPropertyById("101");
        assertEquals("20 Main Road", result.PropertyAddress);
        assertEquals(4000, result.PropertyRentalAmount);
        assertEquals("Jane Doe", result.AgentName);
    }//Written with the help of Recordings(2025)

    @Test
    public void DeleteProperty_ReturnSuccess() {
        boolean deleted = PropertyApp.deletePropertyById("101");
        assertTrue(deleted);

        PropertyModel result = PropertyApp.searchPropertyById("101");
        assertNull(result);
    }

    @Test
    public void PropertyAmountValidation_AmountIsValid() {
        double theAmount = PropertyApp.propertyAmountValidationTest(2000);
        assertEquals(2000, theAmount);
    }

    @Test
    public void PropertyAmountValidation_AmountInValid() {
        assertThrows(IllegalArgumentException.class, () -> {
            PropertyApp.propertyAmountValidationTest(1000);
        });//Written with the help of OpenAI(2025)
    }
}