import org.junit.Test;
import  static org.assertj.core.api.Assertions.*;

public class AsserJTest {
  @Test
  public void simpleTest(){
    assertThat("test1").isEqualToIgnoringCase("Test1");
  }
}
