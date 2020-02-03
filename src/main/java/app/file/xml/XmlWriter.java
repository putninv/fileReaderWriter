package app.file.xml;

import app.decathlon.model.DecathlonAthleteResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class XmlWriter {

    public static void writeDecathlonResults(List<DecathlonAthleteResult> results, String xmlFilePath) {
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("decathlonResults");
            document.appendChild(root);

            for(DecathlonAthleteResult result : results) {

                // athlete element
                Element athlete = document.createElement("athlete");
                root.appendChild(athlete);

                // firstname element
                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(result.getName()));
                athlete.appendChild(name);

                HashMap<String, Double> resultMap = result.getResults();
                for(String key : resultMap.keySet()) {
                    String txtValue = String.valueOf(resultMap.get(key));
                    Element node = document.createElement(key);
                    node.appendChild(document.createTextNode(txtValue));
                    athlete.appendChild(node);
                }
                String txtTotalValue = String.valueOf(result.getTotal());
                Element node = document.createElement("total");
                node.appendChild(document.createTextNode(txtTotalValue));
                athlete.appendChild(node);

                String place = String.valueOf(result.getPlace());
                Element nodePlace = document.createElement("place");
                nodePlace.appendChild(document.createTextNode(place));
                athlete.appendChild(nodePlace);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
