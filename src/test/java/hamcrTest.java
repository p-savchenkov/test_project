import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class hamcrTest {

  @Test
  public void simpleTest(){

    assertThat("Test1", equalToIgnoringCase("test1"));
  }
}
