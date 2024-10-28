package UD1.EjercicioOcho;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjercicioOcho {
    static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            FileReader fr = new FileReader("src/main/java/EjercicioOcho/SW.json");
            PersonajesWrapper personajeWrapper = gson.fromJson(fr, PersonajesWrapper.class);
            fr.close();
            List<Personaje> personajesElegidos = new ArrayList<Personaje>();


            for (Personaje personaje : personajeWrapper.getPersonajes()) {
                if (personaje.getVehicles().isEmpty()) {
                    personajesElegidos.add(personaje);
                }

            }
            Collections.sort(personajesElegidos);
            personajesElegidos.forEach(personaje -> System.out.println(personaje));

            if(crearFicheroXML(personajesElegidos)){
                System.out.println("Se ha podido crear el fichero XML correctamente");

            } else{
                System.out.println("No se ha podido crear el fichero XML");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean crearFicheroXML(List<Personaje> personajesElegidos) {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("characters");
            doc.appendChild(rootElement);


            for (Personaje personaje : personajesElegidos) {

                Element characterElement = doc.createElement("character");
               characterElement.setAttribute("Films",String.valueOf(personaje.getFilms().size()));
                characterElement.setAttribute("Vehicles",String.valueOf(personaje.getVehicles().size()));


                Element nameElement = doc.createElement("name");
                nameElement.appendChild(doc.createTextNode(personaje.getName()));
                characterElement.appendChild(nameElement);


                Element massElement = doc.createElement("mass");
                massElement.appendChild(doc.createTextNode(personaje.getMass()));
                characterElement.appendChild(massElement);


                Element urlElement = doc.createElement("url");
                urlElement.appendChild(doc.createTextNode(personaje.getUrl()));
                characterElement.appendChild(urlElement);


                rootElement.appendChild(characterElement);
            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/java/EjercicioOcho/characters.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo XML generado correctamente.");


        } catch (ParserConfigurationException | javax.xml.transform.TransformerException e) {
            LOGGER.error("Error a la hora de crear el fichero XML");
            return false;
        }


        return true;

    }

}
