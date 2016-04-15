# GTNA.GraphGenerators

This generator allow for the generation of graph snapshots using various models.
The generator are all implemented in [GTNA](https://github.com/BenjaminSchiller/GTNA).


## Usage

To generate a list of graphs using a specific generator, use the following call:

	java -jar graphGenerator.jar $generatorType $generatorArgs $outputDir $graphFrom $graphTo $writerType $writerArgs $suffix

First, the model tu generate the graphs must be specified by a kexword.
The number of arguments / parameters for its generation depend on the model.
These arguments are next specified as a list, separated by `,`.
As third argument, the directory where the generated graph should be written must be specified.
Then, the first an last graph index to generate must be specified (use the same for both to only generate a single graph).
The fifth argument specified which format should be used to write the generated graph.
The sixth arguments is used to specify a list of arguments for the writer, currently only *EdgeList* takes a single argument; for the others `-` should simply be used to denote that there are no arguments specified.
Finally, the suffix of the graph to be written should be specified.

	expecting 8 arguments (got 0)
	   0: generatorType - type of the graph generator to use (String)
	      values:  COMPLETE REGULAR RING STAR KLEINBERG KLEINBERG_1D KLEINBERG_1DC KLEINBERG_POWER_LAW WOT CONDON_KARP CONDON_KARP_GENERALIZED DE_BRUIJN GIRVAN_NEWMAN GLP GN GNC GNR PARG POSITIVE_FEEDBACK_PREFERENCE ERDOS_RENYI BARABASI_ALBERT WATTS_STROGATZ ZHOU_MONDRAGON
	
	   1: generatorArgs - arguments for the generator (String[]) sep. by ','
	
	   2: outputDir - dir where to write the graphs (ending with '/') (String)
	
	   3: graphFrom - first graph index (Integer)
	
	   4: graphTo - last graph index (Integer)
	
	   5: writerType - type of the graph writer used for outputting the graphs (String)
	      values:  EDGE_LIST GTNA CSV GEXF
	
	   6: writerArgs - arguments for the graph writer (only required by EDGE_LIST: separator, use '-' otherwise) (String[]) sep. by ','
	
	   7: suffix - suffix of the graph to write, e.g., '.EdgeList' (String)


The resulting files are all written to `${outputDir}${id}${suffix}` where ${id} is between ${graphFrom} and ${graphTo}.



## Models and their arguments


- **BARABASI_ALBERT**
	- [gtna.networks.model.BarabasiAlbert.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/BarabasiAlbert.java)
	- arguments: nodes, EDGES_PER_NODE
- **COMPLETE**
	- [gtna.networks.canonical.Complete.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/canonical/Complete.java)
	- arguments: nodes
- **CONDON_KARP**
	- [gtna.networks.model.CondonAndKarp.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/CondonAndKarp.java)
	- arguments: nodes, groups, pin, pout
- **DE_BRUIJN**
	- [gtna.networks.model.DeBruijn.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/DeBruijn.java)
	- arguments: BASE, DIMENSIONS
- **ERDOS_RENYI**
	- [gtna.networks.model.ErdosRenyi.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/ErdosRenyi.java)
	- arguments: nodes, AVERAGE_DEGREE, BIDIRECTIONAL
- **GLP**
	- [gtna.projects.makiDemo.GLP.java](.java)
	- arguments: nodes, numOfStartNode, numOfAddedEdges, p, beta
- **GNC**
	- [gtna.networks.model.GNC.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/GNC.java)
	- arguments: nodes, BIDIRECTIONAL, EDGE_BACK
- **GNR**
	- [gtna.networks.model.GNR.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/GNR.java)
	- arguments: nodes, BIDIRECTIONAL, REDIRECTION_PROBABILITY
- **KLEINBERG**
	- [gtna.networks.model.smallWorld.Kleinberg.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/smallWorld/Kleinberg.java)
	- arguments: edgeLength, DIMENSIONS, LOCAL_DISTANCE, LONG_RANGE_CONTACTS, CLUSTERING_EXPONENT, BIDIRECTIONAL, WRAPAROUND
- **KLEINBERG_1D**
	- [gtna.networks.model.smallWorld.Kleinberg1D.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/smallWorld/Kleinberg1D.java)
	- arguments: nodes, SHORT_RANGE_CONTACTS, LONG_RANGE_CONTACTS, CLUSTERING_EXPONENT, BIDIRECTIONAL, RANDOM
- **KLEINBERG_1DC**
	- [gtna.networks.model.smallWorld.Kleinberg1DC.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/smallWorld/Kleinberg1DC.java)
	- arguments: nodes, SHORT_RANGE_CONTACTS, LONG_RANGE_CONTACTS, CLUSTERING_EXPONENT, BIDIRECTIONAL, RANDOM, C
- **KLEINBERG_POWER_LAW**
	- [gtna.networks.model.smallWorld.KleinbergPowerLaw.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/smallWorld/KleinbergPowerLaw.java)
	- arguments: nodes, SHORT_RANGE_CONTACTS, EXPONENT, CUTOFF, BIDIRECTIONAL, RANDOM
- **PARG**
	- [gtna.networks.model.PARG.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/PARG.java)
	- arguments: nodes, nAdd, nDel, nCut
- **POSITIVE_FEEDBACK_PREFERENCE**
	- [gtna.networks.model.PositiveFeedbackPreference.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/PositiveFeedbackPreference.java)
	- arguments: nodes, initialsize, p, q, delta
- **REGULAR**
	- [gtna.networks.canonical.Regular.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/canonical/Regular.java)
	- arguments: nodes, edges, undirected
- **RING**
	- [gtna.networks.canonical.Ring.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/canonical/Ring.java)
	- arguments: nodes
- **STAR**
	- [gtna.networks.canonical.Star.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/canonical/Star.java)
	- arguments: nodes
- **WATTS_STROGATZ**
	- [gtna.networks.model.WattsStrogatz.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/WattsStrogatz.java)
	- arguments: nodes, SUCCESSORS, BETA
- **WOT**
	- [gtna.networks.model.wot.WotModel.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/wot/WotModel.java)
	- arguments: nodes, d, b, bAlpha, alpha, beta, beta1, beta2, beta3, cC, cExp, cMin, cMax, cd, gamma1, gamma2, gamma3
- **ZHOU_MONDRAGON**
	- [gtna.networks.model.ZhouMondragon.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/networks/model/ZhouMondragon.java)
	- arguments: nodes, newEdgeProbability, edgesPerNode



## GraphWriters (and their arguments)

- **EDGE_LIST** $separator
	- [gtna.io.graphWriter.EdgeListGraphWriter.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/io/graphWriter/EdgeListGraphWriter.java)
	- this writer output a line for each edge in the format `${srcId}${sep}${dstId}`
	- it is the only writer which requires an argument (the separator ${sep})
- **GTNA**
	- [gtna.io.graphWriter.GtnaGraphWriter.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/io/graphWriter/GtnaGraphWriter.java)
	- GTNA's own format
- **CSV**
	- [gtna.io.graphWriter.CsvGraphWriter.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/io/graphWriter/CsvGraphWriter.java)
	- a comma-separated format
- **GEXF**
	- [gtna.io.graphWriter.GexfGraphWriter.java](https://github.com/BenjaminSchiller/GTNA/tree/master/src/gtna/io/graphWriter/GexfGraphWriter.java)
	- the GEXF format




## Examples

The following generates 10 random graphs using the ErdosRenyi model.
Here, the parameters specify that the graph should be directed and contain 100 vertices with an average degree of 5.3.
These graphs are written to `randomGraphs/0.el, randomGraphs/1.el, ..., randomGeaphs/9.el` in the EdgeList format.

	java -jar graphGenerators.jar ERDOS_RENYI 100,5.3,false randomGraphs/ 0 9 EDGE_LIST - .el

The following examples generates a singe graph using the BarabasiAlbert model:

	java -jar graphGenerators.jar BARABASI_ALBERT 200,3 powerLawGraphs/ 0 0 GTNA - .gtna



## Download

A built jar file for standalone usage can be downloaded from [dynamic-networks.org](http://dynamic-networks.org/data/jars/GTNA.GraphGenerators/).


## Building from source

To build the jar file from source (e.g., using the ant build file `build/build.xml`), you need a complete version of the [GTNA](https://github.com/BenjaminSchiller/GTNA) sources as well as [ArgList](https://github.com/BenjaminSchiller/ArgList).