package aspire.interview;

import java.sql.*;

public class SqlTest {


    public int numOfProduct(){
        String sql="SELECT COUNT(*) AS count FROM products";
        return count(sql);
    }
    public int numOfProductLessThanFive(){
        String sql="SELECT COUNT(*) AS count FROM productsprice where productprice<5";
        return count(sql);
    }
    public String leastExpensiveProduct(){
        String s1="";
        Connection connection=getConnection();
        if(connection!=null){
            String sql="SELECT s.productname,p.productprice FROM products s,productsprice p where s.productid=(SELECT p.productid FROM productsprice p where p.productprice=(SELECT MIN(p.productprice)FROM productsprice p))AND p.productprice=(SELECT MIN(p.productprice)FROM productsprice p);";

            try {
                PreparedStatement preparedStatement=connection.prepareCall(sql);
                ResultSet resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    s1+="Product is: "+resultSet.getString("productname")+" with price is: "+resultSet.getFloat("productprice")+" ";
                }
                resultSet.close();
                preparedStatement.close();
            } catch (Exception e) {
                System.out.println(e);
            }finally {
                closeConnection(connection);
            }
        }
        return s1;
    }
    private   Connection getConnection()  {
        Connection connection= null;
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/aspire","ahmadsailik","123456");

        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
    private void closeConnection(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    private int count(String sqlQueries){
        int num=0;
        Connection connection=getConnection();
        if(connection!=null){
            String sql=sqlQueries;

            try {
                PreparedStatement preparedStatement=connection.prepareCall(sql);
                ResultSet resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    num=resultSet.getInt("count");
                }
                resultSet.close();
                preparedStatement.close();
            } catch (Exception e) {
                System.out.println(e);
            }finally {
                closeConnection(connection);
            }
        }
        return num;
    }

}
