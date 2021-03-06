package org.chronos.chronograph.internal.impl.structure.record2.valuerecords;

import org.chronos.common.annotation.PersistentClass;

import java.util.Arrays;

import static com.google.common.base.Preconditions.*;

@PersistentClass("kryo")
public class PropertyRecordStringArrayValue implements PropertyRecordValue<String[]> {

    private String[] array;

    protected PropertyRecordStringArrayValue(){
        // default constructor for kryo
    }

    public PropertyRecordStringArrayValue(String[] array){
        checkNotNull(array, "Precondition violation - argument 'array' must not be NULL!");
        this.array = new String[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    @Override
    public String[] getValue() {
        String[] outArray = new String[this.array.length];
        System.arraycopy(this.array, 0, outArray, 0, array.length);
        return outArray;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PropertyRecordStringArrayValue that = (PropertyRecordStringArrayValue) o;

        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
    
}
