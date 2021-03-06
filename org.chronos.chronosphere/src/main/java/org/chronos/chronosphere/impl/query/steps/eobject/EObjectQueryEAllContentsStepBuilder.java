package org.chronos.chronosphere.impl.query.steps.eobject;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.chronos.chronosphere.impl.query.EObjectQueryStepBuilderImpl;
import org.chronos.chronosphere.impl.query.traversal.TraversalChainElement;
import org.chronos.chronosphere.internal.api.ChronoSphereTransactionInternal;
import org.chronos.chronosphere.internal.ogm.api.ChronoSphereGraphFormat;

public class EObjectQueryEAllContentsStepBuilder<S> extends EObjectQueryStepBuilderImpl<S, Vertex> {

    public EObjectQueryEAllContentsStepBuilder(final TraversalChainElement previous) {
        super(previous);
    }

    @Override
    public GraphTraversal<S, Vertex> transformTraversal(final ChronoSphereTransactionInternal tx, final GraphTraversal<S, Vertex> traversal) {
        return traversal
            .repeat(
                // walk the incoming EContainer edges
                __.in(ChronoSphereGraphFormat.E_LABEL__ECONTAINER))
            // emit every step
            .emit()
            // don't quit until the last possible vertex was reached in the loop
            .until(t -> false);
    }

}
