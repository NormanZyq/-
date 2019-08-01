package com.neuedu.project.service;

import com.neuedu.project.dao.ComplaintMapper;
import com.neuedu.project.domain.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    /**
     * mapper for complaint service.
     */
    private final ComplaintMapper complaintMapper;

    /**
     * force injection.
     * @param complaintMapper   mapper
     */
    @Autowired
    public ComplaintServiceImpl(ComplaintMapper complaintMapper) {
        this.complaintMapper = complaintMapper;
    }

    @Override
    public void addComplaint(Complaint complaint) {
        complaintMapper.addComplaint(complaint);
    }

    @Override
    public void replyComplaint(int complaintId, String replyContent) {
        // 新建一个对象，只设置reply属性和ID
        Complaint forReply = new Complaint();
        forReply.setComplainId(complaintId);
        forReply.setReply(replyContent);
        complaintMapper.updateComplaint(forReply);
    }

    @Override
    public void deleteComplaint(int complaintId) {
        complaintMapper.deleteComplaint(complaintId);
    }

    @Override
    public List<Complaint> queryAll() {
        return complaintMapper.queryAll();
    }
}
