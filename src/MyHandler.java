import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler{

	private List<Packet> results = null;
	private Packet packet = null;
	private Header header=null;
	private String actionType ="";
	private Level level = null;
	
    public List<Packet> getResults() {
        return results;
    }
	
	boolean rechdr = false;
	boolean action = false;
	boolean udp = false;
	boolean ipv4 = false;
	
	

	public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {


		if (qName.equalsIgnoreCase("rec")) {							
            if (results == null)
                results = new ArrayList<Packet>();
		}

		if (qName.equalsIgnoreCase("rechdr")) {							
			rechdr = true;
		}

		if (qName.equalsIgnoreCase("action")) {
			action = true;
		}

		if (qName.equalsIgnoreCase("udp")) {
			udp = true;
		}
		
		if (qName.equalsIgnoreCase("ipv4")) {
			ipv4 = true;
		}

	}

	public void endElement(String uri, String localName,
		String qName) throws SAXException {

        if (qName.equalsIgnoreCase("rec")) {
        	packet = new Packet(header, actionType, level);
            results.add(packet);
        }

	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if (rechdr) {
			Header parsedHeader = new ElementsProcessor().parseHeader(new String(ch, start, length));
			header = parsedHeader;
			rechdr = false;
		}

		if (action) {
			actionType = new ElementsProcessor().parseAction(new String(ch, start, length));
			action = false;
		}

		if (udp) {
			level = new ElementsProcessor().parseUdp(new String(ch, start, length));
			udp = false;
		}
		
		if (ipv4) {
			level = new ElementsProcessor().parseIpv4(new String(ch, start, length));
			ipv4 = false;
		}

	}

}
