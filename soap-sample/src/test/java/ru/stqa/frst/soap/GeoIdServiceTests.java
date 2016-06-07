package ru.stqa.frst.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by user on 07.06.2016.
 */
@Test
public class GeoIdServiceTests {
  public void testMyIP() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("93.84.56.154");
  assertEquals(geoIP.getCountryCode(), "BLR");
  }
  @Test

    public void testInvalidIP() {
      GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("93.84.56.xxx");
      assertEquals(geoIP.getCountryCode(), "BLR");
    }
}