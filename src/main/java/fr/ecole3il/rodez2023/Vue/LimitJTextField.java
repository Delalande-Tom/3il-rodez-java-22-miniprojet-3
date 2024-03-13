package fr.ecole3il.rodez2023.Vue;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitJTextField  extends PlainDocument {

    private final int max;
    public LimitJTextField(int max) {
        super();
        this.max = max;
    }

    /**
     *
     * @param offset the starting offset &gt;= 0
     * @param text the string to insert; does nothing with null/empty strings
     * @param attr the attributes for the inserted content
     * @throws BadLocationException
     */
    public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
        if (text == null)
            return;
        if ((getLength() + text.length()) <= max && text.matches("[a-zA-Zéè-]+")) {
            super.insertString(offset, text, attr);
        }
    }
}
