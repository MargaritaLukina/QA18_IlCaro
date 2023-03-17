
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void registrationPositiveTest(){
            app.getUser().openRegistrationForm();
            app.getUser().fillRegistrationForm("RRR", "RRR", "asde@fgh.com", "$Asdf1234");
            app.getUser().clickCheckbox();
        //    app.getUser().submitForm();
        app.getUser().buttonYalla();
            Assert.assertTrue(app.getUser().isRegistrationSuccess());

    }
}
