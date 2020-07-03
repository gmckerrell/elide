package com.mcafee.csi.thirdparty.com.yahoo.elide.utils.coerce.converters;

import com.yahoo.elide.utils.coerce.converters.Serde;
import java.time.Instant;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EpochToInstantSerdeTest {

    private final Serde<Number, Instant> serde = new EpochToInstantSerdes();

    @Test
    public void can_deserialize_a_long() {

        final Instant instant = serde.deserialize(123456789L);

        assertEquals(123456, instant.getEpochSecond());
        assertEquals(789000000, instant.getNano());

    }

    @Test
    public void can_deserialize_a_double() {

        final Instant instant = serde.deserialize(123456789.0);

        assertEquals(123456, instant.getEpochSecond());
        assertEquals(789000000, instant.getNano());

    }

    @Test
    public void can_serialize_epoch_seconds_as_long() {

        assertEquals(
            1559382175000L,
            serde.serialize(
                Instant.ofEpochSecond(1559382175)
            )
        );

    }

    @Test
    public void can_serialize_epoch_millis_as_long() {

        assertEquals(
            1559382175123L,
            serde.serialize(
                Instant.ofEpochMilli(1559382175123L)
            )
        );

    }

}
