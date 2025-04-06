package authentication.data.Sql;

import authentication.data.Sql.table.NameTable;
import authentication.data.Sql.table.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PostGreSQL<T> {
     Connection connect(String server, String dataBase, String userName, String password) throws SQLException;
    default void selectAllTable(Connection conn, NameTable nameTable)throws SQLException{};
    List<T> selectAllTableInPojo(Connection conn, NameTable nameTable) throws SQLException;
    default void createTable(Connection conn,String nameTable){};
    default void addValueInTable(Connection conn,String nameTable){};

}


