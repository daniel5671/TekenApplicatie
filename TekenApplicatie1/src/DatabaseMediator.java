import Interface.PersistencyMediator;
import drawing.domain.Drawing;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DatabaseMediator implements PersistencyMediator {
    private Properties props;
    private Connection con;
    private Statement mystmt;

    private void closeConnection(){

    }

    private void initConnection() throws SQLException {
        String dbUrl = "jdbc:mysql://studmysql01.fhict.local/dbi347692";
        String user = "dbi347692";
        String password = "-----------";

        con = DriverManager.getConnection(dbUrl,user,password);
    }

    @Override
    public Drawing load(String nameDrawing) throws SQLException, IOException, ClassNotFoundException {

        initConnection();
        mystmt = con.createStatement();
        ResultSet result = mystmt.executeQuery("select drawing from drawing where id = 2");
        byte[] drawingInBytes;

        if (result.next()){
            drawingInBytes = (byte[])result.getObject(1);
            ByteArrayInputStream byteinputstream = new ByteArrayInputStream(drawingInBytes);
            ObjectInputStream objectinputstream = new ObjectInputStream(byteinputstream);
            Drawing drawing = (Drawing) objectinputstream.readObject();
            return drawing;
        }
        return null;
    }

    @Override
    public boolean save(Drawing drawing) throws SQLException, IOException {

        initConnection();
        String sql = "INSERT INTO drawing (drawing) values(?)";

        PreparedStatement statement = con.prepareStatement(sql);
        ByteArrayOutputStream byteoutputstream = new ByteArrayOutputStream();
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(byteoutputstream);
        objectoutputstream.writeObject(drawing);

        byte[] drawingInBytes = byteoutputstream.toByteArray();

        ByteArrayInputStream bytearrayinputsream = new ByteArrayInputStream(drawingInBytes);
        statement.setBinaryStream(1, bytearrayinputsream);
        statement.executeUpdate();
        return true;
    }

    @Override
    public boolean init(Properties props) {
        return false;
    }
}
