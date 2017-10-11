import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ResultsProcessor {
	private int numberOfNodes;
	private ArrayList<Statistics> statistics = new ArrayList<Statistics>();

	ResultsProcessor(int numberOfNodes, String outputFolder) {
		this.numberOfNodes = numberOfNodes;
		
		Path path = Paths.get(outputFolder);

		if (!Files.exists(path)) {
			boolean success = (new File(outputFolder)).mkdirs();
			if (success) {
			    System.out.println("Results folder created");
			}
		}
		
		for (int i = 0; i < numberOfNodes; i++) {
			Statistics nodeStats = new Statistics(i + 1, outputFolder);
			statistics.add(nodeStats);
		}
	}

	public void generateStatsFor(Packet packet) {
		int nodeNumber = Integer.parseInt(packet.getHeader()
				.getProcessingNode());
		updateStatistics(nodeNumber, packet);
	}

	public void updateStatistics(int nodeNumber, Packet packet) {

		if (packet.getActionType().equals("Receive")) {
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.ROUTING)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpRoutingPacketsReceive++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpRoutingPacketsReceive += Integer
							.parseInt(packet.getLevel().getLength());

					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4RoutingPacketsReceive++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4RoutingPacketsReceive += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
			}
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.TRAFFIC)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpTrafficPacketsReceive++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpTrafficPacketsReceive += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4TrafficPacketsReceive++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4TrafficPacketsReceive += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
			}
		}

		if (packet.getActionType().equals("Send")) {
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.ROUTING)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpRoutingPacketsSend++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpRoutingPacketsSend += Integer
							.parseInt(packet.getLevel().getLength());

					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4RoutingPacketsSend++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4RoutingPacketsSend += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
			}
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.TRAFFIC)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpTrafficPacketsSend++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpTrafficPacketsSend += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4TrafficPacketsSend++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4TrafficPacketsSend += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
			}
		}

		if (packet.getActionType().equals("Drop")) {
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.ROUTING)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpRoutingPacketsDrop++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpRoutingPacketsDrop += Integer
							.parseInt(packet.getLevel().getLength());

					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4RoutingPacketsDrop++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4RoutingPacketsDrop += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
			}
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.TRAFFIC)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpTrafficPacketsDrop++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpTrafficPacketsDrop += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4TrafficPacketsDrop++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4TrafficPacketsDrop += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
			}
		}

		if (packet.getActionType().equals("Enqueue")) {
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.ROUTING)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpRoutingPacketsEnqueue++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpRoutingPacketsEnqueue += Integer
							.parseInt(packet.getLevel().getLength());

					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4RoutingPacketsEnqueue++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4RoutingPacketsEnqueue += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
			}
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.TRAFFIC)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpTrafficPacketsEnqueue++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpTrafficPacketsEnqueue += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4TrafficPacketsEnqueue++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4TrafficPacketsEnqueue += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
			}
		}

		if (packet.getActionType().equals("Dequeue")) {
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.ROUTING)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpRoutingPacketsDequeue++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpRoutingPacketsDequeue += Integer
							.parseInt(packet.getLevel().getLength());

					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4RoutingPacketsDequeue++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4RoutingPacketsDequeue += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "ROUTING"));
				}
			}
			if (packet.getHeader().getOriginalProtocol()
					.equals(ApplicationProtocol.TRAFFIC)) {
				if (packet.getLevel().getName().equals("udp")) {
					statistics.get(nodeNumber - 1).totalNumberOfUdpTrafficPacketsDequeue++;
					statistics.get(nodeNumber - 1).totalSizeOfUdpTrafficPacketsDequeue += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getUdpResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
				if (packet.getLevel().getName().equals("ipv4")) {
					statistics.get(nodeNumber - 1).totalNumberOfIpv4TrafficPacketsDequeue++;
					statistics.get(nodeNumber - 1).totalSizeOfIpv4TrafficPacketsDequeue += Integer
							.parseInt(packet.getLevel().getLength());
					statistics.get(nodeNumber - 1).getIpv4ResultsFile()
							.println(getPacketStats(packet, "TRAFFIC"));
				}
			}
		}

	}

	private String getPacketStats(Packet packet, String originalApplication) {
		String stats = packet.getHeader().getSimTime() + " "
				+ packet.getHeader().getMessageSequence() + " "
				+ packet.getLevel().getLength() + " " + originalApplication
				+ " " + packet.getActionType() + " "
				+ packet.getHeader().getSourceNode();
		return stats;
	}

	public void closeResultsProcessor() {
		for (int i = 1; i <= this.numberOfNodes; i++) {
			statistics.get(i - 1).generateStatistics();
			statistics.get(i - 1).closeWriters();
		}
	}
}
