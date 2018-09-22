package setUp;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by ahmetbaltaci on 21.09.2018.
 */
public class ReadJsonFile {


    /****Read to Json File ***/


        public static String readJsonFile(String item) {
            JsonParser parser = new JsonParser();
            Object obj = null;
            try {
                obj = parser.parse(new FileReader("config//config.json"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            JsonObject json = (JsonObject) obj;
            assert json != null;
            return json.getAsJsonPrimitive(item).getAsString();
        }


}
