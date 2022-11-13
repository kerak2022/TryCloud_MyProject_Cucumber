package com.tryCloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                  "rerun:target/rerun.txt",
                  "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/feature" ,
        glue = "com/tryCloud/step_definitions" ,
        dryRun =false,
        tags = " @us4",
        publish = true
)
public class CukesRunner {

}
