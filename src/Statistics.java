import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Statistics {
	private int nodeNumber;
	private String outputFolder;
	
	public int totalNumberOfUdpRoutingPacketsSend;
	public int totalNumberOfUdpRoutingPacketsReceive;
	public int totalNumberOfUdpRoutingPacketsDrop;
	public int totalNumberOfUdpRoutingPacketsEnqueue;
	public int totalNumberOfUdpRoutingPacketsDequeue;
	
	public double totalSizeOfUdpRoutingPacketsSend;
	public double totalSizeOfUdpRoutingPacketsReceive;
	public double totalSizeOfUdpRoutingPacketsDrop;
	public double totalSizeOfUdpRoutingPacketsEnqueue;
	public double totalSizeOfUdpRoutingPacketsDequeue;
	
	public int totalNumberOfUdpTrafficPacketsSend;
	public int totalNumberOfUdpTrafficPacketsReceive;
	public int totalNumberOfUdpTrafficPacketsDrop;
	public int totalNumberOfUdpTrafficPacketsEnqueue;
	public int totalNumberOfUdpTrafficPacketsDequeue;
	
	public double totalSizeOfUdpTrafficPacketsSend;
	public double totalSizeOfUdpTrafficPacketsReceive;
	public double totalSizeOfUdpTrafficPacketsDrop;
	public double totalSizeOfUdpTrafficPacketsEnqueue;
	public double totalSizeOfUdpTrafficPacketsDequeue;
		
	public int totalNumberOfIpv4RoutingPacketsSend;
	public int totalNumberOfIpv4RoutingPacketsReceive;
	public int totalNumberOfIpv4RoutingPacketsDrop;
	public int totalNumberOfIpv4RoutingPacketsEnqueue;
	public int totalNumberOfIpv4RoutingPacketsDequeue;
	
	public double totalSizeOfIpv4RoutingPacketsSend;
	public double totalSizeOfIpv4RoutingPacketsReceive;
	public double totalSizeOfIpv4RoutingPacketsDrop;
	public double totalSizeOfIpv4RoutingPacketsEnqueue;
	public double totalSizeOfIpv4RoutingPacketsDequeue;
	
	public int totalNumberOfIpv4TrafficPacketsSend;
	public int totalNumberOfIpv4TrafficPacketsReceive;
	public int totalNumberOfIpv4TrafficPacketsDrop;
	public int totalNumberOfIpv4TrafficPacketsEnqueue;
	public int totalNumberOfIpv4TrafficPacketsDequeue;
	
	public double totalSizeOfIpv4TrafficPacketsSend;
	public double totalSizeOfIpv4TrafficPacketsReceive;
	public double totalSizeOfIpv4TrafficPacketsDrop;
	public double totalSizeOfIpv4TrafficPacketsEnqueue;
	public double totalSizeOfIpv4TrafficPacketsDequeue;
	
	private PrintWriter udpResultsFile;
	private PrintWriter ipv4ResultsFile;
	
	Statistics(int nodeNumber, String outputFolder){
		this.nodeNumber=nodeNumber;
		this.outputFolder = outputFolder;
		try {
			this.udpResultsFile = new PrintWriter(this.outputFolder+"/Node_"+nodeNumber+"_UDP.txt", "UTF-8");
			this.ipv4ResultsFile = new PrintWriter(this.outputFolder+"/Node_"+nodeNumber+"_IPv4.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
	}

	public void closeWriters() {
		this.udpResultsFile.close();
		this.ipv4ResultsFile.close();
	}

	public PrintWriter getUdpResultsFile() {
		return udpResultsFile;
	}

	public void setUdpResultsFile(PrintWriter udpResultsFile) {
		this.udpResultsFile = udpResultsFile;
	}

	public PrintWriter getIpv4ResultsFile() {
		return ipv4ResultsFile;
	}

	public void setIpv4ResultsFile(PrintWriter ipv4ResultsFile) {
		this.ipv4ResultsFile = ipv4ResultsFile;
	}

	public double getSizeInMegaBytes(double size){
		return size/1000000;
	}
	
	
	public void generateStatistics(){
		try {
			PrintWriter stats;
			stats = new PrintWriter(this.outputFolder+"/statistics_node"+this.nodeNumber+".txt", "UTF-8");
			
			stats.println("------------------------------------------------------------");	
			stats.println("NODE: "+this.nodeNumber);	
			stats.println("------------------------------------------------------------");	
			stats.println("UDP Level");	
			stats.println("------------------------------------------------------------");	
			stats.println(String.format("%52s %10s", "Total number of UDP routing packets receive: ",this.totalNumberOfUdpRoutingPacketsReceive));		
			stats.println(String.format("%52s %10s", "Total size of UDP routing packets receive (Bytes): ",this.totalSizeOfUdpRoutingPacketsReceive));	
			stats.println(String.format("%52s %10s", "Total number of UDP routing packets send: ",this.totalNumberOfUdpRoutingPacketsSend));
			stats.println(String.format("%52s %10s", "Total size of UDP routing packets send (Bytes): ",this.totalSizeOfUdpRoutingPacketsSend));
			stats.println(String.format("%52s %10s", "Total number of UDP traffic packets receive: ",this.totalNumberOfUdpTrafficPacketsReceive));
			stats.println(String.format("%52s %10s", "Total size of UDP traffic packets receive (MB): ",getSizeInMegaBytes(this.totalSizeOfUdpTrafficPacketsReceive)));
			stats.println(String.format("%52s %10s", "Total number of UDP traffic packets drop: ",this.totalNumberOfUdpTrafficPacketsDrop));
			stats.println(String.format("%52s %10s", "Total size of UDP traffic packets drop (MB): ",getSizeInMegaBytes(this.totalSizeOfUdpTrafficPacketsDrop)));
			stats.println(String.format("%52s %10s", "Total number of UDP traffic packets enqueue: ",this.totalNumberOfUdpTrafficPacketsEnqueue));
			stats.println(String.format("%52s %10s", "Total size of UDP traffic packets enqueue (MB): ",getSizeInMegaBytes(this.totalSizeOfUdpTrafficPacketsEnqueue)));
			stats.println(String.format("%52s %10s", "Total number of UDP traffic packets dequeue: ",this.totalNumberOfUdpTrafficPacketsDequeue));
			stats.println(String.format("%52s %10s", "Total size of UDP traffic packets dequeue (MB): ",getSizeInMegaBytes(this.totalSizeOfUdpTrafficPacketsDequeue)));
			stats.println("------------------------------------------------------------");	
			stats.println("Ipv4 Level");	
			stats.println("------------------------------------------------------------");	
			stats.println(String.format("%52s %10s", "Total number of Ipv4 routing packets receive: ",this.totalNumberOfIpv4RoutingPacketsReceive));		
			stats.println(String.format("%52s %10s", "Total size of Ipv4 routing packets receive (Bytes): ",this.totalSizeOfIpv4RoutingPacketsReceive));	
			stats.println(String.format("%52s %10s", "Total number of Ipv4 routing packets send: ",this.totalNumberOfIpv4RoutingPacketsSend));
			stats.println(String.format("%52s %10s", "Total size of Ipv4 routing packets send (Bytes): ",this.totalSizeOfIpv4RoutingPacketsSend));
			stats.println(String.format("%52s %10s", "Total number of Ipv4 traffic packets receive: ",this.totalNumberOfIpv4TrafficPacketsReceive));
			stats.println(String.format("%52s %10s", "Total size of Ipv4 traffic packets receive (MB): ",getSizeInMegaBytes(this.totalSizeOfIpv4TrafficPacketsReceive)));
			stats.println(String.format("%52s %10s", "Total number of Ipv4 traffic packets drop: ",this.totalNumberOfIpv4TrafficPacketsDrop));
			stats.println(String.format("%52s %10s", "Total size of Ipv4 traffic packets drop (MB): ",getSizeInMegaBytes(this.totalSizeOfIpv4TrafficPacketsDrop)));
			stats.println(String.format("%52s %10s", "Total number of Ipv4 traffic packets enqueue: ",this.totalNumberOfIpv4TrafficPacketsEnqueue));
			stats.println(String.format("%52s %10s", "Total size of Ipv4 traffic packets enqueue (MB): ",getSizeInMegaBytes(this.totalSizeOfIpv4TrafficPacketsEnqueue)));
			stats.println(String.format("%52s %10s", "Total number of Ipv4 traffic packets dequeue: ",this.totalNumberOfIpv4TrafficPacketsDequeue));
			stats.println(String.format("%52s %10s", "Total size of Ipv4 traffic packets dequeue (MB): ",getSizeInMegaBytes(this.totalSizeOfIpv4TrafficPacketsDequeue)));
			
			stats.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
