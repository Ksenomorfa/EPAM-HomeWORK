package module1.t6;

/**
 * Class for Note - one record in Notebook with number and text.
 * Accepts text of Note as parameter in constructor. Empty constructor doesn't allow.
 */

public class Note {

    private String stringNote;
    private int number;

    Note(String str) {
        stringNote = str;
    }

    /**
     * Overriden method toString()
     *
     * @return string with number and text of Note
     */
    public String toString() {
        return "Note №:" + number + " " + stringNote;
    }

    /**
     * Equals only for Notes, not for all Objects with number and text
     *
     * @param note - with what Note we compare this Note
     * @return true if numbers and texts of Notes are equals, false if not
     */
    boolean equals(Note note) {
        return (number == note.number) && (stringNote.equals(note.stringNote));

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (null == o || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (number != note.number) return false;
        return stringNote != null ? stringNote.equals(note.stringNote) : note.stringNote == null;
    }

    @Override
    public int hashCode() {
        int result = stringNote != null ? stringNote.hashCode() : 0;
        result = 31 * result + number;
        return result;
    }

    int getNumber() {
        return number;
    }

    public String getStringNote() {
        return stringNote;
    }

    void setNumber(int number) {
        this.number = number;
    }

    void setStringNote(String str) {
        stringNote = str;
    }
}
