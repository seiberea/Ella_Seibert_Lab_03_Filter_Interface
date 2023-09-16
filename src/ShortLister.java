import javax.swing.JFileChooser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) throws IOException
    {
        ShortWordFilter shortWord = new ShortWordFilter();

        System.out.println("Choose a file:");

        JFileChooser fileChoose = new JFileChooser();
        File toImport;
        String person;

        File workingDirectory = new File(System.getProperty("user.dir"));
        fileChoose.setCurrentDirectory(workingDirectory);

        if(fileChoose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            toImport = fileChoose.getSelectedFile();
            Path file = toImport.toPath();

            InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            System.out.println("\nWords from file that are 5 characters and under: ");
            while(reader.ready())
            {
                person = reader.readLine();

                if(!(shortWord.accept(person)))
                {
                    System.out.println(person);
                }
            }
            reader.close();
        }
        else
        {
            System.out.println("Failed to choose file. Try again.");
            System.exit(0);
        }
    }
}