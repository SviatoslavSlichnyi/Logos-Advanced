package ua.lviv.lgs.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@WebServlet("/buy")
public class BuyController extends HttpServlet {


    private Logger log = Logger.getLogger(BuyController.class);

    private BucketService bucketService;

    public BuyController() {
        bucketService = BucketServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        log.debug("id: " + id);
        int userId = (int) req.getSession().getAttribute("userId");
        LocalDateTime dateTime = LocalDateTime.now();
        Bucket bucket = new Bucket(userId, Integer.parseInt(id), dateTime);
        bucketService.save(bucket);
    }
}
