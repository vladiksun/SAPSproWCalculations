package SAPSproWCalculations;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.DefaultEditorKit;

class CopyPopUpMenu extends JPopupMenu {

	private JMenuItem copyItem;

    CopyPopUpMenu(){
        copyItem = new JMenuItem(new DefaultEditorKit.CopyAction());  
        add(copyItem);
    }
}
