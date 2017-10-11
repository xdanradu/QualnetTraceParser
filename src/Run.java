import java.io.PrintWriter;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Run {

	public static void main(String args[]) {

		String traceFilename = args[0]; 
		int numberOfNodes = Integer.parseInt(args[1]);
		String outputFolder = args[2]; 
		
		long startTime = System.nanoTime();

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse(traceFilename, handler);

			ResultsProcessor resultsProcessor = new ResultsProcessor(numberOfNodes, outputFolder);

			for (Packet packet : handler.getResults()) {
				resultsProcessor.generateStatsFor(packet);
			
			}
			resultsProcessor.closeResultsProcessor();

			long estimatedTime = System.nanoTime() - startTime;
			System.out.println("Execution time: "
					+ ((double) estimatedTime / 1000000000.0) + "s");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
