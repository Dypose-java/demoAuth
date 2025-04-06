package authentication.data.Sql;

import authentication.data.Sql.table.NameTable;
import authentication.data.Sql.table.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainPostGreSQL implements PostGreSQL {
    static private final String SERVER = "localhost";
    static private final String DATA_BASE = "Test";
    static private final String USER_NAME = "postgres";
    static private final String PASSWORD = "dypose";

    @Override
    public Connection connect(String server, String dataBase, String userName, String password) {
        String uri = new StringBuilder()
                .append("jdbc:postgresql://")
                .append(server).append("/")
                .append(dataBase).toString();
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "dypose");
        try {
            Connection connection = DriverManager.getConnection(uri, props);
            System.out.println("connect true");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error connect", e);
        }
    }

    @Override
    public List<User> selectAllTableInPojo(Connection conn, NameTable nameTable) throws SQLException {
        Statement st = null;
        ResultSet rs = null;
        List<User> listUsers=new ArrayList<>();
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("Error connect", e);
        }

        try {
            rs = st.executeQuery("SELECT * FROM " + nameTable);
        } catch (SQLException e) {
            throw new RuntimeException("Error request", e);
        }

        while (rs.next()){
            switch (nameTable){
                case users:{
                    listUsers.add(new User(
                            rs.getString(1).trim(),
                            rs.getString(2).trim(),
                            rs.getString(3).trim()));
                    break;
                }
                case null_users:{
                    return List.of();
                }
                default: return List.of();
            }
        }
        conn.close();
        st.close();
        rs.close();
        return listUsers;
    }
    void setUserName(Connection connection,String newLogin) throws SQLException {
        PreparedStatement st = connection.prepareStatement("UPDATE users SET login=? WHERE id = ?");
        st.setString(1,newLogin);
        st.setInt(2,4);
        System.out.println(st.executeUpdate() + " rows update");
        st.close();
        connection.close();


    }
    void addNewUsers(Connection connection,String login,String password) throws SQLException {
        PreparedStatement st = connection.prepareStatement("insert into users(login,password) values(?,?)");
        st.setString(1,login);
        st.setString(2,password);
        System.out.println(st.executeUpdate() + " add new users");
        st.close();
        connection.close();
    }
    void getAllUsers(Connection connection) throws SQLException {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println(rs.getString(1).trim()+" ,"
                    +rs.getString(2).trim()+", "
                    +rs.getString(3));

        }
        rs.close();
        st.close();
    }

    public static void main(String[] args) throws SQLException {
        MainPostGreSQL mainPostGreSQL = new MainPostGreSQL();
        Connection connect = mainPostGreSQL.connect(SERVER, DATA_BASE, USER_NAME, PASSWORD);
        //mainPostGreSQL.addNewUsers(connect,"newLog","fsdfs");
        mainPostGreSQL.getAllUsers(connect);


    }
}
