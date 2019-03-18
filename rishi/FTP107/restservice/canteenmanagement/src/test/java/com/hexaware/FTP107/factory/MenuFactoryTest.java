package com.hexaware.FTP107.factory;

import java.util.ArrayList;
import java.util.List;
import com.hexaware.FTP107.model.Menu;
import com.hexaware.FTP107.persistence.MenuDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import mockit.Expectations;
import mockit.Mocked;
import mockit.MockUp;
import mockit.Mock;
  /**
 * MenuFactoryTest the menu datils in database.
 * @author hexware
 */
public class MenuFactoryTest {
    /**
   * testing the dao .
   */
  /**
    * @param mdao menudao mock method.
  */
  @Test
   public final void getMenuTest(@Mocked final MenuDAO mdao) {
    int expectedSize = 1;
    final List<Menu> ma = new ArrayList<Menu>();
    final Menu me = new Menu(3000, "idilis", 200, 25.78, "South indian", "idlis and sambar", 40);
    ma.add(me);
    new Expectations() { {
        System.out.println("mocked getMenu ");
        mdao.show();
        result = ma;
      } };
    new MockUp<MenuFactory>() {
        @Mock
        MenuDAO dao() {
            System.out.println("mocked dao");
            return mdao;
        }
    };
    Menu[] mn = MenuFactory.showMenu();
    assertEquals(expectedSize, mn.length);
  }
    /**
     * menufactory test constructor.
    */
  @Test
    public final void testmenuFactory() {
    MenuFactory m5 = new MenuFactory();
    assertNotNull(m5);
  }
  /**
     * testing for menudao.
    */
  @Test
  public final void testdaoMapper() {
    MenuDAO med = MenuFactory.dao();
    assertNotNull(med);
    Menu[]mf = MenuFactory.showMenu();
    assertNotNull(mf);
  }
}
