package com.neuedu.project.dao;

import com.neuedu.project.domain.Complaint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mapper for complaints.
 */
@Mapper
public interface ComplaintMapper {

    /**
     * add a new complaint.
     * @param complaint complaint object
     */
    void addComplaint(Complaint complaint);

    /**
     * 更新申诉表的某一行，可以用来增加申诉的回复等.
     * @param complaint 申诉类的对象
     */
    void updateComplaint(Complaint complaint);

    void deleteComplaint(int id);

    List<Complaint> queryAll();

}
