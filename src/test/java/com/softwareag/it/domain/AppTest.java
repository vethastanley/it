package com.softwareag.it.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.softwareag.it.web.rest.TestUtil;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(App.class);
        App app1 = new App();
        app1.setId(UUID.randomUUID());
        App app2 = new App();
        app2.setId(app1.getId());
        assertThat(app1).isEqualTo(app2);
        app2.setId(UUID.randomUUID());
        assertThat(app1).isNotEqualTo(app2);
        app1.setId(null);
        assertThat(app1).isNotEqualTo(app2);
    }
}
