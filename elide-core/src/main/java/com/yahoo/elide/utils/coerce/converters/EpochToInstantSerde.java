/*
 * Copyright 2020, Yahoo Inc.
 * Licensed under the Apache License, Version 2.0
 * See LICENSE file in project root for terms.
 */
package com.yahoo.elide.utils.coerce.converters;

import java.time.Instant;

public class EpochToInstantSerde implements Serde<Number, Instant> {

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
