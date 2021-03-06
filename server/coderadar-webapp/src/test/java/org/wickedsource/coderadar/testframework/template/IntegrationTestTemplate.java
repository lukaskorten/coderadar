package org.wickedsource.coderadar.testframework.template;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.wickedsource.coderadar.CoderadarTestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class})
@SpringBootTest(classes = CoderadarTestApplication.class, properties = {
        "coderadar.master=false",
        "coderadar.slave=false",
        "coderadar.workdir=build/coderadar-workdir",
        "coderadar.dateLocale=de_DE"
})
@WebAppConfiguration
public abstract class IntegrationTestTemplate extends TestTemplate {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

}
