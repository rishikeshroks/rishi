package com.hexaware.FTP107.factory;
import com.hexaware.FTP107.model.Vendor;
import com.hexaware.FTP107.persistence.VendorDAO;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Vendor.
 */
@RunWith(JMockit.class)
public class VendorFactoryTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {
  }
   /**
   * setup method.
   * @param vdao vendor login.
   */
  @Test
public final void showVendorLoginTest(@Mocked final VendorDAO vdao) {
    final Vendor ven = new Vendor(10, "Anne", "rose1", "rose1", "art@999", "9047776706", "vadapalani");
    new Expectations() { {
        System.out.println("mocked vendor login");
        vdao.showLogin("rose1", "rose1");
        result = ven;
      } };
    new MockUp<VendorFactory>() {
        @Mock
        VendorDAO dao() {
            System.out.println("mocked dao");
            return vdao;
        }
    };
    Vendor vf = VendorFactory.showVendorLogin("rose1", "rose1");
    assertEquals(ven, vf);
  }
     /**
   * setup method.
   * @param vdao vendor login1.
   */
  @Test
public final void showVendorLoginTest1(@Mocked final VendorDAO vdao) {
    final Vendor ven = new Vendor(10, "Anne", "rose1", "rose1", "art@999", "9047776706", "vadapalani");
    new Expectations() { {
        System.out.println("mocked to get vendor login1");
        vdao.showLogin("era1", "era2");
        result = ven;
      } };
    new MockUp<VendorFactory>() {
        @Mock
        VendorDAO dao() {
            System.out.println("mocked dao");
            return vdao;
        }
    };
    Vendor vf = VendorFactory.showVendorLogin("era1", "era2");
    assertNotEquals(ven, vf);
  }
     /**
   * setup method.
   * @param vdao vendor login2.
   */
  @Test
public final void showVendorLoginTest2(@Mocked final VendorDAO vdao) {
    final Vendor ven = new Vendor(10, "Anne", "rose1", "rose1", "art@999", "9047776706", "vadapalani");
    new Expectations() { {
        System.out.println("mocked get vendor login2");
        vdao.showLogin(null, null);
        result = null;
      } };
    new MockUp<VendorFactory>() {
        @Mock
        VendorDAO dao() {
            System.out.println("mocked dao");
            return vdao;
        }
    };
    Vendor vf = VendorFactory.showVendorLogin(null, null);
    assertNull(vf);
  }
   /**
   * setup method.
   * @param vdao vendor test.
   */
  @Test
    public final void showVendorTest(@Mocked final VendorDAO vdao) {
    int expsize = 1;
    final List<Vendor> lstexp = new ArrayList<Vendor>();
    final Vendor ven1 = new Vendor(10, "Anne", "rose1", "rose1", "art@999", "9047776706", "vadapalani");
    new Expectations() { {
        System.out.println("mocked get vendor details");
        List<Vendor> lstexp = new ArrayList<Vendor>();
        vdao.show();
        lstexp.add(ven1);
        result = lstexp;
        } };
    new MockUp<VendorFactory>() {
        @Mock
        VendorDAO dao() {
            System.out.println("mocked dao");
            return vdao;
        }
    };
    Vendor[] act = VendorFactory.showVendor();
    assertEquals(expsize, act.length);
    assertEquals(ven1, act[0]);
    assertEquals("Anne", act[0].getVenName());
  }
      /**
   * setup method.
   */
  @Test
public final void constructortest() {
    VendorFactory v3 = new VendorFactory();
    assertNotNull(v3);
  }
     /**
  * setup method.
  */
  @Test
public final void daoTestMapper() {
    VendorDAO v4 = VendorFactory.dao();
    assertNotNull(v4);
    Vendor[] vn = VendorFactory.showVendor();
    assertNotNull(vn);
  }

    /**
  * Tests the wallet details.
  * @param vdao for custid.
   */
  @Test
  public final void getVendorDetails(
      @Mocked final VendorDAO vdao) {
    final Vendor ste = new Vendor(10, "Anne", "rose1", "rose1", "art@999", "9047776706", "vadapalani");
    new Expectations() { {
        System.out.println("mocked");
        vdao.getVendor(10);
        result = ste;

      } };
    new MockUp<VendorFactory>() {
        @Mock
      VendorDAO dao() {
        System.out.println("mocked dao");
        return vdao;
      }
    };
    Vendor c = VendorFactory.getVendorDetails(10);
    assertEquals(c, ste);
  }
}


