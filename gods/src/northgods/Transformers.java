package northgods;

import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.shared.PrefixMapping;
import org.apache.commons.collections15.Transformer;

public class Transformers {

    public final static NodeT NODE = new NodeT();
    public final static EdgeT EDGE = new EdgeT();

    private static String toString(Resource resource) {
        if (resource.isAnon()) return "[]";
        PrefixMapping pmap = resource.getModel();
        String qname = pmap.qnameFor(resource.getURI());
        if (qname != null) return qname;
        return "<" + resource.getURI() + ">";
    }

    public static class NodeT implements Transformer<RDFNode, String> {

	@Override
        public String transform(RDFNode input) {
	    
            if (input.isLiteral()) return input.toString();
	    else return Transformers.toString((Resource) input).replace("http://NorseMythology/Gods#", "");
        }
        
    }

    public static class EdgeT implements Transformer<Statement, String> {

	@Override
        public String transform(Statement input) {
            return Transformers.toString(input.getPredicate()).replace("http://NorseMythology/Gods#", "");
        }

    }
}
