package py.una.fiuna.evaluacion.util.xml;




import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConsultaSQL {

    Map<String,String>  sqlMap= new HashMap<String, String>();;


    public ConsultaSQL() {
        sqlMap= new HashMap<String, String>();
        leerXML();

    }

    void leerXML(){
        try
        {

            File file = new File("/home/leticia/evaluacion/src/main/resources/sql.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("query");

            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    sqlMap.put( eElement.getElementsByTagName("nombre").item(0).getTextContent(),eElement.getElementsByTagName("value").item(0).getTextContent() );



                }
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public String getSQL(String key){
        String sql = sqlMap.get(key);

        if (sql == null || sql.length() == 0) {
            throw new IllegalArgumentException("No se encontro sentencia SQL " + key + ". ");
        }
        return sql;
    }

    /*public static void main(String argv[])
    {
        ConsultaSQL c = new ConsultaSQL();
        c.leerXML();
        System.out.println( c.getSQL("select_factores_por_grupo"));
    }*/
}


