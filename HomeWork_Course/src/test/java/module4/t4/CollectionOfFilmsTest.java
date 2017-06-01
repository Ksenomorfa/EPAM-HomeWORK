package module4.t4;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

public class CollectionOfFilmsTest {
        CollectionOfFilms collectionOfFilms;
    private CollectionOfFilms collectionOfFilmsSerializable;
    private File file = new File("out\\serializableCollection");

//    This code is for first initialize Collection with values and first serialization.
//    After first serialisation we can work with serializableFile and comment this
//    @Test
//    public void testAddDeleteChangeMap() throws IOException {
//        collectionOfFilms = new CollectionOfFilms();
//        collectionOfFilms.addFilm("The Matrix", new TreeSet<>(Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss")));
//        collectionOfFilms.addFilm("The Thirteenth Floor", new TreeSet<>(Arrays.asList("Craig Bierko", "Armin Mueller-Stahl", "Gretchen Mol")));
//        collectionOfFilms.addFilm("Dark City", new TreeSet<>(Arrays.asList("Rufus Sewell", "Kiefer Sutherland", "Jennifer Connelly")));
//        collectionOfFilms.addFilm("Gattaca", new TreeSet<>(Arrays.asList("Ethan Hawke", "Jude Law", "Uma Thurman")));
//        collectionOfFilms.addFilm("Contact", new TreeSet<>(Arrays.asList("Jodie Foster", "Matthew McConaughey")));
//        collectionOfFilms.addFilm("Moon", new TreeSet<>(Arrays.asList("Sam Rockwell", "Kevin Spacey")));
//        collectionOfFilms.addFilm("Sunshine", new TreeSet<>(Arrays.asList("Cillian Murphy", "Rose Byrne", "Chris Evans")));
//        collectionOfFilms.addFilm("EXistenZ", new TreeSet<>(Arrays.asList("Jude Law", "Jennifer Jason Leigh", "Ian Holm")));
//        System.out.println(collectionOfFilms);

//        FileOutputStream outputStream = new FileOutputStream(file);
//        Object collSave = collectionOfFilms;
//        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
//        oos.writeObject(collSave);
//    }

    @Test
    public void deserialize() throws IOException, ClassNotFoundException {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            while (inputStream.available() > 0) {
                collectionOfFilmsSerializable = (CollectionOfFilms) ois.readObject();
            }
        }
    }

    @Test
    public void serialize() throws IOException, ClassNotFoundException {
        FileOutputStream outputStream = new FileOutputStream(file);
        Object collSave = collectionOfFilmsSerializable;
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(collSave);
    }

    @Test
    public void workWithCollection() throws IOException, ClassNotFoundException {
        deserialize();
        System.out.println(collectionOfFilmsSerializable);

        collectionOfFilmsSerializable.deleteFilm("The Matrix");
        collectionOfFilmsSerializable.addFilm("Equilibrium", new TreeSet<>(Arrays.asList("Christian Bale", "Sean Bean")));
        collectionOfFilmsSerializable.addFilm("The Matrix", new TreeSet<>(Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss")));
        collectionOfFilmsSerializable.changeAllActorsInFilm("Moon", new TreeSet<>(Arrays.asList("Jodie Foster", "Matthew McConaughey")));
        collectionOfFilmsSerializable.deleteFilm("Sunshine");
        collectionOfFilmsSerializable.deleteActorFromFilm("Moon", "Matthew McConaughey");
        collectionOfFilmsSerializable.changeOneActorInFilm("Moon", "Jodie Foster", "Sam Rockwell");
        collectionOfFilmsSerializable.addFilm("Sunshine", new TreeSet<>(Arrays.asList("Cillian Murphy", "Rose Byrne", "Chris Evans")));
        collectionOfFilmsSerializable.addActorToFilm("Moon", "Kevin Spacey");
        collectionOfFilmsSerializable.addActorToFilm("The Matrix", "Hugo Weaving");

        System.out.println(collectionOfFilmsSerializable);
        serialize();
    }
}