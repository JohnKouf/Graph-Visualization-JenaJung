 package northgods;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.util.iterator.ClosableIterator;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class JenaJungGraph implements DirectedGraph<RDFNode, Statement>
{
    final static boolean LOG = false;
    private final Model model;

    public JenaJungGraph(final Model model) {
        this.model = model;
    }

    private static <T> Collection<T> asCollection(final ClosableIterator<? extends T> it) {
        final Collection<T> toReturn = new HashSet<>();
        while (it.hasNext()) toReturn.add((T) it.next());
        it.close();
        return toReturn;
    }

    @Override
    public Collection<Statement> getInEdges(RDFNode vertex) {
        if (LOG) System.err.println("getInEdges");
        return asCollection(model.listStatements(null, null, vertex));
    }

    @Override
    public Collection<Statement> getOutEdges(RDFNode vertex) {
        if (LOG) System.err.println("getOutEdges");
        if (vertex.isLiteral()) return Collections.EMPTY_LIST;
        else return asCollection(model.listStatements((Resource) vertex, null, (RDFNode) null));
    }

    @Override
    public Collection<RDFNode> getPredecessors(RDFNode vertex) {
        if (LOG) System.err.println("getPredecessors");
        // Generics can be ugly
        return JenaJungGraph.<RDFNode>asCollection(model.listResourcesWithProperty(null, vertex));
    }

    @Override
    public Collection<RDFNode> getSuccessors(RDFNode vertex) {
        if (LOG) System.err.println("getSucessors");
        if (vertex.isLiteral()) return Collections.EMPTY_LIST;
        else return asCollection(model.listObjectsOfProperty((Resource) vertex, null));
    }

    @Override
    public int inDegree(RDFNode vertex) {
        if (LOG) System.err.println("inDegree");
        return getInEdges(vertex).size();
    }

    @Override
    public int outDegree(RDFNode vertex) {
        if (LOG) System.err.println("outDegree");
        return getOutEdges(vertex).size();
    }

    @Override
    public boolean isPredecessor(RDFNode v1, RDFNode v2) {
        if (LOG) System.err.println("isPredecessor");
        if (v1.isLiteral()) return false;
        else return model.contains((Resource) v1, null, v2);
    }

    @Override
    public boolean isSuccessor(RDFNode v1, RDFNode v2) {
        if (LOG) System.err.println("isSuccessor");
        return isPredecessor(v2, v1);
    }

    @Override
    public int getPredecessorCount(RDFNode vertex) {
        if (LOG) System.err.println("getPredecessorCount");
        return getPredecessors(vertex).size();
    }

    @Override
    public int getSuccessorCount(RDFNode vertex) {
        if (LOG) System.err.println("getSucessorCount");
        return getSuccessors(vertex).size();
    }

    @Override
    public RDFNode getSource(Statement directed_edge) {
        if (LOG) System.err.println("getSource");
        return directed_edge.getSubject();
    }

    @Override
    public RDFNode getDest(Statement directed_edge) {
        if (LOG) System.err.println("getDest");
        return directed_edge.getObject();
    }

    @Override
    public boolean isSource(RDFNode vertex, Statement edge) {
        if (LOG) System.err.println("isSource");
        return vertex.equals(edge.getSubject());
    }

    @Override
    public boolean isDest(RDFNode vertex, Statement edge) {
        if (LOG) System.err.println("isDest");
        return vertex.equals(edge.getObject());
    }

    @Override
    public boolean addEdge(Statement e, RDFNode v1, RDFNode v2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addEdge(Statement e, RDFNode v1, RDFNode v2, EdgeType edgeType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pair<RDFNode> getEndpoints(Statement edge) {
        if (LOG) System.err.println("getEndpoints: " + edge);
        return new Pair(edge.getSubject(), edge.getObject());
    }

    @Override
    public RDFNode getOpposite(RDFNode vertex, Statement edge) {
        if (LOG) System.err.println("getOpposite");
        if (edge.getSubject().equals(vertex)) return edge.getObject();
        else return edge.getSubject();
    }

    @Override
    public Collection<Statement> getEdges() {
        if (LOG) System.err.println("getEdges");
        return asCollection(model.listStatements());
    }

    @Override
    public Collection<RDFNode> getVertices() {
        if (LOG) System.err.println("getVertices");
        Collection<RDFNode> toReturn = asCollection(model.listObjects());
        toReturn.addAll(asCollection(model.listSubjects()));
        return toReturn;
    }

    @Override
    public boolean containsVertex(RDFNode vertex) {
        if (LOG) System.err.println("containsVertex");
        if (vertex.isResource() &&
                model.contains((Resource) vertex, null, (RDFNode) null)) return true;
        return model.contains(null, null, vertex);
    }

    @Override
    public boolean containsEdge(Statement edge) {
        if (LOG) System.err.println("containsEdge");
        return model.contains(edge);
    }

    @Override
    public int getEdgeCount() {
        if (LOG) System.err.println("getEdgeCount");
        return (int) model.size();
    }

    @Override
    public int getVertexCount() {
        if (LOG) System.err.println("getVertexCount");
        return getVertices().size();
    }

    @Override
    public Collection<RDFNode> getNeighbors(RDFNode vertex) {
        if (LOG) System.err.print("getNeighbours");
        Collection<RDFNode> i = new HashSet<>();
        i.addAll(getSuccessors(vertex));
        i.addAll(getPredecessors(vertex));
        return i;
    }

    @Override
    public Collection<Statement> getIncidentEdges(RDFNode vertex) {
        if (LOG) System.err.println("getIncidentEdges");
        Collection<Statement> most =
                asCollection(model.listStatements(null, null, vertex));
        if (vertex.isResource()) most.addAll(
                asCollection(model.listStatements((Resource) vertex, null, (RDFNode) null))
                );

        return most;
    }

    @Override
    public Collection<RDFNode> getIncidentVertices(Statement edge) {
        if (LOG) System.err.println("getIncidentVertices");
        return Arrays.asList(edge.getSubject(), edge.getObject());
    }

    @Override
    public Statement findEdge(RDFNode v1, RDFNode v2) {
        if (LOG) System.err.println("findEdgeSet");
        Collection<Statement> i = findEdgeSet(v1, v2);
        if (i.isEmpty()) return null;
        return i.iterator().next(); // TODO don't do this
    }

    @Override
    public Collection<Statement> findEdgeSet(RDFNode v1, RDFNode v2) {
        if (LOG) System.err.println("findEdgeSet");
        Collection<Statement> c = new HashSet<>();
        if (v1.isResource()) c.addAll(
                asCollection(model.listStatements((Resource) v1, null, v2)));
        if (v2.isResource()) c.addAll(
                asCollection(model.listStatements((Resource) v2, null, v1)));
        return c;
    }

    @Override
    public boolean addVertex(RDFNode vertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addEdge(Statement edge, Collection<? extends RDFNode> vertices) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addEdge(Statement edge, Collection<? extends RDFNode> vertices, EdgeType edge_type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeVertex(RDFNode vertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeEdge(Statement edge) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isNeighbor(RDFNode v1, RDFNode v2) {
        if (LOG) System.err.println("isNeighbour");
        return this.getNeighbors(v1).contains(v2);
    }

    @Override
    public boolean isIncident(RDFNode vertex, Statement edge) {
        System.err.println("isIncident");
        return (edge.getSubject().equals(vertex) ||
                edge.getObject().equals(vertex));
    }

    @Override
    public int degree(RDFNode vertex) {
        if (LOG) System.err.println("degree");
        return inDegree(vertex) + outDegree(vertex);
    }

    @Override
    public int getNeighborCount(RDFNode vertex) {
        if (LOG) System.err.println("neighbour count");
        return this.getNeighbors(vertex).size();
    }

    @Override
    public int getIncidentCount(Statement edge) {
        if (edge.getSubject().equals(edge.getObject())) return 1;
        return 2;
    }

    @Override
    public EdgeType getEdgeType(Statement edge) {
        if (LOG) System.err.println("getEdgeType");
        return EdgeType.DIRECTED;
    }

    @Override
    public EdgeType getDefaultEdgeType() {
        if (LOG) System.err.println("getDefaultEdgeType");
        return EdgeType.DIRECTED;
    }

    @Override
    public Collection<Statement> getEdges(EdgeType edge_type) {
        if (LOG) System.err.println("getEdges(type)");
        if (edge_type.equals(EdgeType.DIRECTED)) return getEdges();
        else return Collections.EMPTY_LIST;
    }

    @Override
    public int getEdgeCount(EdgeType edge_type) {
        if (LOG) System.err.println("getEdgeCount(type)");
        if (edge_type.equals(EdgeType.DIRECTED)) return (int) model.size();
        else return 0;
    }

}