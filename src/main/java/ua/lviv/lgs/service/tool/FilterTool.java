package ua.lviv.lgs.service.tool;

public interface FilterTool {

    boolean isAuthorized();

    boolean isAuthorizedAs(String role);

    void redirect(String page);

}
