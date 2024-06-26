package org.yearup.data.mysql;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    public MySqlCategoryDao(DataSource dataSource)
    {
        super(dataSource);
    }

    //WOrks
    @Override
    public List<Category> getAllCategories()
    {
        // get all categories
        String query = "{CALL GetAllCategories}";

        List<Category> allCategories = new ArrayList<>();

        try(Connection conn = this.getConnection();
            CallableStatement cs = conn.prepareCall(query)){

            ResultSet row = cs.executeQuery();

            while(row.next()){
                Category category = mapRow(row);
                allCategories.add(category);
            }
        }
        catch (SQLException exception){
                throw new RuntimeException(exception);
        }
        return allCategories;
    }

    //WOrks
    @Override
    public Category getById(int categoryId)
    {
        // get category by id
        String query = "{CALL GetCategoryById(?)}";

        try(Connection conn = this.getConnection();
            CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1,categoryId);

            ResultSet row = cs.executeQuery();

            if(row.next()){
                return mapRow(row);
            }
        }
        catch (SQLException exception){
            throw new RuntimeException(exception);
        }
        return null;
    }

    //works PERFECTLY
    @Override
    public Category create(Category category)
    {
        // create a new category
        String query = "{CALL CreateCategory(?,?)}";

        try(Connection conn = this.getConnection()) {
            PreparedStatement cs = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            cs.setString(1, category.getName());
            cs.setString(2, category.getDescription());

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                return mapRow(rs);
            }
        }
        catch (SQLException exception){
            throw new RuntimeException(exception);
        }
        return null;
    }

    //WORKS~
    @Override
    public Category update(int categoryId, Category category)
    {
        // update category
        String query = "{CALL UpdateCategory(?,?,?)}";

        try(Connection conn = this.getConnection();
            CallableStatement cs = conn.prepareCall(query)){

            cs.setInt(1,categoryId);
            cs.setString(2,category.getName());
            cs.setString(3, category.getDescription());

            ResultSet row = cs.executeQuery();

            if (row.next()){
                return mapRow(row);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    //WORKS GOOD
    @Override
    public void delete(int categoryId)
    {
        // delete category
        String query = "{CALL DeleteCategory(?)}";

        try(Connection conn = this.getConnection();
        CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1,categoryId);

            cs.executeQuery();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
