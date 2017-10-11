public class Header {
	
	private String sourceNode;
	private String messageSequence; 
	private String simTime;
	private String originalProtocol;
	private String processingNode;
	private String tracingProtocol;
	
	Header(String sourceNode, String messageSequence, String simTime,
			String originalProtocol, String processingNode,
			String tracingProtocol) {
		this.sourceNode = sourceNode;
		this.messageSequence = messageSequence;
		this.simTime = simTime;
		this.originalProtocol = originalProtocol;
		this.processingNode = processingNode;
		this.tracingProtocol = tracingProtocol;
	}
	
	Header() {
	}

	public String getSourceNode() {
		return sourceNode;
	}
	public void setSourceNode(String sourceNode) {
		this.sourceNode = sourceNode;
	}
	public String getMessageSequence() {
		return messageSequence;
	}
	public void setMessageSequence(String messageSequence) {
		this.messageSequence = messageSequence;
	}
	public String getSimTime() {
		return simTime;
	}
	public void setSimTime(String simTime) {
		this.simTime = simTime;
	}
	public String getOriginalProtocol() {
		return originalProtocol;
	}
	public void setOriginalProtocol(String originalProtocol) {
		this.originalProtocol = originalProtocol;
	}
	public String getProcessingNode() {
		return processingNode;
	}
	public void setProcessingNode(String processingNode) {
		this.processingNode = processingNode;
	}
	public String getTracingProtocol() {
		return tracingProtocol;
	}
	public void setTracingProtocol(String tracingProtocol) {
		this.tracingProtocol = tracingProtocol;
	}
}
