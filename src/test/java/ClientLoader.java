/**
 * Copyright (c) 2016 Kyle Fricilone
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

/**
 * @author Kyle Fricilone
 * @date Jun 19, 2016
 */
public class ClientLoader implements AppletStub {

    public static final boolean rsps = true;

    private final String host = rsps ? "127.0.0.1" : "oldschool5.runescape.com";

    private final Map<String, String> params = new HashMap<>();

    public static void main(final String[] args) throws Exception {
        final ClientLoader applet = new ClientLoader();
        applet.initialize();

        final Class<?> client = Class.forName("Client");
        final Applet instance = (Applet) client.getConstructor().newInstance();

        final JFrame frame = new JFrame("BattleRune");
        frame.add(instance);
        frame.setVisible(true);
        frame.setSize(781, 541);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        client.getSuperclass().getMethod("setStub", AppletStub.class).invoke(instance, applet);
        client.getMethod("init").invoke(instance);
        client.getMethod("start").invoke(instance);
    }

    private void initialize() throws MalformedURLException, IOException {
        params.put("11", "ElZAIrq5NpKN6D3mDdihco3oPeYN2KFy2DCquj7JMmECPmLrDP3Bnw");
        params.put("12", "0");
        params.put("13", ".runescape.com");
        params.put("14", "1");
        params.put("15", "0");
        params.put("1", "true");
        params.put("2", "true");
        params.put("3", "false");
        params.put("4", "5");
        params.put("5", "0");
        params.put("6", "38663");
        params.put("7", "http://www.runescape.com/g=oldscape/slr.ws?order=LPWM");
        params.put("8", "350");
        params.put("9", "");
        params.put("10", "0");
    }

    @Override
    public String getParameter(final String paramName) {
        return params.get(paramName);
    }

    @Override
    public URL getDocumentBase() {
        try {
            return new URL("http://" + host);
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public URL getCodeBase() {
        try {
            return new URL("http://" + host);
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    @Override
    public void appletResize(final int width, final int height) {
    }

}
