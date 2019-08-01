package com.neuedu.project.controller;

import com.neuedu.project.domain.Complaint;
import com.neuedu.project.service.ComplaintService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 申诉的controller。
 *
 * @author zyq
 */
@Controller
@RequestMapping("/complaint")
public final class ComplaintController {

    /**
     * logger for this class.
     */
    private final Logger log = Logger.getLogger(ComplaintController.class);

    /**
     * service for complaint controller.
     */
    private final ComplaintService complaintService;

    /**
     * force injection.
     *
     * @param complaintService service
     */
    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    /**
     * add a complaint.
     *
     * @param session session
     * @param testId  test id
     * @param content complaint content
     * @return tips
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public String complain(HttpSession session, Integer testId, String content) {
        Object obj = session.getAttribute("loggedId");
        if (obj == null) {
            return "登录过期，请重新登录。";
        } else {
            String studentId = (String) obj;
            Complaint newComplaint = new Complaint();
            newComplaint.setStudentId(studentId);
            newComplaint.setTestId(testId);
            newComplaint.setContent(content);

            complaintService.addComplaint(newComplaint);
            return "添加申诉信息成功，请等待回复";
        }


    }

    /**
     * reply to a complaint.
     *
     * @param complaintId complaint id
     * @param reply       reply content
     * @return tip
     */
    @PostMapping(value = "/reply")
    @ResponseBody
    public String reply(int complaintId, String reply) {
        complaintService.replyComplaint(complaintId, reply);
        return "成功";
    }

    /**
     * get all complaints.
     *
     * @return a list of complaint
     */
    @GetMapping(value = "/get/all")
    @ResponseBody
    public List<Complaint> queryAll() {
        return complaintService.queryAll();
    }

}
