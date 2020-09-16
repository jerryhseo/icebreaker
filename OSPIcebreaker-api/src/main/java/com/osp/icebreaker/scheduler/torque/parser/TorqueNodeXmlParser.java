package com.osp.icebreaker.scheduler.torque.parser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.input.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.osp.icebreaker.scheduler.torque.model.TorqueNode;


/**
 * XML SAX parser for nodes.
 *
 * @since 0.1
 */
public class TorqueNodeXmlParser implements TorqueParser<String, List<TorqueNode>> {

    /*
     * (non-Javadoc)
     * @see com.tupilabs.pbs.parser.Parser#parse(java.lang.Object)
     */
    @Override
    public List<TorqueNode> parse(String xml) throws TorqueParseException {
        try {
            final SAXParserFactory factory = SAXParserFactory.newInstance();
            final SAXParser saxParser = factory.newSAXParser();
            final TorqueNodeXmlHandler handler = new TorqueNodeXmlHandler();

            saxParser.parse(new CharSequenceInputStream(xml, Charset.defaultCharset()), handler);

            return handler.getNodes();
        } catch (IOException ioe) {
            throw new TorqueParseException(ioe);
        } catch (SAXException e) {
            throw new TorqueParseException(e);
        } catch (ParserConfigurationException e) {
            throw new TorqueParseException(e);
        }
    }

}
