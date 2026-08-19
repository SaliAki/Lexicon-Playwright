package com.codecool.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private final Page page;


    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
    this.page = page;

    emailInput = page.getByLabel("email");
    passwordInput = page.getByLabel("password");

    loginButton = page.getByRole(
            AriaRole.BUTTON,
            new Page.GetByRoleOptions()
                    .setName("login")
    );
    }
    public void navigate () {
        page.navigate("http://localhost:5173/login");
    }

    public void login(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        loginButton.click();
    }

}
