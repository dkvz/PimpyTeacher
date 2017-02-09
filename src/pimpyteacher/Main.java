
package pimpyteacher;

import pimpy.*;
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author Alain
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // In future versions, pimpy will be able to run in client server.
        // We use unique main mode here.
        GraphicalPimpyController controller = new GraphicalPimpyController(PimpyDatabase.SQLITE_MODE);
        controller.startUI();

//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        map.put(13, 1);
//        map.put(16, 1);
//        map.put(2, 1);
//        map.put(13, 1);
//        if (map.containsKey(13)) {
//            System.out.println("The key is there.");
//        }

        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        String srch = "Fuck les trucs {USER_NAME} se sent tout{SESSION_TIME} c'est cool";
        Matcher matcher = pattern.matcher(srch);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }

}
