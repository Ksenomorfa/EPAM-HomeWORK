package module1.t6;

/**
 * Class of Notebook and main class for this module.
 * Needed size of Notebook is given in constructor
 * We don't have stack or anything else here, so if Notes are deleted we don't
 * move pointers, counter isn't update in it.
 * UPD: Realized counter update and moving Notes when deleting.
 */
public class Notebook {
    private Note[] notes;
    private int last = 0;
    private int size;

    public Notebook(int size) {
        this.size = size;
        notes = new Note[size];
    }

    /**
     * Method adds Note to Notebook and increases last index (number) of Note for next Note
     *
     * @param note - the ready Note which we want to add to Notebook
     */
    public void addNote(Note note) {
        if (last < size) {
            note.setNumber(last);
            notes[last] = note;
            System.out.println("I have added note: " + note.toString());
            last++;
        } else {
            System.out.println("I can't add Note in that Notebook, it is full. Please, create another Notebook.");
        }
    }

    /**
     * Method edits
     *
     * @param note - name of Note that we want to edit
     * @param str  - edited text of Note
     */
    public void editNote(Note note, String str) {
        note.setStringNote(str);
        System.out.println("I have edited note: " + note.toString());
    }

    /**
     * Method cleans reference to Note that equals params.
     * Numbers of all Notes are renumbered if deleted
     * @param note - name of Note which we want to delete.
     */
    public void deleteNote(Note note) {
        int number = note.getNumber();
        int maxNumber = 0;
        for (Note i : notes) {
            if ((i != null) && (i.equals(note))) {
                notes[number] = null;
                int j = number;
                while ((j<size-1)&&(notes[j+1]!=null)) {
                        notes[j + 1].setNumber(j);
                        notes[j] = notes[j + 1];
                        maxNumber = j+1;
                        j++;
                }
                notes[maxNumber] = null;
                last--;
            }
        }
    }

    /**
     * Method prints list of all Notes that aren't null. Maybe it isn't clean code...
     */
    public void showAllNotes() {
        System.out.println("Here is list of all notes:");
        boolean isNotebookClean = true;
        for (Note i : notes) {
            if (i != null) {
                System.out.println(i);
                isNotebookClean = false;
            }
        }
        if (isNotebookClean) {
            System.out.println("Notebook is clean.");
        }
    }

    public static void main(String[] args) {
        int sizeOfNotebook = 10;
        Notebook notebook = new Notebook(sizeOfNotebook);

        Note note1 = new Note("I want to add something to this beatiful notebook.");
        Note note2 = new Note("And something else for example.");

        notebook.addNote(note1);
        notebook.addNote(note2);
        notebook.showAllNotes(); // 2 notes

        notebook.editNote(note2, "I have edited this note without marker.");

        notebook.deleteNote(note1); // delete first
        notebook.showAllNotes(); // 1 note displayed

        notebook.deleteNote(note2); // delete second
        notebook.showAllNotes(); // clean Notebook

        Note note3 = new Note("I want to add anuthing else for note3.");
        Note note4 = new Note("And for note 4.");
        notebook.addNote(note3);
        notebook.editNote(note3, "I have edited this note without marker second.");
        notebook.addNote(note4);
        notebook.showAllNotes(); // Notes are numbered from 0
    }
}
