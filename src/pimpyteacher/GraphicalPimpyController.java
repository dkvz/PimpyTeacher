
package pimpyteacher;

import pimpy.*;
import UI.*;

/**
 *
 * @author Alain
 */
public class GraphicalPimpyController extends PimpyController {

    private JFrameTeacher mainFrame = null;
    private boolean displayed = false;

    public GraphicalPimpyController() {
        super(PimpyDatabase.SQLITE_MODE);
    }

    public GraphicalPimpyController(int databaseMode) {
        super(databaseMode);
    }

    public void startUI() {
        setMainFrame(new JFrameTeacher(this));
        getMainFrame().setLocationRelativeTo(null);
        getMainFrame().setVisible(true);
        setDisplayed(true);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * @return the mainFrame
     */
    public JFrameTeacher getMainFrame() {
        return mainFrame;
    }

    /**
     * @param mainFrame the mainFrame to set
     */
    public void setMainFrame(JFrameTeacher mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * @return the displayed
     */
    public boolean isDisplayed() {
        return displayed;
    }

    /**
     * @param displayed the displayed to set
     */
    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
    }

}
