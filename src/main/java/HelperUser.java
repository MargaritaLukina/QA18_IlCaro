
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"), email);
        type(By.id("password"), password);
    }
    public void fillRegistrationForm(String name, String lastName, String email, String password){
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }



    public void submitForm(){
        wd.findElement(By.cssSelector("[type='submit']")).submit();
    }
    public void buttonYalla(){
        click(By.xpath("//button[@type='submit']"));}

    public void clickCheckbox(){
boolean isSelected;
        WebElement chkBx=wd.findElement(By.xpath("//label[@class = 'checkbox-label terms-label']"));
        isSelected= chkBx.isSelected();
        if(isSelected == false){
            chkBx.click();
        }

    }

    public void openLoginForm() {
        click(By.xpath("//a[.=' Log in ']"));
    }
    public void openRegistrationForm() {
        click(By.xpath("//a[.=' Sign up ']"));
    }

    public void logout(){
        click(By.xpath("//a[.=' Logout ']"));
    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='Logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='Logged in success']")).getText().contains("success");
    }

    public boolean isRegistrationSuccess(){
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='You are logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='You are logged in success']")).getText().contains("success");

    }

    //<h2 _ngcontent-pyt-c36="" class="message">You are logged in success</h2>

    public boolean isLoggedFailed() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]"))));
        return wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]")).getText().contains("like email");
    }



    public void clickOkButton(){
        if (isElementPresent(By.xpath("//button[.='Ok']"))){
            click(By.xpath("//button[.='Ok']"));
        }
    }

}
