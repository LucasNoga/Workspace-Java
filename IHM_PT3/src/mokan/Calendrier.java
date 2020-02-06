package mokan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Calendrier extends JPanel {
	private static final long serialVersionUID = 1L;

	/**Annee*/
	protected int yy;

	/**Mois et jour*/
	protected int mm, dd;

	/**Ensemble des boutons afficher*/
	protected JButton labs[][];

	/** Nombre de jours a laisse blanc au debut du mois*/
	protected int leadGap = 0;

	/**Objet Calendrier a utiliser tout au long*/
	Calendar calendar = new GregorianCalendar();

	/**Annee actuelle*/
	protected final int thisYear = calendar.get(Calendar.YEAR);

	/**Mois actuel*/
	protected final int thisMonth = calendar.get(Calendar.MONTH);

	/**Un des bouttons. Nous gardons juste en reference pour getBackground().*/
	private JButton b0;

	/**Mois choisi*/
	private JComboBox monthChoice;

	/**Annee choisie*/
	private JComboBox yearChoice;

	/**
	 * Appelle un Cal, commencant avec aujourdhui.
	 */
	Calendrier() {
		super();
		setYYMMDD(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
		buildGUI();
		recompute();
	}

	/**
	 * Construit un Cal, donnant le jour principal et le nombre total de jours
	 *
	 * @exception IllegalArgumentException
	 *                If year out of range
	 */
	Calendrier(int year, int month, int today) {
		super();
		setYYMMDD(year, month, today);
		buildGUI();
		recompute();
	}

	private void setYYMMDD(int year, int month, int today) {
		yy = year;
		mm = month;
		dd = today;
	}

	String[] months = { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin",
			"Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre" };

	/**Construit GUI. Suppose que setYYMMDD a ete appele. */
	private void buildGUI() {
		getAccessibleContext().setAccessibleDescription(
				"Calendar not accessible yet. Sorry!");
		setBorder(BorderFactory.createEtchedBorder());

		setLayout(new BorderLayout());

		JPanel tp = new JPanel();
		tp.add(monthChoice = new JComboBox());
		for (int i = 0; i < months.length; i++)
			monthChoice.addItem(months[i]);
		monthChoice.setSelectedItem(months[mm]);
		monthChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int i = monthChoice.getSelectedIndex();
				if (i >= 0) {
					mm = i;
					// System.out.println("Month=" + mm);
					recompute();
				}
			}
		});
		monthChoice.getAccessibleContext().setAccessibleName("Months");
		monthChoice.getAccessibleContext().setAccessibleDescription(
				"Choose a month of the year");

		tp.add(yearChoice = new JComboBox());
		yearChoice.setEditable(true);
		for (int i = yy - 5; i < yy + 5; i++)
			yearChoice.addItem(Integer.toString(i));
		yearChoice.setSelectedItem(Integer.toString(yy));
		yearChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int i = yearChoice.getSelectedIndex();
				if (i >= 0) {
					yy = Integer.parseInt(yearChoice.getSelectedItem()
							.toString());
					recompute();
				}
			}
		});
		add(BorderLayout.CENTER, tp);

		JPanel bp = new JPanel();
		bp.setLayout(new GridLayout(7, 7));
		labs = new JButton[6][7];

		bp.add(b0 = new JButton("D"));
		bp.add(new JButton("L"));
		bp.add(new JButton("M"));
		bp.add(new JButton("M"));
		bp.add(new JButton("J"));
		bp.add(new JButton("V"));
		bp.add(new JButton("S"));

		ActionListener dateSetter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = e.getActionCommand();
				if (!num.equals("")) {
					// set the current day highlighted
					setDayActive(Integer.parseInt(num));
					// When this becomes a Bean, you can
					// fire some kind of DateChanged event here.
					// Also, build a similar daySetter for day-of-week btns.
				}
			}
		};

		// Construct all the buttons, and add them.
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++) {
				bp.add(labs[i][j] = new JButton(""));
				labs[i][j].addActionListener(dateSetter);
			}
		add(BorderLayout.SOUTH, bp);
	}

	public final static int dom[] = { 31, 28, 31, 30, /* jan feb mar apr */
		31, 30, 31, 31, /* may jun jul aug */
		30, 31, 30, 31 /* sep oct nov dec */
	};

	/**Calcule ou mettre les jour dans le Cal panel */
	protected void recompute() {
		if (mm < 0 || mm > 11)
			throw new IllegalArgumentException("Month " + mm
					+ " bad, must be 0-11");
		clearDayActive();
		calendar = new GregorianCalendar(yy, mm, dd);

		leadGap = new GregorianCalendar(yy, mm, 1).get(Calendar.DAY_OF_WEEK) - 1;

		int daysInMonth = dom[mm];
		if (isLeap(calendar.get(Calendar.YEAR)) & mm > 1)
			++daysInMonth;

		for (int i = 0; i < leadGap; i++) {
			labs[0][i].setText("");
		}

		for (int i = 1; i <= daysInMonth; i++) {
			JButton b = labs[(leadGap + i - 1) / 7][(leadGap + i - 1) % 7];
			b.setText(Integer.toString(i));
		}

		for (int i = leadGap + 1 + daysInMonth; i < 6 * 7; i++) {
			labs[(i) / 7][(i) % 7].setText("");
		}

		if (thisYear == yy & mm == thisMonth)
			setDayActive(dd); 

		repaint();
	}

	/**isLeap() retourne vrai si l annee donnee est une année bissextile.*/
	public boolean isLeap(int year) {
		if (year % 4 == 0 & year % 100 != 0 || year % 400 == 0)
			return true;
		return false;
	}

	/**Defini l annee, le mois, et le jour */
	public void setDate(int yy, int mm, int dd) {
		this.yy = yy;
		this.mm = mm; // starts at 0, like Date
		this.dd = dd;
		recompute();
	}

	/** Unset tout jour souligne precedemment */
	private void clearDayActive() {
		JButton b;
		if (activeDay > 0) {
			b = labs[(leadGap + activeDay - 1) / 7][(leadGap + activeDay - 1) % 7];
			b.setBackground(b0.getBackground());
			b.repaint();
			activeDay = -1;
		}
	}

	private int activeDay = -1;

	/**Defini juste le jour dans le mois courant */
	public void setDayActive(int newDay) {

		clearDayActive();
		if (newDay <= 0)
			dd = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		else
			dd = newDay;
		Component square = labs[(leadGap + newDay - 1) / 7][(leadGap + newDay - 1) % 7];
		square.setBackground(Color.red);
		square.repaint();
		activeDay = newDay;
	}
	
	public String getDate(int jour, int mois, int annee){
		return jour +"/"+ mois +"/"+ annee;
	}

	/**Recupere l'annee*/
	public int getYear(){
		return yy;
	}

	/**Recupere le mois*/
	public int getMonth(){
		return mm;
	}

	/**Recupere le jour*/
	public int getDay(){
		return dd;
	}	
}