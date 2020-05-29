package org.chronos.chronograph.internal.impl.index;

import java.util.Set;

import org.chronos.chronodb.api.indexing.LongIndexer;
import org.chronos.chronograph.api.structure.record.IPropertyRecord;
import org.chronos.common.annotation.PersistentClass;

@PersistentClass("kryo")
public class EdgeRecordLongIndexer2 extends EdgeRecordPropertyIndexer2<Long> implements LongIndexer {

	protected EdgeRecordLongIndexer2() {
		// default constructor for serialization
	}

	public EdgeRecordLongIndexer2(final String propertyName) {
		super(propertyName);
	}

	@Override
	protected Set<Long> getIndexValuesInternal(final IPropertyRecord record) {
		return GraphIndexingUtils.getLongIndexValues(record);
	}

}
