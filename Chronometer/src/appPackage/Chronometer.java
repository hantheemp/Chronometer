package appPackage;

import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chronometer {
	private Timer timer;
	private int seconds;
	private JLabel label;

	public Chronometer(JLabel label) {
		this.label = label;
	}

	public void start() {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds++;
				updateLabel();
			}
		});
		timer.start();
	}

	public void stop() {
		timer.stop();
	}

	public void reset() {
		seconds = 0;
		updateLabel();
	}

	private void updateLabel() {
		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		int secs = seconds % 60;
		String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
		label.setText(time);
	}
}