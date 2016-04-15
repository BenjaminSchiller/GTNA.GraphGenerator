package gtna.graphGenerators;

import gtna.io.graphWriter.CsvGraphWriter;
import gtna.io.graphWriter.EdgeListGraphWriter;
import gtna.io.graphWriter.GexfGraphWriter;
import gtna.io.graphWriter.GraphWriter;
import gtna.io.graphWriter.GtnaGraphWriter;

public class GraphWriterFromArgs {

	public static enum GraphWriterType {
		EDGE_LIST, GTNA, CSV, GEXF
	}

	public static GraphWriter parse(GraphWriterType type, String[] args) {
		switch (type) {
		case CSV:
			return new CsvGraphWriter();
		case EDGE_LIST:
			return new EdgeListGraphWriter(args[0]);
		case GEXF:
			return new GexfGraphWriter();
		case GTNA:
			return new GtnaGraphWriter();
		default:
			throw new IllegalArgumentException("invalid graph writer type: "
					+ type);
		}
	}
}
