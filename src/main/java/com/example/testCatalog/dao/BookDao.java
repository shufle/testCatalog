package com.example.testCatalog.dao;

import com.example.testCatalog.mapper.BookMapper;
import com.example.testCatalog.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;



@Repository

public class BookDao extends JdbcDaoSupport  {

    @Autowired
    public BookDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    private final String DEFAULT_QUERY = "SELECT * FROM schema.books";

    public List<BookInfo> listBooksFilteredByTitle(String title) {
        String sql;
        if (title.equals(""))
            sql = DEFAULT_QUERY+" ORDER BY book_title";
        else
            sql = String.format("SELECT * FROM schema.books WHERE book_title = '%s'", title);

        BookMapper mapper = new BookMapper();
        List<BookInfo> list = this.getJdbcTemplate().query(sql, mapper);

        return list;

    }

    public List<BookInfo> listBooksFilteredByAuthor(String author) {
        String sql;
        if (author.equals(""))
            sql = "SELECT min(id) as id, min (book_title) as book_title, au_fio FROM schema.books " +
                    "GROUP BY au_fio " +
                    "ORDER BY au_fio";
        else
            sql = String.format("SELECT * FROM schema.books WHERE au_fio = '%s'", author);

        BookMapper mapper = new BookMapper();
        List<BookInfo> list = this.getJdbcTemplate().query(sql,mapper);

        return list;
    }

}
