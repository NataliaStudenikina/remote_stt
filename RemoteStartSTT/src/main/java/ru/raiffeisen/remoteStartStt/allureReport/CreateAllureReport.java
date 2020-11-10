package ru.raiffeisen.remoteStartStt.allureReport;

import ru.raiffeisen.allure.json.labels.Label;
import ru.raiffeisen.allure.json.step.AllureStep;
import ru.raiffeisen.remoteStartStt.ExecuteApplication;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.GetScenarioResultWrapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.step.Step;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateAllureReport {

    public void createSteps(GetScenarioResultWrapper scenarioResult) {
        List<Step> allSteps = scenarioResult.getBody().getGetScenarioResultResponse().getBody().getSteps();

        for (Step step :allSteps) {
            String name = step.getName();
            String status = step.getResult();
            Date startDate = step.getStartDate();
            Date finishDate = step.getFinishDate();
        }
    }



    private void fillStepData(){
        Step stepData = new AllureStep();
    }

    private void fillLabels(){
        List<Label> labelList = new ArrayList<>();
        String hostName = ExecuteApplication.enviroment;
        labelList.add(fillLabel("package",""));
        labelList.add(fillLabel("testClass",""));
        labelList.add(fillLabel("testMethod",""));
        labelList.add(fillLabel("suite","Regress"));
        labelList.add(fillLabel("host", hostName));
        labelList.add(fillLabel("thread","Thread---"));
        labelList.add(fillLabel("story","CPP-478"));
    }

    private Label fillLabel(String name, String value) { return new Label(name, value); }

    private Timestamp convertDateToTimeStamp (Date date){
        return new Timestamp(date.getTime());
    }






}
