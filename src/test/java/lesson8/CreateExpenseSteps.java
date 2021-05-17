package lesson8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.CreateExpenseRequestPage;
import lesson8.ExpenseRequestsPage;
import lesson8.ExpensesSubMenu;
import lesson8.LoginPage;
import lesson8.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class CreateExpenseSteps {
    @Given("I am authorized")
    public void iAmAuthorized() {
        new LoginPage().login("Applanatest1", "Student2020!");
    }

    @Given("I am on expense page")
    public void iAmOnExpensePage() {
        new MainPage().navigationMenu.openNavigationMenuItem("Расходы");
        new ExpensesSubMenu().createExpense();
        new ExpenseRequestsPage().createExpense();
    }

    @When("I fill description field")
    public void iFillDescriptionField() {
        new CreateExpenseRequestPage().fillDescription("test");
    }

    @And("I select business unit")
    public void iSelectBusinessUnit() {
        new CreateExpenseRequestPage().selectBusinessUnit("Research & Development");
    }

    @And("I select expense")
    public void iSelectExpense() {
        new CreateExpenseRequestPage().selectExpense("01101 - ОС: вычислительная техника инфраструктуры");
    }

    @And("I fill sum plan")
    public void iFillSumPlan() {
        new CreateExpenseRequestPage().fillSumPlan("123");
    }

    @And("I select date")
    public void iSelectDate() {
        new CreateExpenseRequestPage().selectDate("24");
    }

    @And("I click save and close button")
    public void iClickSaveAndCloseButton() {
        new CreateExpenseRequestPage().saveAndCloseButton.click();
    }

    @Then("I see success message")
    public void iSeeSuccessMessage() {
        new CreateExpenseRequestPage().requestSuccess.shouldBe(Condition.visible);
    }

    @When("I fill {string} field")
    public void iFillDescriptionField(String description) {
        new CreateExpenseRequestPage().fillDescription(description);
    }
}
