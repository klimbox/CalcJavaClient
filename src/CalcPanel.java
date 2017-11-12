import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcPanel extends JPanel
{
    String whatToDo = "";
    int fNum = 0;
    private JButton numbers[] = new JButton[10];
    private JTextField output = new JTextField();
    public JButton backspace = new JButton("<");
    private JButton equ = new JButton("=");
    private JButton plus = new JButton("+"),minus = new JButton("-"),multy = new JButton("*"),div = new JButton("/");

    public CalcPanel()
    {
        setLayout(null);

        backspace.setBounds(10, 250, 50, 50);
        add(backspace);
        equ.setBounds(130, 250, 50, 50);
        add(equ);
        plus.setBounds(190, 70, 50, 50);
        add(plus);
        minus.setBounds(190, 130, 50, 50);
        add(minus);
        multy.setBounds(190, 190, 50, 50);
        add(multy);
        div.setBounds(190, 250, 50, 50);
        add(div);
        backspace.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                whatToDo = "";
                fNum = 0;
                output.setText("");
            }
        });
        plus.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                whatToDo = "+";
                fNum = Integer.parseInt(output.getText());
                output.setText("");

            }
        });
        minus.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                whatToDo = "-";
                fNum = Integer.parseInt(output.getText());
                output.setText("");
            }
        });
        multy.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                whatToDo = "*";
                fNum = Integer.parseInt(output.getText());
                output.setText("");
            }
        });
        div.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                whatToDo = "/";
                fNum = Integer.parseInt(output.getText());
                output.setText("");
            }
        });
        equ.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                calculate calcOp = new calculate();
                int sNum = Integer.parseInt(output.getText());
                output.setText("");
                try
                {
                    output.setText(calcOp.sendPost(fNum , sNum ,whatToDo));
                }
                catch (Exception ie)
                {
                    output.setText("Can't connect to server");
                }

            }
        });
        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50, 50);
        add(numbers[0]);

        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                numbers[x * 3 + y + 1] = new JButton((x * 3 + y + 1) + "");
                numbers[x * 3 + y + 1].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50, 50);
                add(numbers[x * 3 + y + 1]);
            }
        }

        output.setBounds(10, 10, 230, 50);
        output.setEditable(false);
        add(output);

        ActionListener l = (ActionEvent e) ->
        {
            JButton b = (JButton)e.getSource();
            output.setText(output.getText() + b.getText());
        };

        for(JButton b : numbers)
        {
            b.addActionListener(l);
        }
    }
}
