package com.gemini.generic.plugin;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.utils.GemJarGlobalVar;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

import static com.gemini.generic.utils.GemJarUtils.initializeGemJARGlobalVariables;

public class CucumberJewelPlugin implements EventListener {



    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(Event.class,this::eventHandle);
        eventPublisher.registerHandlerFor(TestRunStarted.class,
                this::handleTestRunStarted); //StartSuite
        eventPublisher.registerHandlerFor(TestCaseStarted.class,this::handleTestCaseStarted); //startTestCase
        eventPublisher.registerHandlerFor(StepDefinedEvent.class,this::handleStepDefinition);
        eventPublisher.registerHandlerFor(TestStepStarted.class,this::handleTestStep);
        eventPublisher.registerHandlerFor(TestStepFinished.class,this::handleTestStepFinished); //AddTestStep
        eventPublisher.registerHandlerFor(TestCaseFinished.class,this::handleTestCaseEnded); //endTestCase
        eventPublisher.registerHandlerFor(TestRunFinished.class,this::handleTestRunFinished); //endSuite

    }




        private void handleTestRunStarted (TestRunStarted runStart)  {

        try{
            initializeGemJARGlobalVariables();

        }
        catch (Exception e){
            System.out.println("Expetion in loading values ");

        }
//        System.out.println("Inside Run started ");
//        System.out.println(runStart.getInstant());
//        GemJarGlobalVar.jewelCredentials=true; //global credentials
//        GemJarGlobalVar.reportName = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_id"); //config values
//        GemJarGlobalVar.cucumberFlag= true;
//        GemJarGlobalVar.environment = "beta";
//        GemJarGlobalVar.projectName = "Sample Serenity Project";
//        GemJarGlobalVar.report_type = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_USER_NAME,"akhilsingh");
//        System.setProperty(GemJarConstants.GEMJAR_REPORTING_TOKEN,"13a86f1b-ca6d-477a-8532-b3bb674264a01675112104492"); //token
//        System.setProperty(GemJarConstants.ENVIRONMENT,"beta");
//        System.setProperty(GemJarConstants.JEWEL_ENTRY_URL,"https://apis.gemecosystem.com/enter-point");
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_ID ");
//        GemJarGlobalVar.s_run_id = "s123";

        GemTestReporter.startSuite(GemJarGlobalVar.projectName, GemJarGlobalVar.environment, GemJarGlobalVar.s_run_id);
    }


    private void handleTestCaseStarted(TestCaseStarted event){
//        GemJarGlobalVar.jewelCredentials=true; //global credentials
//        GemJarGlobalVar.reportName = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_id"); //config values
//        GemJarGlobalVar.cucumberFlag= true;
//        GemJarGlobalVar.environment = "beta";
//        GemJarGlobalVar.projectName = "Sample Serenity Project";
//        GemJarGlobalVar.report_type = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_USER_NAME,"akhilsingh");
//        System.setProperty(GemJarConstants.GEMJAR_REPORTING_TOKEN,"13a86f1b-ca6d-477a-8532-b3bb674264a01675112104492"); //token
//        System.setProperty(GemJarConstants.ENVIRONMENT,"beta");
//        System.setProperty(GemJarConstants.JEWEL_ENTRY_URL,"https://apis.gemecosystem.com/enter-point");
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_ID ");
//        System.out.println("Inside TestCase Started Event ");
//        System.out.println(event.toString());
        System.out.println(event.getTestCase().getName());
        GemTestReporter.startTestCase(event.getTestCase().getName(),"On Demand",false);

    }
    private void handleTestStep(TestStepStarted testStep){
        String stepName;


        if(testStep.getTestStep() instanceof PickleStepTestStep){
            PickleStepTestStep steps = (PickleStepTestStep) testStep.getTestStep();
            stepName = steps.getStep().getText();
        }else{

            HookTestStep hStep = (HookTestStep) testStep.getTestStep();
            stepName = hStep.getHookType().name();
        }

    }


    private void handleTestStepFinished(TestStepFinished stepFinished){
//        String codeLocation = stepFinished.getTestStep().getCodeLocation().toString().replace("Javalang.String","");
//        String[] strArr = codeLocation.split("\\.");

        //  TestOutcome test = TestOutcome.forTest(strArr[strArr.length-1],starter.CucumberTestSuite.class);

//        GemJarGlobalVar.jewelCredentials=true; //global credentials
//        GemJarGlobalVar.reportName = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_id"); //config values
//        GemJarGlobalVar.cucumberFlag= true;
//        GemJarGlobalVar.environment = "beta";
//        GemJarGlobalVar.projectName = "SAMPLESERENITYPROJECT";
//        GemJarGlobalVar.report_type = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_USER_NAME,"akhilsingh");
//        System.setProperty(GemJarConstants.GEMJAR_REPORTING_TOKEN,"13a86f1b-ca6d-477a-8532-b3bb674264a01675112104492"); //token
//        System.setProperty(GemJarConstants.ENVIRONMENT,"beta");
//        System.setProperty(GemJarConstants.JEWEL_ENTRY_URL,"https://apis.gemecosystem.com/enter-point");
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_ID ");
        String stepName ;
        Status result = stepFinished.getResult().getStatus();

        if(stepFinished.getTestStep() instanceof PickleStepTestStep){
            PickleStepTestStep steps = (PickleStepTestStep) stepFinished.getTestStep();
            stepName = steps.getStep().getText();

        }else{

            HookTestStep hStep = (HookTestStep) stepFinished.getTestStep();
            stepName = hStep.getHookType().name();
        }

        GemTestReporter.addTestStep(stepName.toString(),"step Description", STATUS.PASS);
    }

    private void handleTestCaseEnded(TestCaseFinished testCaseFinished){
//        String codeLocation = testCaseFinished.getTestCase().getLocation().toString().replace("Javalang.String","");
//        String[] strArr = codeLocation.split("\\.");
//
//
//        GemJarGlobalVar.jewelCredentials=true; //global credentials
//        GemJarGlobalVar.reportName = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_id"); //config values
//        GemJarGlobalVar.cucumberFlag= true;
//        GemJarGlobalVar.environment = "beta";
//        GemJarGlobalVar.projectName = "SAMPLESERENITYPROJECT";
//        GemJarGlobalVar.report_type = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_USER_NAME,"akhilsingh");
//        System.setProperty(GemJarConstants.GEMJAR_REPORTING_TOKEN,"13a86f1b-ca6d-477a-8532-b3bb674264a01675112104492"); //token
//        System.setProperty(GemJarConstants.ENVIRONMENT,"beta");
//        System.setProperty(GemJarConstants.JEWEL_ENTRY_URL,"https://apis.gemecosystem.com/enter-point");
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_ID ");
        GemTestReporter.endTestCase();

    }

    private void handleTestRunFinished(TestRunFinished testRunFinished){
//        GemJarGlobalVar.jewelCredentials=true; //global credentials
//        GemJarGlobalVar.reportName = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_id"); //config values
//        GemJarGlobalVar.cucumberFlag= true;
//        GemJarGlobalVar.environment = "beta";
//        GemJarGlobalVar.projectName = "SAMPLESERENITYPROJECT";
//        GemJarGlobalVar.report_type = "Sample Report";
//        System.setProperty(GemJarConstants.GEMJAR_USER_NAME,"akhilsingh");
//        System.setProperty(GemJarConstants.GEMJAR_REPORTING_TOKEN,"13a86f1b-ca6d-477a-8532-b3bb674264a01675112104492"); //token
//        System.setProperty(GemJarConstants.ENVIRONMENT,"beta");
//        System.setProperty(GemJarConstants.JEWEL_ENTRY_URL,"https://apis.gemecosystem.com/enter-point");
//        System.setProperty(GemJarConstants.GEMJAR_SUBSCRIPTION_ID,"test_ID ");
        // GemJarGlobalVar.reportLocation = "D:\\Suite Reports jewel\\Sample Serneity";
        GemTestReporter.endSuite();

    }




    private void handleStepDefinition(StepDefinedEvent sd){
       // System.out.println("Inside Step Definition Event ");


    }

    private void eventHandle(Event ev){

     //   System.out.println("Inside Event Class ");
//            System.out.println(ev.toString());
//            System.out.println(ev.getInstant().toString());
//            System.out.println("******************");
    }


}
