package com.internship.introproject;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("junit-jupiter")
@SelectClasses({ControllerTest.class,EntityServiceTest.class})
public class JUnit5TestSuite {

}
