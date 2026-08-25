package com.codecool.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NavbarComponent {
    private final Page page;

    private final Locator homeButton;
    private final Locator createButton;
    private final Locator searchBar;
    private final Locator loginButton;
    private final Locator registerButton;
    private final Locator logoutButton;

    public NavbarComponent(Page page) {
        this.page = page;

        this.homeButton = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName("Lexicon"));

        this.createButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Create"));

        this.searchBar = page.locator("input.search-input");

        this.loginButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Login"));

        this.registerButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Register"));

        this.logoutButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Logout"));


    }
    public void navigate () {
        page.navigate("http://localhost:5173/");
    }

    public void clickNavbarButton(String buttonName) {
        switch (buttonName) {
            case "Home":
                homeButton.click();
                break;
            case "Create":
                createButton.click();
                break;
            case "Login":
                loginButton.click();
                break;
            case "Register":
                registerButton.click();
                break;
            case "Logout":
                logoutButton.click();
                break;
            default:
                throw new IllegalArgumentException(
                        "Invalid button name: " + buttonName);
        }
    }
    public void search(String searchTerm) {
        searchBar.fill(searchTerm);
        searchBar.press("Enter");
    }
}
