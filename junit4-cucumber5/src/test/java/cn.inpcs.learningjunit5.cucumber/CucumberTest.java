
package cn.inpcs.learningjunit5.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/calculator.feature", plugin = "pretty", glue = {"com.cucumber"})
public class CucumberTest {

    // TODO: see https://github.com/cucumber/cucumber-jvm/issues/1149

}
