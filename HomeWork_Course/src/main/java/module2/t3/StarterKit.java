package module2.t3;

import module2.t2.*;

/**
 * This starter Kit is a "static" in meaning, that we have list of possible classes, that we must declare
 * when creating StartingKit. Another Realisation will be used in task 4 - it will be simple List implementation.
 */
public class StarterKit {
    private Pencil pencil;
    private Pen pen;
    private Ruler ruler;
    private Eraser eraser;

    StarterKit(Pen pen, Pencil pencil, Ruler ruler, Eraser eraser) {
        this.eraser = eraser;
        this.pen = pen;
        this.ruler = ruler;
        this.pencil = pencil;
    }

    public Pencil getPencil() {
        return pencil;
    }

    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public Ruler getRuler() {
        return ruler;
    }

    public void setRuler(Ruler ruler) {
        this.ruler = ruler;
    }

    public Eraser getEraser() {
        return eraser;
    }

    public void setEraser(Eraser eraser) {
        this.eraser = eraser;
    }

    public String toString() {
        return "Starter Kit: pen:" + pen.toString() + ", pencil: " + pencil.toString()
                + ", ruler: " + ruler.toString() + ", eraser: " + eraser.toString();
    }
}
