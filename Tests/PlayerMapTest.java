import static org.junit.Assert.assertEquals;

import org.junit.Test;
import server.server.PlayerMap;
import server.games.Player;

public class PlayerMapTest {

        @Test
        public void testPlayerMap() {
                PlayerMap pm = PlayerMap.getInstance();
                Player p = new Player(null, 0);

                pm.add("test", p);
                Player t = pm.getPlayer("test");

                assertEquals("must be same", p, t);
        }
}
