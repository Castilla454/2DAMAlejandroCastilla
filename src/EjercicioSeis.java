
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class EjercicioSeis {

    public static void main(String[] args) {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();


            Element rootElement = doc.createElement("curs");
            doc.appendChild(rootElement);

            String[][] modulos = {
                    {"Accés a Dades", "6", "8.45"},
                    {"Programació de serveis i processos", "3", "9.0"},
                    {"Desenvolupament d'interfícies", "6", "8.0"},
                    {"Programació Multimèdia i dispositius mòbils", "5", "7.34"},
                    {"Sistemes de Gestió Empresarial", "5", "8.2"},
                    {"Empresa i iniciativa emprenedora", "3", "7.4"}
            };


            for (String[] modulo : modulos) {
                Element modulElement = doc.createElement("modul");


                Element nomElement = doc.createElement("nom");
                nomElement.appendChild(doc.createTextNode(modulo[0]));
                modulElement.appendChild(nomElement);


                Element horesElement = doc.createElement("hores");
                horesElement.appendChild(doc.createTextNode(modulo[1]));
                modulElement.appendChild(horesElement);


                Element qualificacioElement = doc.createElement("qualificacio");
                qualificacioElement.appendChild(doc.createTextNode(modulo[2]));
                modulElement.appendChild(qualificacioElement);


                rootElement.appendChild(modulElement);
            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("modulos.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo XML generado correctamente.");


            leerYMostrarXML("modulos.xml");

        } catch (ParserConfigurationException | javax.xml.transform.TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void leerYMostrarXML(String archivoXML) {
        try {
            File inputFile = new File(archivoXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Raíz del documento: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("modul");

            System.out.println("Contenido del archivo XML:");

            for (int i = 0; i < nList.getLength(); i++) {
                Element modulo = (Element) nList.item(i);


                String nombre = modulo.getElementsByTagName("nom").item(0).getTextContent();
                System.out.println("Módulo: " + nombre);


                String horas = modulo.getElementsByTagName("hores").item(0).getTextContent();
                System.out.println("  Horas: " + horas);


                String calificacion = modulo.getElementsByTagName("qualificacio").item(0).getTextContent();
                System.out.println("  Calificación: " + calificacion);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

