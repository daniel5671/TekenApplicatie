package Interface;


import drawing.domain.Drawing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public interface PersistencyMediator {
    public Drawing load (String nameDrawing ) throws IOException, ClassNotFoundException, SQLException;
    public boolean save (Drawing drawing) throws IOException, SQLException;
    public boolean init (Properties props);
}
