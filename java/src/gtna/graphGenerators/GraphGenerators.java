package gtna.graphGenerators;

import gtna.graph.Graph;
import gtna.graphGenerators.GraphWriterFromArgs.GraphWriterType;
import gtna.graphGenerators.NetworksFromArgs.NetworkType;
import gtna.io.graphWriter.GraphWriter;
import gtna.networks.Network;
import argList.ArgList;
import argList.types.array.StringArrayArg;
import argList.types.atomic.EnumArg;
import argList.types.atomic.IntArg;
import argList.types.atomic.StringArg;

public class GraphGenerators {

	public NetworkType networkType;
	public String[] networkArgs;

	public String outputDir;
	public int graphFrom;
	public int graphTo;

	public GraphWriterType writerType;
	public String[] writerArgs;
	public String suffix;

	public GraphGenerators(String networkType, String[] networkArgs,
			String outputDir, Integer graphFrom, Integer graphTo,
			String writerType, String[] writerArgs, String suffix) {
		this.networkType = NetworkType.valueOf(networkType);
		this.networkArgs = networkArgs;
		this.outputDir = outputDir;
		this.graphFrom = graphFrom;
		this.graphTo = graphTo;
		this.writerType = GraphWriterType.valueOf(writerType);
		this.writerArgs = writerArgs;
		this.suffix = suffix;
	}

	public static void main(String[] args) throws Exception {
		ArgList<GraphGenerators> argList = new ArgList<GraphGenerators>(
				GraphGenerators.class,
				new EnumArg("generatorType",
						"type of the graph generator to use", NetworkType
								.values()),
				new StringArrayArg("generatorArgs",
						"arguments for the generator", ","),
				new StringArg("outputDir",
						"dir where to write the graphs (ending with '/')"),
				new IntArg("graphFrom", "first graph index"),
				new IntArg("graphTo", "last graph index"),
				new EnumArg(
						"writerType",
						"type of the graph writer used for outputting the graphs",
						GraphWriterType.values()),
				new StringArrayArg(
						"writerArgs",
						"arguments for the graph writer (only required by EDGE_LIST: separator, use '-' otherwise)",
						","), new StringArg("suffix",
						"suffix of the graph to write, e.g., '.EdgeList'"));

		// args = new String[] { "ERDOS_RENYI", "100,4.6,false", "test/", "0",
		// "3", "EDGE_LIST", "	", ".EL" };

		GraphGenerators gg = argList.getInstance(args);
		gg.generate();
	}

	public void generate() throws Exception {
		Network nw = NetworksFromArgs.parse(this.networkType, this.networkArgs);
		GraphWriter w = GraphWriterFromArgs.parse(this.writerType,
				this.writerArgs);

		System.out.println("GENERATING " + this.graphFrom + " to "
				+ this.graphTo + " of type " + nw.getDescription());

		for (int i = this.graphFrom; i <= this.graphTo; i++) {
			System.out.print("generating graph " + i);
			Graph g = nw.generate();
			System.out.println("   DONE");
			String filename = this.outputDir + i + this.suffix;
			w.write(g, filename);
			System.out.println("wrote graph to " + filename);
		}
	}

}
