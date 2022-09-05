package com.softwareag.it.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.softwareag.it.web.rest.TestUtil;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class RequestTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Request.class);
        Request request1 = new Request();
        request1.setId(UUID.randomUUID());
        Request request2 = new Request();
        request2.setId(request1.getId());
        assertThat(request1).isEqualTo(request2);
        request2.setId(UUID.randomUUID());
        assertThat(request1).isNotEqualTo(request2);
        request1.setId(null);
        assertThat(request1).isNotEqualTo(request2);
    }
}
