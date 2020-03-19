package ua.lviv.lgs.service.tool;

import ua.lviv.lgs.controllers.enumeration.UserRole;

public interface FilterTool {

    boolean isAuthorized();

    boolean isAuthorizedAs(UserRole role);

    void redirect(String page);

}
