
public class ElementsProcessor {

	public Header parseHeader(String rawData) {
		String[] headerData = rawData.trim().split("\\s+");
			
		String sourceNode = headerData[0];
		String messageSequence = headerData[1]; 
		String simTime = headerData[2];
		String originalProtocol = headerData[3];
		String processingNode = headerData[4];
		String tracingProtocol = headerData[5];
		
		return new Header(sourceNode, messageSequence, simTime, originalProtocol, processingNode, tracingProtocol);
	}
	
	public String parseAction(String rawData) {
		String[] actionData = rawData.trim().split("\\s+");
		
		String result = "";
		switch(actionData[0]){
			case "1":result="Send";break;
			case "2":result="Receive";break;
			case "3":result="Drop";break;
			case "4":result="Enqueue";break;
			case "5":result="Dequeue";break;
		}
		
		return result;
	}

	public Level parseUdp(String rawData) {
		String[] headerData = rawData.trim().split("\\s+");	
		String length = headerData[2];	
		return new Level("udp", length);
	}

	public Level parseIpv4(String rawData) {
		String[] headerData = rawData.trim().split("\\s+");	
		String length = headerData[5];	
		return new Level("ipv4", length);
	}

}
