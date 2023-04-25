package appPackage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MainFrame extends JFrame implements MouseListener {

	private JLabel chronometerLabel;

	private JButton startButton;

	private JButton stopButton;

	private JButton resetButton;

	private JPanel panelForButtons;

	private static Chronometer chronometer;

	private JButton lastButtonPressed;

	public MainFrame() {

		setTitle("Chronometer");

		this.chronometerLabel = new JLabel("00:00:00", SwingConstants.CENTER);

		chronometer = new Chronometer(chronometerLabel);

		this.startButton = new JButton("Start");

		this.startButton.addMouseListener(this);

		this.stopButton = new JButton("Stop");

		this.stopButton.addMouseListener(this);

		this.resetButton = new JButton("Reset");

		this.resetButton.addMouseListener(this);

		this.panelForButtons = new JPanel();

		this.panelForButtons.add(this.startButton);

		this.panelForButtons.add(this.stopButton);

		this.panelForButtons.add(this.resetButton);

		setLayout(new BorderLayout());

		add(this.panelForButtons, BorderLayout.SOUTH);

		add(this.chronometerLabel, BorderLayout.CENTER);

		this.panelForButtons.setLayout(new FlowLayout());

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		setSize(300, 300);

		setLocationRelativeTo(null);

		setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource().equals(this.startButton) && !e.getSource().equals(this.lastButtonPressed)) {

			chronometer.start();

			this.lastButtonPressed = this.startButton;

		}

		else if (e.getSource().equals(this.stopButton) && !e.getSource().equals(this.lastButtonPressed)) {

			chronometer.stop();

			this.lastButtonPressed = this.stopButton;

		}

		else if (e.getSource().equals(this.resetButton)) {

			chronometer.reset();

			this.lastButtonPressed = this.resetButton;

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
