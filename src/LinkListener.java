import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.event.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

/**
 * This class sets up listeners for html links.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class LinkListener implements HyperlinkListener
{
    private JEditorPane _callback;
    
    public LinkListener(JEditorPane callback)
    {
        _callback = callback;
    }
    public void hyperlinkUpdate(HyperlinkEvent event)
    {
        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
        {
            try
            {
                _callback.setPage(event.getURL());
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
                _callback.setText("Page not available");
            }
        }
    }

}
