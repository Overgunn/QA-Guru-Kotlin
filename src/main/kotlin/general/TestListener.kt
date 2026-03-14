package general

import com.codeborne.selenide.Selenide
import org.junit.platform.engine.TestExecutionResult
import org.junit.platform.launcher.TestExecutionListener
import org.junit.platform.launcher.TestIdentifier
import org.junit.platform.launcher.TestPlan

class TestListener : TestExecutionListener {

    override fun testPlanExecutionStarted(testPlan: TestPlan) {
        Config.get
        println("|------ Starting test cycle -----|")
    }

    override fun executionStarted(testIdentifier: TestIdentifier) {
        if (!testIdentifier.isTest) return
        println("|--- TEST STARTED: ${testIdentifier.displayName}")
    }

    override fun executionFinished(
        testIdentifier: TestIdentifier,
        testExecutionResult: TestExecutionResult
    ) {}

    override fun executionSkipped(testIdentifier: TestIdentifier, reason: String) {
        if (!testIdentifier.isTest) return
        println("|--- TEST SKIPPED: ${testIdentifier.displayName} - Reason: $reason")
    }

    override fun testPlanExecutionFinished(testPlan: TestPlan) {
        Selenide.closeWebDriver()
        println("|------ Test cycle finished -----|")
    }
}