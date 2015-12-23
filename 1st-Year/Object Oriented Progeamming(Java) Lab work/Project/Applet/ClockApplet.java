import java.applet.*;
import java.awt.*;
import java.util.Date;
public class ClockApplet extends Applet implements Runnable {
	Thread timerThread;
		public void start() {
			timerThread = new Thread(this, "Clock");
			timerThread.start();
		}
		public void stop() {
			if (timerThread == null)
				return;
			timerThread.stop();
			timerThread = null;
		}
	 
		public void run() {
			while (timerThread != null) {
				repaint();	// request a redraw
				try {
					timerThread.sleep(1000);
				} catch (InterruptedException e){ /* do nothing*/ }
			}
		}

		public void paint(Graphics g) {
			Date d = new Date();
			g.drawString(d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds(), 1, 10);
		}
	}
	

