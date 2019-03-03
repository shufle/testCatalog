package com.example.testCatalog.mapper;

import com.example.testCatalog.model.BookInfo;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<BookInfo> {



    @Override
    public BookInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String title = rs.getString("book_title");
        String authorName = rs.getString("au_fio");


        return new BookInfo(id,title,authorName);
    }
}
