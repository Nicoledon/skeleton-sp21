package capers;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static capers.Utils.*;

/** A repository for Capers 
 * @author TODO
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = join("." , ".capers"); // TODO Hint: look at the `join`
                                            //      function in Utils

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        // TODO
         File dir = new File(".capers");
         if(!dir.exists()){
              if(!dir.mkdir()) {
                  System.out.println("Error at mkdir");
              }
         }
         File dogs = new File("./.capers/dogs");
         File story = new File ("./.capers/story");
         try{
             if (!story.exists()){
                 if(!story.createNewFile()) {
                     System.out.println("error in create new file");
                 }
             }
             if(!dogs.exists()){
                 if(!dogs.mkdir()) {
                     System.out.println("Error at dogs");
                 }
             }
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) { //
        // TODO
        String temp = readContentsAsString(join(CAPERS_FOLDER , "story"));
        writeContents(join(CAPERS_FOLDER , "story"),temp,text + "\n");

        String content = readContentsAsString(join(CAPERS_FOLDER , "story"));
        System.out.println(content);
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) throws IOException {
        // TODO
        Dog dog = new Dog(name , breed , age);
        dog.saveDog();
//        System.out.println("Woof! My name is "+name+" and I am a "+breed+"! I am "+age+" years old! Woof!");
        System.out.println(dog.toString());
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) throws IOException {
        // TODO
        Dog dog = Dog.fromFile(name);
        dog.haveBirthday();
        dog.saveDog();
    }
}
