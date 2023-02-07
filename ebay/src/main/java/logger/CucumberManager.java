package logger;

import io.cucumber.java.Scenario;

import java.util.Objects;

public class CucumberManager {

    private CucumberManager() {
    }

    private static ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    static Scenario getScenario() {
        return scenario.get();
    }

    static void setScenario(Scenario sce) {
        if (Objects.nonNull(sce)) {
            scenario.set(sce);
        }
    }

    static void unload() {
        scenario.remove();
    }
}
