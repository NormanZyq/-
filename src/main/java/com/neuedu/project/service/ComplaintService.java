package com.neuedu.project.service;

import com.neuedu.project.domain.Complaint;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 申诉的service层。
 * @author zyq
 */
@Service
public interface ComplaintService {

    /**
     * 添加申诉信息。
     *
     * @param complaint 申诉对象
     */
    void addComplaint(Complaint complaint);

    /**
     * 回复学生的申诉。
     *
     * @param complaintId  申诉ID
     * @param replyContent 回复内容
     */
    void replyComplaint(int complaintId, String replyContent);

    /**
     * 删除申诉记录。
     *
     * @param complaintId 申诉的ID
     */
    void deleteComplaint(int complaintId);

    List<Complaint> queryAll();
}
