package controller;

import model.Admin;
import view.AdminLoginView;

public class AdminController {

    private Admin admin;
    private AdminLoginView view;

    public AdminController(AdminLoginView view) {
        this.view = view;

        // Default admin account login ni
        this.admin = new Admin("admin", "admin123");
    }

    public boolean login() {

        view.displayLoginHeader();

        String username = view.getUsername();
        String password = view.getPassword();

        if (admin.getUsername().equals(username)
                && admin.getPassword().equals(password)) {

            view.displayLoginSuccess();
            return true;

        } else {

            view.displayLoginFailed();
            return false;
        }
    }
}
