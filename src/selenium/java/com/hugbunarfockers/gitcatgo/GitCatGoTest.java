package is.ru.arnlaugsson.chuck_joke;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GitCatGoTest extends SeleniumTestWrapper
{
    @Test
    public void titleMatches()
    {
        driver.get(baseUrl);
        assertEquals("Git-Cat-Go", driver.getTitle());
    }
}
