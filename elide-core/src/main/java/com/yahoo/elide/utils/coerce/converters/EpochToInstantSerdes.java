package com.yahoo.elide.utils.coerce.converters;

import java.time.Instant;

public class EpochToInstantSerdes implements Serde<Number, Instant> {

    @Override
    public Instant deserialize(final Number value) {
        return Instant.ofEpochMilli(
            value.longValue()
        );
    }

    @Override
    public Number serialize(final Instant value) {
        return value.toEpochMilli();
    }

}
