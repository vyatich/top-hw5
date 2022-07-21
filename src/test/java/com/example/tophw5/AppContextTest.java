package com.example.tophw5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
        TopHw5Application.class,
        H2TestProfileJPAConfig.class
})
@ActiveProfiles("test")
class AppContextTest {

    @Test
    void contextLoads() {
    }

}
