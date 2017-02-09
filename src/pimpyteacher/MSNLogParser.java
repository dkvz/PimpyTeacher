
package pimpyteacher;

import java.util.*;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
//import javax.xml.transform.*;
//import javax.xml.transform.dom.*;
//import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author Alain
 */
public class MSNLogParser {

    private File fil;
    private ArrayList<String> sentences;

    public MSNLogParser(File fil) {
        this.fil = fil;
        sentences = new ArrayList<String>();
    }

    private Document parseTheShit() throws Exception {
        DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
        Document doc = null;
        DocumentBuilder constructeur = fabrique.newDocumentBuilder();
        doc = constructeur.parse(this.getFil());
        return doc;
    }

    public void parse() throws Exception {
        if (!fil.exists() || !fil.canRead()) throw new FileNotFoundException("Impossible to read from given file.");
        Document document = this.parseTheShit();
        Element root = document.getDocumentElement();
        NodeList messages = root.getElementsByTagName("Message");
        if (messages == null) {
            throw new Exception("The file is empty or malformed.");
        }
        for (int x = 0; x < messages.getLength(); x++) {
            NodeList msgSpecs = messages.item(x).getChildNodes();
            for (int y = 0; y < msgSpecs.getLength(); y++) {
                Node el = msgSpecs.item(y);
                if (el.getNodeName().equals("Text")) {
                    this.getSentences().add(el.getTextContent());
                }
            }
        }
        document = null;
        System.gc();
    }

    /**
     * @return the fil
     */
    public File getFil() {
        return fil;
    }

    /**
     * @param fil the fil to set
     */
    public void setFil(File fil) {
        this.fil = fil;
    }

    /**
     * @return the sentences
     */
    public ArrayList<String> getSentences() {
        return sentences;
    }

    /**
     * @param sentences the sentences to set
     */
    public void setSentences(ArrayList<String> sentences) {
        this.sentences = sentences;
    }

    public int getSentenceCount() {
        return this.sentences.size();
    }

}
