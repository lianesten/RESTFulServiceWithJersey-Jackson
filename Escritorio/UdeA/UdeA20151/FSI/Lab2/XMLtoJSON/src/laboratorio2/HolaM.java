/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import javax.xml.XMLConstants;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author bairon.londono
 */
public class HolaM {

    public static int PRETTY_PRINT_IDENT_FACTOR = 4;
    public static String TEST_XML_STRING
            = "<breakfast_menu>    \n"
            + "                     <food>    \n"
            + "                     <name>Belgian Waffles</name>    \n"
            + "                     <price>$5.95</price>    \n"
            + "                     <description>    \n"
            + "                     Two of our famous Belgian Waffles with plenty of real maple syrup    \n"
            + "                     </description>    \n"
            + "                     <calories>650</calories>    \n"
            + "                     </food>    \n"
            + "                     <food>    \n"
            + "                     <name>Strawberry Belgian Waffles</name>    \n"
            + "                     <price>$7.95</price>    \n"
            + "                     <description>    \n"
            + "                     Light Belgian waffles covered with strawberries and whipped cream    \n"
            + "                     </description>    \n"
            + "                     <calories>900</calories>    \n"
            + "                     </food>    \n"
            + "</breakfast_menu>";
    
        public static void main(String[] args) {
        try{
            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
            String JSONPrettyString = xmlJSONObj.toString(PRETTY_PRINT_IDENT_FACTOR);
            System.out.println(JSONPrettyString);
        }catch(JSONException e){
            System.out.println(e.toString());
        }
        }
}
