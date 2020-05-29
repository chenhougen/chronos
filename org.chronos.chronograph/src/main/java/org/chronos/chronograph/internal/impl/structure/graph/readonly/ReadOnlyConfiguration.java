package org.chronos.chronograph.internal.impl.structure.graph.readonly;

import com.google.common.collect.Iterators;
import org.apache.commons.configuration.Configuration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static com.google.common.base.Preconditions.*;

public class ReadOnlyConfiguration implements Configuration {

    private final Configuration configuration;

    public ReadOnlyConfiguration(final Configuration configuration) {
        checkNotNull(configuration, "Precondition violation - argument 'configuration' must not be NULL!");
        this.configuration = configuration;
    }

    @Override
    public Configuration subset(final String prefix) {
        return new ReadOnlyConfiguration(this.configuration.subset(prefix));
    }

    @Override
    public boolean isEmpty() {
        return this.configuration.isEmpty();
    }

    @Override
    public boolean containsKey(final String key) {
        return this.configuration.containsKey(key);
    }

    @Override
    public void addProperty(final String key, final Object value) {
        this.unsupportedOperation();
    }

    @Override
    public void setProperty(final String key, final Object value) {
        this.unsupportedOperation();
    }

    @Override
    public void clearProperty(final String key) {
        this.unsupportedOperation();
    }

    @Override
    public void clear() {
        this.unsupportedOperation();
    }

    @Override
    public Object getProperty(final String key) {
        return this.configuration.getProperty(key);
    }

    @Override
    public Iterator<String> getKeys(final String prefix) {
        return Iterators.unmodifiableIterator(this.configuration.getKeys(prefix));
    }

    @Override
    public Iterator<String> getKeys() {
        return Iterators.unmodifiableIterator(this.configuration.getKeys());
    }

    @Override
    public Properties getProperties(final String key) {
        return new Properties(this.configuration.getProperties(key));
    }

    @Override
    public boolean getBoolean(final String key) {
        return this.configuration.getBoolean(key);
    }

    @Override
    public boolean getBoolean(final String key, final boolean defaultValue) {
        return this.configuration.getBoolean(key, defaultValue);
    }

    @Override
    public Boolean getBoolean(final String key, final Boolean defaultValue) {
        return this.configuration.getBoolean(key, defaultValue);
    }

    @Override
    public byte getByte(final String key) {
        return this.configuration.getByte(key);
    }

    @Override
    public byte getByte(final String key, final byte defaultValue) {
        return this.configuration.getByte(key, defaultValue);
    }

    @Override
    public Byte getByte(final String key, final Byte defaultValue) {
        return this.configuration.getByte(key, defaultValue);
    }

    @Override
    public double getDouble(final String key) {
        return this.configuration.getDouble(key);
    }

    @Override
    public double getDouble(final String key, final double defaultValue) {
        return this.configuration.getDouble(key, defaultValue);
    }

    @Override
    public Double getDouble(final String key, final Double defaultValue) {
        return this.configuration.getDouble(key, defaultValue);
    }

    @Override
    public float getFloat(final String key) {
        return this.configuration.getFloat(key);
    }

    @Override
    public float getFloat(final String key, final float defaultValue) {
        return this.configuration.getFloat(key, defaultValue);
    }

    @Override
    public Float getFloat(final String key, final Float defaultValue) {
        return this.configuration.getFloat(key, defaultValue);
    }

    @Override
    public int getInt(final String key) {
        return this.configuration.getInt(key);
    }

    @Override
    public int getInt(final String key, final int defaultValue) {
        return this.configuration.getInt(key, defaultValue);
    }

    @Override
    public Integer getInteger(final String key, final Integer defaultValue) {
        return this.configuration.getInteger(key, defaultValue);
    }

    @Override
    public long getLong(final String key) {
        return this.configuration.getLong(key);
    }

    @Override
    public long getLong(final String key, final long defaultValue) {
        return this.configuration.getLong(key, defaultValue);
    }

    @Override
    public Long getLong(final String key, final Long defaultValue) {
        return this.configuration.getLong(key, defaultValue);
    }

    @Override
    public short getShort(final String key) {
        return this.configuration.getShort(key);
    }

    @Override
    public short getShort(final String key, final short defaultValue) {
        return this.configuration.getShort(key, defaultValue);
    }

    @Override
    public Short getShort(final String key, final Short defaultValue) {
        return this.configuration.getShort(key, defaultValue);
    }

    @Override
    public BigDecimal getBigDecimal(final String key) {
        return this.configuration.getBigDecimal(key);
    }

    @Override
    public BigDecimal getBigDecimal(final String key, final BigDecimal defaultValue) {
        return this.configuration.getBigDecimal(key, defaultValue);
    }

    @Override
    public BigInteger getBigInteger(final String key) {
        return this.configuration.getBigInteger(key);
    }

    @Override
    public BigInteger getBigInteger(final String key, final BigInteger defaultValue) {
        return this.configuration.getBigInteger(key, defaultValue);
    }

    @Override
    public String getString(final String key) {
        return this.configuration.getString(key);
    }

    @Override
    public String getString(final String key, final String defaultValue) {
        return this.configuration.getString(key, defaultValue);
    }

    @Override
    public String[] getStringArray(final String key) {
        String[] array = this.configuration.getStringArray(key);
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public List<Object> getList(final String key) {
        return Collections.unmodifiableList(this.configuration.getList(key));
    }

    @Override
    public List<Object> getList(final String key, final List<?> defaultValue) {
        return Collections.unmodifiableList(this.configuration.getList(key, defaultValue));
    }

    private void unsupportedOperation() {
        throw new UnsupportedOperationException("Unsupported method for readOnly graph!");
    }
}
