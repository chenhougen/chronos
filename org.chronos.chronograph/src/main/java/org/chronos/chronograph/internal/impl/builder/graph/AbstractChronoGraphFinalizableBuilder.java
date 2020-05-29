package org.chronos.chronograph.internal.impl.builder.graph;

import static com.google.common.base.Preconditions.*;

import org.apache.commons.configuration.Configuration;
import org.chronos.chronodb.api.ChronoDB;
import org.chronos.chronodb.internal.api.ChronoDBConfiguration;
import org.chronos.chronograph.api.builder.graph.ChronoGraphFinalizableBuilder;
import org.chronos.chronograph.api.structure.ChronoGraph;
import org.chronos.chronograph.internal.api.configuration.ChronoGraphConfiguration;
import org.chronos.chronograph.internal.impl.structure.graph.StandardChronoGraph;

public abstract class AbstractChronoGraphFinalizableBuilder
		extends AbstractChronoGraphBuilder<ChronoGraphFinalizableBuilder> implements ChronoGraphFinalizableBuilder {

	protected AbstractChronoGraphFinalizableBuilder() {
		// default properties for the graph
		this.withProperty(ChronoDBConfiguration.ASSUME_CACHE_VALUES_ARE_IMMUTABLE, "true");
		this.withProperty(ChronoDBConfiguration.DUPLICATE_VERSION_ELIMINATION_MODE, "false");
	}

	@Override
	public ChronoGraphFinalizableBuilder withIdExistenceCheckOnAdd(final boolean enableIdExistenceCheckOnAdd) {
		return this.withProperty(ChronoGraphConfiguration.TRANSACTION_CHECK_ID_EXISTENCE_ON_ADD,
				String.valueOf(enableIdExistenceCheckOnAdd));
	}

	@Override
	public ChronoGraphFinalizableBuilder withTransactionAutoStart(final boolean enableAutoStartTransactions) {
		return this.withProperty(ChronoGraphConfiguration.TRANSACTION_AUTO_OPEN,
				String.valueOf(enableAutoStartTransactions));
	}

	@Override
	public ChronoGraph build() {
		Configuration config = this.getPropertiesAsConfiguration();
		// in ChronoGraph, we can ALWAYS ensure immutability of ChronoDB cache values. The reason for this is
		// that ChronoGraph only passes records (e.g. VertexRecord) to the underlying ChronoDB, and records
		// are always immutable.
		config.setProperty(ChronoDBConfiguration.ASSUME_CACHE_VALUES_ARE_IMMUTABLE, "true");
		// ChronoGraph performs its own change tracking, so we never have duplicate versions
		config.setProperty(ChronoDBConfiguration.DUPLICATE_VERSION_ELIMINATION_MODE, "disabled");
		ChronoDB db = ChronoDB.FACTORY.create().fromConfiguration(config).build();
		return new StandardChronoGraph(db, config);
	}
}
