package com.sp.dao;
import java.util.List;
import com.sp.annotation.MyBatisRepository;
import com.sp.entity.Line2;

@MyBatisRepository
public interface Line2Dao {
    List<Line2> findAll(int page,Object results);
    int findCount(String str);
    float findLength(String str);
    float findType(String str,String str1);
}