import Interface.PersistencyMediator;
import drawing.domain.Drawing;

import java.io.*;
import java.util.Properties;

public class SerializationMediator implements PersistencyMediator {
    private Properties props;

    @Override
    public Drawing load(String nameDrawing) throws IOException, ClassNotFoundException {

            InputStream file = new FileInputStream("./res/" + nameDrawing);
            ObjectInput input = new ObjectInputStream(file);

            return (Drawing)input.readObject();
    }

    @Override
    public boolean save(Drawing drawing) throws IOException {

        try{
            OutputStream file = new FileOutputStream("./res/drawing.ser");
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(drawing);
            file.close();
            output.close();

            return true;
        }
        catch(IOException ex){
            return false;
        }
    }

    @Override
    public boolean init(Properties props) {
        return false;
    }
}
