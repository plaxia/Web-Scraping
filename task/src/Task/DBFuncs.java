package Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBFuncs {
    public Connection connect_to_db(String dbname,String user,String pass){
        Connection conn=null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,user,pass);
            if(conn!=null){
                System.out.println("Connection Established");
            }
            else{
                System.out.println("Connection Failed");
            }
        }catch(Exception e){

        }
        return conn;
    }

    public void createTable(Connection conn,String table_name){
        Statement statement;
        //marka,model,islemcitipi,bellek,ram,fiyat
        try{
            String query="create table "+table_name+"(marka_model varchar(200),modelno varchar(200),islemcitipi varchar(200),islemcinesli varchar(200),disk_turu varchar(200),bellek varchar(200),ram varchar(200),ekran_boyutu varchar(200),isletim_sistemi varchar(200),fiyat varchar(200),site varchar(200),link varchar(200),primary key(modelno))";
            statement=conn.createStatement();
            statement.executeUpdate(query);
           // System.out.println("Table created");

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void insertRow(Connection conn ,String table_name,String marka_model,String modelno,String islemcitipi,String islemcinesli,String disk_turu,String bellek,String ram,String ekran_boyutu,String isletim_sistemi,String fiyat,String site,String link){
       Statement statement;
        try{
                String query=String.format("insert into %s(marka_model,modelno,islemcitipi,islemcinesli,disk_turu,bellek,ram,ekran_boyutu,isletim_sistemi,fiyat,site,link) values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');",table_name,marka_model,modelno,islemcitipi,islemcinesli,disk_turu,bellek,ram,ekran_boyutu,isletim_sistemi,fiyat,site,link);
        statement=conn.createStatement();
        statement.executeUpdate(query);
           System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println("Inserted failed");
            System.out.println(e);
        }
    }
}

