package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerRecruitmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VolunteerRecruitmentServiceImpl implements VolunteerRecruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;
    @Override
    public Map<String,Object> findAll(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<VolunteerRecruitment> list = volunteerRecruitmentMapper.selectByExample(null);
        PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        if (pageInfo.getList() == null){
            map.put("message","志愿者获取失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data","{}");

            return map;
        }
        map.put("message","志愿者获取成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",pageInfo);
        return map;

    }

    @Override
    public Map<String, Object> add(VolunteerRecruitment volunteerRecruitment) {
        Map<String,Object> map = new HashMap<>();
        if (volunteerRecruitmentMapper.insert(volunteerRecruitment) != 1){
            map.put("message","志愿者添加失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","志愿者添加成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:","{}");
        return map;
    }

    @Override
    public Map<String, Object> delete(Long id) {
        Map<String,Object> map = new HashMap<>();
        if (volunteerRecruitmentMapper.deleteByPrimaryKey(id) != 1){
            map.put("message","志愿者删除失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","志愿者删除成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:","{}");
        return map;

    }

    @Override
    public Map<String, Object> update(VolunteerRecruitment volunteerRecruitment) {
        Map<String,Object> map = new HashMap<>();
        if (volunteerRecruitmentMapper.updateByPrimaryKey(volunteerRecruitment) != 1){
            map.put("message","志愿者修改失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","志愿者修改成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:","{}");
        return map;
    }

    @Override
    public Map<String, Object> click(Long id, Date lastClickTime) {
        Map<String,Object> map = new HashMap<>();
        if (volunteerRecruitmentMapper.click(id,lastClickTime) != 1){
            map.put("message","设置失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","设置成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:","{}");
        return map;

    }
}
