package it.sisal.reporting.npo_wfit_reporting_batch;

import it.sisal.reporting.wfit.ReportingBatchApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ReportingBatchApplication.class, properties = "spring.main.allow-bean-definition-overriding=true")
@Import(TestConfig.class)
@ActiveProfiles("test")
class NpoWfitReportingBatchApplicationTests {

	@Test
	void contextLoads() {
	}

}
