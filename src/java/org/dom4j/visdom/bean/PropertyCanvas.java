/*
 * Copyright 2001 (C) MetaStuff, Ltd. All Rights Reserved.
 * 
 * This software is open source. 
 * See the bottom of this file for the licence.
 * 
 * $Id: PropertyCanvas.java,v 1.1.1.1 2001/05/22 08:12:39 jstrachan Exp $
 */

package org.dom4j.visdom.bean;

import org.dom4j.visdom.util.SwingUtils;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;

import sun.beans.editors.*;

public class PropertyCanvas extends Canvas implements MouseListener
{
    public PropertyCanvas(PropertyEditor propertyEditor)
    {
	    this.propertyEditor = propertyEditor;
	    addMouseListener(this);
    }

    public void
    paint(Graphics g)
    {
	    Rectangle box = new Rectangle(2, 2, getSize().width - 4, getSize().height - 4);
	    propertyEditor.paintValue(g, box);
    }

    public void mouseClicked(MouseEvent evt)
    {
    	if (! ignoreClick)
        {
	        try
            {
                ignoreClick = true;

                Point origin = getLocationOnScreen();
                int x = origin.x + evt.getX();
                int y = origin.y + evt.getY();
                //int x = frame.getLocation().x - 30;
                //int y = frame.getLocation().y + 50;
                new PropertyDialog( SwingUtils.getFrame( this ),
                                    propertyEditor,
                                    x,
                                    y);
            }
            finally
            {
                ignoreClick = false;
            }
    	}
    }

    public void mousePressed(MouseEvent evt)
    {
    }

    public void mouseReleased(MouseEvent evt)
    {
    }

    public void mouseEntered(MouseEvent evt)
    {
    }

    public void mouseExited(MouseEvent evt)
    {
    }

    private PropertyEditor propertyEditor;
    private static boolean ignoreClick = false;

}




/*
 * Redistribution and use of this software and associated documentation
 * ("Software"), with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * 1. Redistributions of source code must retain copyright
 *    statements and notices.  Redistributions must also contain a
 *    copy of this document.
 *
 * 2. Redistributions in binary form must reproduce the
 *    above copyright notice, this list of conditions and the
 *    following disclaimer in the documentation and/or other
 *    materials provided with the distribution.
 *
 * 3. The name "DOM4J" must not be used to endorse or promote
 *    products derived from this Software without prior written
 *    permission of MetaStuff, Ltd.  For written permission,
 *    please contact dom4j-info@metastuff.com.
 *
 * 4. Products derived from this Software may not be called "DOM4J"
 *    nor may "DOM4J" appear in their names without prior written
 *    permission of MetaStuff, Ltd. DOM4J is a registered
 *    trademark of MetaStuff, Ltd.
 *
 * 5. Due credit should be given to the DOM4J Project
 *    (http://dom4j.org/).
 *
 * THIS SOFTWARE IS PROVIDED BY METASTUFF, LTD. AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
 * METASTUFF, LTD. OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Copyright 2001 (C) MetaStuff, Ltd. All Rights Reserved.
 *
 * $Id: PropertyCanvas.java,v 1.1.1.1 2001/05/22 08:12:39 jstrachan Exp $
 */
