package SAPSproWCalculations;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.DefaultEditorKit;

public class CopyPopUpMenu extends JPopupMenu {

	JMenuItem copyItem;
    public CopyPopUpMenu(){
        copyItem = new JMenuItem(new DefaultEditorKit.CopyAction());  
        add(copyItem);
    }
}
