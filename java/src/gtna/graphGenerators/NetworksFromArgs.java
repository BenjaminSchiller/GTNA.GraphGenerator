package gtna.graphGenerators;

import gtna.networks.Network;
import gtna.networks.canonical.Complete;
import gtna.networks.canonical.Regular;
import gtna.networks.canonical.Ring;
import gtna.networks.canonical.Star;
import gtna.networks.model.BarabasiAlbert;
import gtna.networks.model.CondonAndKarp;
import gtna.networks.model.DeBruijn;
import gtna.networks.model.ErdosRenyi;
import gtna.networks.model.GNC;
import gtna.networks.model.GNR;
import gtna.networks.model.PARG;
import gtna.networks.model.PositiveFeedbackPreference;
import gtna.networks.model.WattsStrogatz;
import gtna.networks.model.ZhouMondragon;
import gtna.networks.model.smallWorld.Kleinberg;
import gtna.networks.model.smallWorld.Kleinberg1D;
import gtna.networks.model.smallWorld.Kleinberg1DC;
import gtna.networks.model.smallWorld.KleinbergPowerLaw;
import gtna.networks.model.wot.WotModel;
import gtna.projects.makiDemo.GLP;
import gtna.transformation.Transformation;

public class NetworksFromArgs {
	public static enum NetworkType {
		COMPLETE, REGULAR, RING, STAR, KLEINBERG, KLEINBERG_1D, KLEINBERG_1DC, KLEINBERG_POWER_LAW, WOT, CONDON_KARP, CONDON_KARP_GENERALIZED, DE_BRUIJN, GIRVAN_NEWMAN, GLP, GNC, GNR, PARG, POSITIVE_FEEDBACK_PREFERENCE, ERDOS_RENYI, BARABASI_ALBERT, WATTS_STROGATZ, ZHOU_MONDRAGON
	};

	public static Network parse(NetworkType type, String... args) {
		return parse(type, null, args);
	}

	public static Network parse(NetworkType type, Transformation[] t,
			String... args) {
		switch (type) {
		case BARABASI_ALBERT:
			return new BarabasiAlbert(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), t);
		case COMPLETE:
			return new Complete(Integer.parseInt(args[0]), t);
		case CONDON_KARP:
			return new CondonAndKarp(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Double.parseDouble(args[2]),
					Double.parseDouble(args[3]), t);
		case DE_BRUIJN:
			return new DeBruijn(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), t);
		case ERDOS_RENYI:
			return new ErdosRenyi(Integer.parseInt(args[0]),
					Double.parseDouble(args[1]), Boolean.parseBoolean(args[2]),
					t);
		case GLP:
			return new GLP(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Double.parseDouble(args[2]),
					Double.parseDouble(args[3]), Double.parseDouble(args[4]), t);
		case GNC:
			return new GNC(Integer.parseInt(args[0]),
					Boolean.parseBoolean(args[1]),
					Boolean.parseBoolean(args[2]), t);
		case GNR:
			return new GNR(Integer.parseInt(args[0]),
					Boolean.parseBoolean(args[1]), Double.parseDouble(args[2]),
					t);
		case KLEINBERG:
			return new Kleinberg(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Integer.parseInt(args[2]),
					Integer.parseInt(args[3]), Double.parseDouble(args[4]),
					Boolean.parseBoolean(args[5]),
					Boolean.parseBoolean(args[6]), t);
		case KLEINBERG_1D:
			return new Kleinberg1D(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Integer.parseInt(args[2]),
					Double.parseDouble(args[3]), Boolean.parseBoolean(args[4]),
					Boolean.parseBoolean(args[5]), t);
		case KLEINBERG_1DC:
			return new Kleinberg1DC(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Integer.parseInt(args[2]),
					Double.parseDouble(args[3]), Boolean.parseBoolean(args[4]),
					Boolean.parseBoolean(args[5]), Integer.parseInt(args[6]), t);
		case KLEINBERG_POWER_LAW:
			return new KleinbergPowerLaw(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Double.parseDouble(args[2]),
					Integer.parseInt(args[3]), Boolean.parseBoolean(args[4]),
					Boolean.parseBoolean(args[5]), null, t);
		case PARG:
			return new PARG(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Integer.parseInt(args[2]),
					Integer.parseInt(args[3]), t);
		case POSITIVE_FEEDBACK_PREFERENCE:
			return new PositiveFeedbackPreference(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Double.parseDouble(args[2]),
					Double.parseDouble(args[3]), Double.parseDouble(args[4]), t);
		case REGULAR:
			return new Regular(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Boolean.parseBoolean(args[2]), t);
		case RING:
			return new Ring(Integer.parseInt(args[0]), t);
		case STAR:
			return new Star(Integer.parseInt(args[0]), t);
		case WATTS_STROGATZ:
			return new WattsStrogatz(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Double.parseDouble(args[2]), t);
		case WOT:
			return new WotModel(Integer.parseInt(args[0]),
					Double.parseDouble(args[1]), Double.parseDouble(args[2]),
					Double.parseDouble(args[3]), Double.parseDouble(args[4]),
					Double.parseDouble(args[5]), Double.parseDouble(args[6]),
					Double.parseDouble(args[7]), Double.parseDouble(args[8]),
					Double.parseDouble(args[9]), Double.parseDouble(args[10]),
					Integer.parseInt(args[11]), Integer.parseInt(args[12]),
					Integer.parseInt(args[13]), Double.parseDouble(args[14]),
					Double.parseDouble(args[15]), Double.parseDouble(args[16]),
					t);
		case ZHOU_MONDRAGON:
			return new ZhouMondragon(Integer.parseInt(args[0]),
					Double.parseDouble(args[1]), Integer.parseInt(args[2]), t);
		default:
			throw new IllegalArgumentException("unknown graph generator type: "
					+ type);
		}
	}
}
