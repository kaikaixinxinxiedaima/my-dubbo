package com.example.dubboserver.test.mapper;

import com.test.entity.Book;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Component
public interface BookMapper extends BaseMapper<Book> {


    int insertList(List<Book> books);

    List<Book> findByKeyWord(String keyword);

}
