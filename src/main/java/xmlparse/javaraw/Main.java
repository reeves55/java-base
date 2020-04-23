package xmlparse.javaraw;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setValidating(true);
        factory.setNamespaceAware(false);
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(true);
        factory.setCoalescing(false);
        factory.setExpandEntityReferences(true);

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(new EntityResolver() {
                @Override
                public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                    if (systemId.equals("http://mybatis.org/dtd/mybatis-3-mapper.dtd")) {
                        return new InputSource(getClass().getClassLoader().getResourceAsStream("META-INF/mybatis-3-mapper.dtd"));
                    }

                    return null;
                }
            });

            Document document = builder.parse(Main.class.getClassLoader().getResourceAsStream("xmlparse/xml/example.xml"));


            // 通过document接口来查找节点
            NodeList nodes = document.getElementsByTagName("select");
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("select" + (i + 1) + ": " + nodes.item(i).getAttributes().item(0).getNodeValue());
            }

            System.out.println("=========================================");

            // 通过xpath查找节点
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression expression = xPath.compile("//select");

            nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("select" + (i + 1) + ": " + nodes.item(i).getAttributes().item(0).getNodeValue());
            }

        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
