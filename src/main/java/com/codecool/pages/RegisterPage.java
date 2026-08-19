package com.codecool.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class RegisterPage {

    private final Page page;

    private final Locator usernameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;

    private final Locator registerButton;

    public RegisterPage(Page page) {
        this.page = page;

        usernameInput = page.getByLabel("username");
        emailInput = page.getByLabel("email");
        passwordInput = page.getByLabel("password");
        confirmPasswordInput = page.getByLabel("confirmPassword");

        registerButton = page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Register")
        );
    }

    public void navigate() {
        page.navigate("http://localhost:5173/register");
    }

    public void register(String username, String email, String password, String confirmPassword) {
        usernameInput.fill(username);
        emailInput.fill(email);
        passwordInput.fill(password);
        confirmPasswordInput.fill(confirmPassword);
        registerButton.click();
    }


}
